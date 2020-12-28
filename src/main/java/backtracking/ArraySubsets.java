package backtracking;

import java.util.HashSet;

public class ArraySubsets {

    public void subSets(int[] a, HashSet<Integer> partial, int pos, int K) {

        if (K == partial.size()) {
            System.out.println(partial);
            return;
        }

        for (int i = pos; i < a.length; i++) {
            partial.add(a[i]);
            subSets(a, partial, i + 1, K);
            partial.remove(a[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 2, 5, 8};
        ArraySubsets arraySubsets = new ArraySubsets();
        HashSet<Integer> partial = new HashSet<Integer>();
        arraySubsets.subSets(a, partial, 0, 3);
    }
}
