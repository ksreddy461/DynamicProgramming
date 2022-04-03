package binarysearch;

public class NumberOfTimesArrayIsRotated {

    // right rotations count , for left rotation count , use n-right rotations count

    public int count(int[] a) {
        int n = a.length;
        int s = 0, e = n - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int prev = (mid - 1 + n) % n;
            int next = (mid + 1) % n;

            if (a[mid] < a[prev] && a[mid] < a[next]) {
                return mid;
            } else if (a[mid] < a[e]) {
                e = mid - 1;
            } else if (a[mid] > a[s]) {
                s = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {15, 18, 2, 3, 6, 12};
        NumberOfTimesArrayIsRotated numberOfTimesArrayIsRotated = new NumberOfTimesArrayIsRotated();

        System.out.println("Count is " + numberOfTimesArrayIsRotated.count(a));
    }
}
