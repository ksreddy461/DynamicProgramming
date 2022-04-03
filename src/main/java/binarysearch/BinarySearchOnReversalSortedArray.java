package binarysearch;

public class BinarySearchOnReversalSortedArray {

    public int bSearch(int[] a, int target) {
        int n = a.length;
        int s = 0, e = n - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                e = mid - 1;
            } else if (a[mid] > target) {
                s = mid + 1;
            }
        }
        return -1;
    }

    public int bSearch(int[] a, int s, int e, int target) {
        int n = a.length;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (a[mid] == target) {
                return mid;
            } else if (a[mid] < target) {
                e = mid - 1;
            } else if (a[mid] > target) {
                s = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        BinarySearchOnReversalSortedArray binarySearchOnReversalSortedArray = new BinarySearchOnReversalSortedArray();
        int[] a = {17, 10, 9, 7, 5, 3};
        System.out.println("Target position is: " + binarySearchOnReversalSortedArray.bSearch(a, 10));
        System.out.println("Target position is: " + binarySearchOnReversalSortedArray.bSearch(a, 20));
        System.out.println("Target position is: " + binarySearchOnReversalSortedArray.bSearch(a, 5));
    }
}
