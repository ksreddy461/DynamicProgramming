package backtracking;

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
public class SubsetsSum {

    public boolean subSetsSum(int[] a, int pos, int sum) {

        if (sum == 0) {
            return true;
        }

        if (pos == 0) {
            return false;
        }

        if (sum >= a[pos - 1]) {
            boolean include = subSetsSum(a, pos - 1, sum - a[pos - 1]);
            boolean exclude = subSetsSum(a, pos - 1, sum);
            return (include || exclude);
        } else {
            return subSetsSum(a, pos - 1, sum);
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 1, 2, 7, 6, 1, 5, 1};
        int[] b = {3, 34, 4, 12, 5, 2};
        SubsetsSum subsetsSum = new SubsetsSum();
        System.out.println(subsetsSum.subSetsSum(a, a.length, 35));
        System.out.println(subsetsSum.subSetsSum(b, b.length, 9));
        System.out.println(subsetsSum.subSetsSum(b, b.length, 30));
    }
}
