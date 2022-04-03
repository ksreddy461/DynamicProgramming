package binarysearch;

//Greatest of smaller than x.
// Greatest of all elements which are less than (<) target
public class FloorOfAnElementInASortedArray {

    public int floor(int[] a, int target) {
        int n = a.length;
        int s = 0, e = n - 1;
        int res = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (a[mid] == target) {
                return a[mid];
            } else if (a[mid] < target) {
                res = mid;
                s = mid + 1;
            } else if (a[mid] > target) {
                e = mid - 1;
            }
        }
        if (res != -1)
            return a[res];
        else
            return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 8, 10, 10, 12, 19};
        int x = 5;
        FloorOfAnElementInASortedArray floorOfAnElementInASortedArray = new FloorOfAnElementInASortedArray();
        System.out.println("Floor value is: " + floorOfAnElementInASortedArray.floor(a, x));

        int[] b = {1, 2, 8, 10, 10, 12, 19};
        x = 20;
        System.out.println("Floor value is: " + floorOfAnElementInASortedArray.floor(b, x));
        int[] c = {1, 2, 8, 10, 10, 12, 19};
        x = 0;
        System.out.println("Floor value is: " + floorOfAnElementInASortedArray.floor(c, x));
    }
}
