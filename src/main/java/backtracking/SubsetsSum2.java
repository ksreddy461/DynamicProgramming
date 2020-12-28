package backtracking;

import java.util.ArrayList;
import java.util.Arrays;


/*
Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
Example:

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True
There is a subset (4, 5) with sum 9.

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
Output: False
There is no subset that add up to 30.
 */
public class SubsetsSum2 {


    public void subSetsSum(int[] a, ArrayList<Integer> partial, int pos, int sumSoFar, int K) {

        if (sumSoFar == K) {
            System.out.println(Arrays.toString(partial.toArray()));
            return;
        }

        for (int i = pos; i < a.length; i++) {

            if (i > pos && a[i] == a[i - 1] || sumSoFar + a[i] > K) {
                continue;
            }
            partial.add(a[i]);
            sumSoFar += a[i];
            subSetsSum(a, partial, i + 1, sumSoFar, K);
            partial.remove(partial.size() - 1);
            sumSoFar -= a[i];
        }
    }

    public static void main(String[] args) {

        int[] a = {10, 1, 2, 7, 6, 1, 5, 1};
        SubsetsSum2 subsetsSum2 = new SubsetsSum2();
        ArrayList<Integer> partial = new ArrayList<Integer>();
        Arrays.sort(a);
        subsetsSum2.subSetsSum(a, partial, 0, 0, 9);

    }

}
