package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestElements {

    public List<Integer> BruteForce(Integer[] arr, int x, int k) {
        int n = arr.length;
        //Arrays.sort(arr);
        int pivot = 0;
        List<Integer> res = new ArrayList<>();
        //System.out.print("Closest Elements are: ");
        if (x <= arr[0]) {
            for (int i = 0; i < k; i++) {
                //System.out.print(arr[i] + " ");
                res.add(arr[i]);
            }
            Collections.sort(res);
            return res;
        }

        if (x >= arr[n - 1]) {
            for (int i = n - 1; i > n - 1 - k && i >= 0; i--) {
                //System.out.print(arr[i] + " ");
                res.add(arr[i]);
            }
            Collections.sort(res);
            return res;
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] >= x) {
                pivot = i - 1;
                break;
            }
        }

        if (pivot != 0) {
            int l = pivot;
            int h = l + 1;
            while (l >= 0 && h < n) {
                if (x - arr[l] <= arr[h] - x) {
                    //System.out.print(arr[l] + " ");
                    res.add(arr[l]);
                    l--;
                } else {
                    //System.out.print(arr[h] + " ");
                    res.add(arr[h]);
                    h++;
                }
                if (res.size() == k) {
                    Collections.sort(res);
                    return res;
                }
            }

            if (k > 0 && l > 0) {
                while (k > 0) {
                    res.add(arr[l]);
                    l--;
                    k--;
                    if (res.size() == k) {
                        Collections.sort(res);
                        return res;
                    }
                }
            }
            if (k > 0 && h < n) {
                while (k > 0) {
                    res.add(arr[h]);
                    if (res.size() == k) {
                        Collections.sort(res);
                        return res;
                    }
                    h++;
                    k--;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

    public class Pair implements Comparable<Pair> {
        private Integer diff;
        private Integer element;

        Pair(Integer diff, Integer element) {
            this.diff = diff;
            this.element = element;
        }

        public Integer getDiff() {
            return diff;
        }

        public void setDiff(Integer diff) {
            this.diff = diff;
        }

        public Integer getElement() {
            return element;
        }

        public void setElement(Integer element) {
            this.element = element;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.diff == o.diff) {
                return this.getElement() - o.getElement();
            }
            return this.getDiff() - o.getDiff();
        }
    }

    public List<Integer> solve(Integer[] arr, int x, int k) {

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int n = arr.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i < k) {
                maxHeap.add(new Pair(x - arr[i], arr[i]));
            } else {
                if (maxHeap.size() > 0 && maxHeap.peek().diff > Math.abs(x - arr[i])) {
                    maxHeap.poll();
                    maxHeap.add(new Pair(Math.abs(x - arr[i]), arr[i]));
                }
            }
        }

        //System.out.print("Closest Elements are: ");
        while (maxHeap.size() > 0) {
            Pair pair = maxHeap.peek();
            //System.out.print(pair.getElement() + " ");
            res.add(pair.getElement());
            maxHeap.poll();
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        KClosestElements kClosestElements = new KClosestElements();
        Integer[] arr = {12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56
        };
        int x = 35, k = 4;
        kClosestElements.BruteForce(arr, x, k);
        System.out.println();
        kClosestElements.solve(arr, x, k);
    }
}
