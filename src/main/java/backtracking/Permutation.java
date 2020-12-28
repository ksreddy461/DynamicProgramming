package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    public void permuationOfaNumber(int[] a, ArrayList<Integer> partial, boolean[] used) {
        if (partial.size() == a.length) {
            System.out.println(Arrays.toString(partial.toArray()));
            return;
        }
        for (int i = 0; i < a.length; i++) {
            if (!used[i]) {
                partial.add(a[i]);
                used[i] = true;
                permuationOfaNumber(a, partial, used);
                used[i] = false;
                partial.remove(partial.size() - 1);
            }
        }
    }

    public static void main(String args[]) {

        int[] a = {7,8,9};
        Permutation permutation = new Permutation();
        ArrayList<Integer> partial = new ArrayList<Integer>();
        boolean[] used = new boolean[3];
        permutation.permuationOfaNumber(a, partial, used);
    }
}
