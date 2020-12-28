package dynamicprogramming;

public class SubsetsSumTopDown {

    public boolean subSetsSum(int[] a, int pos, int sum) {
        Boolean[][] cache = new Boolean[pos + 1][sum + 1];
        return subSetsSum(a, pos, sum, cache);
    }

    public boolean subSetsSum(int[] a, int pos, int sum, Boolean[][] cache) {

        if (sum == 0) {
            return true;
        }

        if (pos == 0) {
            return false;
        }

        if (cache[pos][sum] != null) {
            return cache[pos][sum];
        }

        if (sum >= a[pos - 1]) {
            boolean include = subSetsSum(a, pos - 1, sum - a[pos - 1]);
            boolean exclude = subSetsSum(a, pos - 1, sum);
            return (cache[pos][sum] = include || exclude);
        } else {
            return cache[pos][sum] = subSetsSum(a, pos - 1, sum);
        }
    }

    public static void main(String[] args) {
        int[] a = {10, 1, 2, 7, 6, 1, 5, 1};
        int[] b = {3, 34, 4, 12, 5, 2};
        SubsetsSumTopDown subsetsSumTopDown = new SubsetsSumTopDown();
        System.out.println(subsetsSumTopDown.subSetsSum(a, a.length, 34));
        System.out.println(subsetsSumTopDown.subSetsSum(b, b.length, 9));
        System.out.println(subsetsSumTopDown.subSetsSum(b, b.length, 30));
    }
}
