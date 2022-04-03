package binarysearch;

public class FirstOccurrenceOfAnElementInASortedArray {

    public int firstOccurrence(int[] a, int target) {

        int n = a.length;
        int s = 0, e = n - 1;
        int res = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (a[mid] == target) {
                res = mid;
                e = mid - 1;
            } else if (a[mid] > target) {
                e = mid - 1;
            } else if (a[mid] < target) {
                s = mid + 1;
            }
        }
        return res;
    }

    public int firstOccurrence(int[] a, int s, int e, int target) {

        int n = a.length;
        int res = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (a[mid] == target) {
                res = mid;
                e = mid - 1;
            } else if (a[mid] > target) {
                e = mid - 1;
            } else if (a[mid] < target) {
                s = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        FirstOccurrenceOfAnElementInASortedArray firstOccurrenceOfAnElementInASortedArray = new FirstOccurrenceOfAnElementInASortedArray();
        int[] a = {7, 9, 10, 13, 17, 19};
        System.out.println("Target position is: " + firstOccurrenceOfAnElementInASortedArray.firstOccurrence(a, 10));
        System.out.println("Target position is: " + firstOccurrenceOfAnElementInASortedArray.firstOccurrence(a, 20));
        int[] b = {7, 9, 10, 13, 17, 17, 17, 17, 19};
        System.out.println("Target position is: " + firstOccurrenceOfAnElementInASortedArray.firstOccurrence(b, 17));
    }
}
