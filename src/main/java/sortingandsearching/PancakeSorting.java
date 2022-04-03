package sortingandsearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/pancake-sorting/
public class PancakeSorting {

    private int maxIndex(int[] a, int position) {

        int max = position;
        for (int i = position - 1; i >= 0; i--) {
            if (a[max] < a[i]) {
                max = i;
            }
        }
        return max;
    }

    private void reverse(int[] a, int start, int end) {

        while (start < end) {
            int tmp = a[start];
            a[start] = a[end];
            a[end] = tmp;
            start++;
            end--;
        }
    }

    public List<Integer> pancakeSort(int[] arr) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>();

        for (int i = n - 1; i > 0; i--) {
            int maxIndex = maxIndex(arr, i);
            if (maxIndex != i) {
                if (maxIndex != 0) {
                    reverse(arr, 0, maxIndex);
                    res.add(maxIndex + 1);
                }
                reverse(arr, 0, i);
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PancakeSorting pancakeSorting = new PancakeSorting();

        int[] a = {3, 2, 4, 1};
        System.out.println("Ans is: " + Arrays.asList(pancakeSorting.pancakeSort(a)));
        System.out.println("Ans is: " + Arrays.toString(a));

        int[] b = {1, 2, 3};
        System.out.println("Ans is: " + Arrays.asList(pancakeSorting.pancakeSort(b)));
        System.out.println("Ans is: " + Arrays.toString(b));
    }
}
