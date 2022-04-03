package binarysearch;

public class SearchingElementInNearlySortedArray {

    public int search(int[] a, int target) {
        int n = a.length;
        int s = 0, e = n - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (mid + 1 < n && a[mid + 1] == target) {
                return mid + 1;
            } else if (mid - 1 >= 0 && a[mid - 1] == target) {
                return mid - 1;
            } else if (a[mid] > target) {
                e = mid - 2;
            } else if (a[mid] < target) {
                s = mid + 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {10, 3, 40, 20, 50, 80, 70};
        int key = 40;
        SearchingElementInNearlySortedArray searchingElementInNearlySortedArray =
                new SearchingElementInNearlySortedArray();
        System.out.println("Ans is: " + searchingElementInNearlySortedArray.search(a, key));

        int[] b = {10, 3, 40, 20, 50, 80, 70};
        key = 90;
        System.out.println("Ans is: " + searchingElementInNearlySortedArray.search(b, key));

        int[] c = {3, 2, 10, 4, 40};
        key = 4;
        System.out.println("Ans is: " + searchingElementInNearlySortedArray.search(c, key));
    }
}
