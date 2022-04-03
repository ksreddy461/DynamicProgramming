package binarysearch;

public class PositionOfAnElementInAnInfiniteSortedArray {

    public int position(int[] a, int target) {
        int s = 0, e = 1;
        while (a[e] < target) {
            s = e;
            e = 2 * e;
        }
        BinarySearch binarySearch = new BinarySearch();
        return binarySearch.bSearch(a, s, e, target);
    }

    public static void main(String[] args) {
        int[] a = new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        PositionOfAnElementInAnInfiniteSortedArray positionOfAnElementInAnInfiniteSortedArray =
                new PositionOfAnElementInAnInfiniteSortedArray();
        System.out.println("Ans is: " + positionOfAnElementInAnInfiniteSortedArray.position(a, 10));
    }
}
