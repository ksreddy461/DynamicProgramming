package backtracking;

import java.util.HashSet;

public class ArraySubsets2 {

    public void subSets(int[] a, HashSet<Integer> partial, int pos, int K) {

        if (partial.size() == K) {
            System.out.println(partial);
            return;
        }

        if (pos == a.length) {
            return;
        }

        partial.add(a[pos]);
        subSets(a, partial, pos + 1, K);
        partial.remove(a[pos]);
        subSets(a, partial, pos + 1, K);

    }

    public static void main(String[] args) {

        int[] a = {3, 2, 5, 8};
        ArraySubsets2 arraySubsets = new ArraySubsets2();
        HashSet<Integer> partial = new HashSet<Integer>();
        arraySubsets.subSets(a, partial, 0, 3);

    }

}
