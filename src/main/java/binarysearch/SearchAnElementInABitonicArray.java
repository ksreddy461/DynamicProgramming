package binarysearch;

public class SearchAnElementInABitonicArray {

    public int search(int[] a, int target) {
        int n = a.length;
        PeakElement peakElement = new PeakElement();
        int index = peakElement.peak(a);

        if (index != -1 && a[index] == target) {
            return index;
        } else {

            BinarySearch binarySearch = new BinarySearch();
            int left = binarySearch.bSearch(a, 0, index - 1, target);
            if (left != -1) {
                return left;
            }
            BinarySearchOnReversalSortedArray binarySearchOnReversalSortedArray = new BinarySearchOnReversalSortedArray();
            return binarySearchOnReversalSortedArray.bSearch(a, index + 1, n - 1, target);
        }
    }

    public static void main(String[] args) {
        int[] a = {-3, 9, 18, 20, 17, 5, 1};
        SearchingElementInNearlySortedArray searchingElementInNearlySortedArray =
                new SearchingElementInNearlySortedArray();
        System.out.println("Ans is: " + searchingElementInNearlySortedArray.search(a, 20));

        int[] b = {5, 6, 7, 8, 9, 10, 3, 2, 1};
        System.out.println("Ans is: " + searchingElementInNearlySortedArray.search(b, 30));
    }
}
