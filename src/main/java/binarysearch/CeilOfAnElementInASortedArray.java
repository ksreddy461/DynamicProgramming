package binarysearch;

// Smallest of all elements which are greater than (>) target.
public class CeilOfAnElementInASortedArray {

    public int ceil(int[] a, int target) {
        int n = a.length;
        int res = -1, s = 0, e = n - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (a[mid] == target) {
                return a[mid];
            } else if (a[mid] > target) {
                res = mid;
                e = mid - 1;
            } else if (a[mid] < target) {
                s = mid + 1;
            }
        }
        if (res != -1) {
            return a[res];
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 8, 10, 10, 12, 19};
        int x = 5;
        CeilOfAnElementInASortedArray ceilOfAnElementInASortedArray = new CeilOfAnElementInASortedArray();
        System.out.println("Ceil value is: " + ceilOfAnElementInASortedArray.ceil(a, x));

        int[] b = {1, 2, 8, 10, 10, 12, 19};
        x = 20;
        System.out.println("Ceil value is: " + ceilOfAnElementInASortedArray.ceil(b, x));
        int[] c = {1, 2, 8, 10, 10, 12, 19};
        x = 0;
        System.out.println("Ceil value is: " + ceilOfAnElementInASortedArray.ceil(c, x));
    }
}
