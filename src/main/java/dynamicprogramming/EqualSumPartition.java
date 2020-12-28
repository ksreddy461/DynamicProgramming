package dynamicprogramming;


/*
Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is the same.

Examples:

arr[] = {1, 5, 11, 5}
Output: true
The array can be partitioned as {1, 5, 5} and {11}

arr[] = {1, 5, 3}
Output: false
The array cannot be partitioned into equal sum sets.
 */
public class EqualSumPartition {

    public boolean isEqualSumPartition(int[] a) {

        int arraySum = 0;
        for (int i = 0; i < a.length; i++) {
            arraySum += a[i];
        }

        if (arraySum % 2 == 0) {
            SubsetsSumBottomUp subsetsSumBottomUp = new SubsetsSumBottomUp();
            return subsetsSumBottomUp.subSetsSum(a, arraySum / 2);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 11, 5};
        int[] b = {0, 5, 3};
        EqualSumPartition equalSumPartition = new EqualSumPartition();
        System.out.println(equalSumPartition.isEqualSumPartition(a));
        System.out.println(equalSumPartition.isEqualSumPartition(b));
    }
}
