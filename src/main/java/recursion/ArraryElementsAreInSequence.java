package recursion;

public class ArraryElementsAreInSequence {

    public boolean inSequence(int[] a, int pos) {
        if (pos == 0) {
            return true;
        }
        return (a[pos] - 1 == a[pos - 1] && inSequence(a, pos - 1));
    }

    public static void main(String[] args) {
        ArraryElementsAreInSequence arraryElementsAreInSequence = new ArraryElementsAreInSequence();
        int[] a = {2, 3, 4, 5, 6, 7, 8};
        int[] b = {2, 3, 4, 5, 6, 8};
        System.out.println("inSequence: " + arraryElementsAreInSequence.inSequence(a, a.length - 1));
        System.out.println("inSequence: " + arraryElementsAreInSequence.inSequence(b, b.length - 1));
    }
}
