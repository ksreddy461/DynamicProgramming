package binarysearch;

public class BinarySearch {

    public int bSearch(int[] a, int target) {
        int n = a.length;
        int s = 0, e = n - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                e = mid - 1;
            } else if (a[mid] < target) {
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
            } else if (a[mid] > target) {
                e = mid - 1;
            } else if (a[mid] < target) {
                s = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        BinarySearch binarySearch = new BinarySearch();
        int[] a = {7, 9, 10, 13, 17, 19};
        System.out.println("Target position is: " + binarySearch.bSearch(a, 10));
        System.out.println("Target position is: " + binarySearch.bSearch(a, 20));
        System.out.println("Target position is: " + binarySearch.bSearch(a, 5));
    }
}
