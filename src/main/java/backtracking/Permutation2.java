package backtracking;

public class Permutation2 {
    public void permuationOfaNumber(int[] a, int pos) {
        if (pos == a.length) {
            for (int i = 0; i < a.length; i++) {
                System.out.print(a[i]);
            }
            System.out.println();
            return;
        }
        for (int i = pos; i < a.length; i++) {
            if (i > pos && a[i] == a[i - 1]) {
                continue;
            }
            swap(a, i, pos);
            permuationOfaNumber(a, pos + 1);
            swap(a, i, pos);
        }
    }

    private void swap(int[] a, int i, int j) {
        if (i != j) {
            a[i] = a[i] + a[j];
            a[j] = a[i] - a[j];
            a[i] = a[i] - a[j];
        }
    }

    public static void main(String args[]) {
        int[] a = {1, 1, 2, 3};
        Permutation2 permutation = new Permutation2();
        permutation.permuationOfaNumber(a, 0);
    }
}
