package sortingandsearching;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

//https://leetcode.com/problems/k-th-smallest-prime-fraction/
public class KthSmallestPrimeFraction {

    private class Pair implements Comparable<Pair> {

        double fraction;
        int element1;
        int element2;

        public Pair(double fraction, int element1, int element2) {
            this.fraction = fraction;
            this.element1 = element1;
            this.element2 = element2;
        }

        public double getFraction() {
            return fraction;
        }

        public void setFraction(double fraction) {
            this.fraction = fraction;
        }

        public int getElement1() {
            return element1;
        }

        public void setElement1(int element1) {
            this.element1 = element1;
        }

        public int getElement2() {
            return element2;
        }

        public void setElement2(int element2) {
            this.element2 = element2;
        }

        @Override
        public int compareTo(Pair o) {
            return (this.getElement1() * o.getElement2() - o.getElement1() * this.getElement2());
        }
    }

    public int[] solve(int[] arr, int k) {

        int n = arr.length;
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {

                if (maxHeap.size() < k) {
                    double d = arr[j] * 1.0 / arr[i];
                    maxHeap.add(new Pair(d, arr[j], arr[i]));
                } else if (maxHeap.size() == k) {
                    Pair pair = maxHeap.peek();
                    double d = arr[j] * 1.0 / arr[i];
                    if (pair.getFraction() > d) {
                        maxHeap.poll();
                        d = arr[j] * 1.0 / arr[i];
                        maxHeap.add(new Pair(d, arr[j], arr[i]));
                    }
                }
            }
        }

        Pair pair = maxHeap.peek();
        return new int[]{pair.getElement1(), pair.getElement2()};
    }

    public int[] solve2(int[] arr, int k) {
        double low = 0, high = 1.0;
        while (low <= high) {

            double mid = low + (high - low) / 2;
            int[] partialResult = getCountAndPQ(arr, mid);
            int count = partialResult[0];

            if (count > k) {
                high = mid;
            } else if (count < k) {
                low = mid;
            } else {
                return new int[]{partialResult[1], partialResult[2]};
            }

        }
        return new int[]{-1, -1};
    }

    private int[] getCountAndPQ(int[] arr, double threshold) {

        int n = arr.length;
        int p = arr[0], q = arr[n - 1];
        int i = 0, j = 1;

        int count = 0;

        for (j = 1; j < n; j++) {
            while (arr[i] <= threshold * arr[j]) {
                i++;
            }
            count += i;
            if (i > 0 && arr[i - 1] * q > arr[j] * p) {
                p = arr[i - 1];
                q = arr[j];
            }
        }

        return new int[]{count, p, q};
    }

    //Combined above 2 methods into 1
    public int[] solve3(int[] arr, int k) {
        int n = arr.length;

        double low = 0, high = 1.0;
        while (low <= high) {

            double mid = low + (high - low) / 2;
            int p = arr[0], q = arr[n - 1];
            int i = 0, j;
            int count = 0;
            for (j = 1; j < n; j++) {
                while (arr[i] <= mid * arr[j]) {
                    i++;
                }
                count += i;
                if (i > 0 && arr[i - 1] * q > arr[j] * p) {
                    p = arr[i - 1];
                    q = arr[j];
                }
            }

            if (count > k) {
                high = mid;
            } else if (count < k) {
                low = mid;
            } else {
                return new int[]{p, q};
            }

        }
        return new int[]{-1, -1};
    }


    public static void main(String[] args) {
        KthSmallestPrimeFraction kthSmallestPrimeFraction =
                new KthSmallestPrimeFraction();

        int[] a = {1, 2, 3, 5};
        int k = 3;
        System.out.println("Ans is: " + Arrays.toString(kthSmallestPrimeFraction.solve(a, k)));
        System.out.println("Ans is: " + Arrays.toString(kthSmallestPrimeFraction.solve2(a, k)));
        System.out.println("Ans is: " + Arrays.toString(kthSmallestPrimeFraction.solve3(a, k)));

        int[] b = {1, 7};
        k = 1;
        System.out.println("Ans is: " + Arrays.toString(kthSmallestPrimeFraction.solve(b, k)));
        System.out.println("Ans is: " + Arrays.toString(kthSmallestPrimeFraction.solve2(b, k)));
        System.out.println("Ans is: " + Arrays.toString(kthSmallestPrimeFraction.solve3(b, k)));
    }
}
