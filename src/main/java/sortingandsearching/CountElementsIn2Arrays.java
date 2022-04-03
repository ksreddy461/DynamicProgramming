package sortingandsearching;

import java.util.Arrays;

//https://www.youtube.com/watch?v=qE3RvSwfT9I&list=PL-Jc9J83PIiHhXKonZxk7gbEWsmSYP5kq&index=28
public class CountElementsIn2Arrays {

    private int ceil(int[] a, int target) {

        int n = a.length;
        int low = 0, high = n - 1;
        int res = 0;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (a[mid] <= target) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    public int[] solve(int[] a, int[] b) {

        int n = a.length;
        int[] res = new int[n];

        Arrays.sort(b);

        for (int i = 0; i < n; i++) {
            res[i] = ceil(b, a[i]) + 1;
        }
        return res;
    }

    public int[] solve2(int[] a, int[] b) {

        int m = a.length;
        int n = b.length;

        int aMax = Integer.MIN_VALUE;
        int bMax = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            aMax = Math.max(aMax, a[i]);
        }

        for (int i = 0; i < n; i++) {
            bMax = Math.max(bMax, b[i]);
        }

        int max = Math.max(aMax, bMax);

        int[] frequency = new int[max + 1];
        for (int i = 0; i < n; i++) {
            frequency[b[i]] = frequency[b[i]] + 1;
        }

        int[] pas = new int[max + 1];//prefix array sum
        pas[0] = frequency[0];
        for (int i = 1; i <= max; i++) {
            pas[i] = pas[i - 1] + frequency[i];
        }

        for (int i = 0; i < m; i++) {
            a[i] = pas[a[i]];
        }

        return a;
    }

    public static void main(String[] args) {

        CountElementsIn2Arrays countElementsIn2Arrays =
                new CountElementsIn2Arrays();

        int[] a = {1, 2, 3, 4, 7, 9};
        int[] b = {0, 1, 2, 1, 1, 4};

        System.out.println("Ans is : " + Arrays.toString(countElementsIn2Arrays.solve(a, b)));
        System.out.println("Ans is : " + Arrays.toString(countElementsIn2Arrays.solve2(a, b)));
    }
}
