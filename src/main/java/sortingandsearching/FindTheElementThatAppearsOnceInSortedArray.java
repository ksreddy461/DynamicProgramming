package sortingandsearching;

public class FindTheElementThatAppearsOnceInSortedArray {

    public int BruteForce(int[] a) {

        int n = a.length;
        if (n < 2) {
            return a[0];
        }
        int first = a[0];
        int second = a[1];

        if (first != second) {
            return first;
        }

        for (int i = 2; i < n - 1; i = i + 2) {
            first = a[i];
            second = a[i + 1];

            if (first != second) {
                return first;
            }
        }

        return a[n - 1];
    }

    public int solve(int[] a) {
        int n = a.length;

        int s = 0, e = n - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            int previous = mid == 0 ? Integer.MIN_VALUE : a[mid - 1];
            int next = mid == n - 1 ? Integer.MAX_VALUE : a[mid + 1];

            if (a[mid] != previous && a[mid] != next) {
                return a[mid];
            } else if ((mid % 2 == 0)) {
                if (a[mid] != previous) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            } else {
                if (a[mid] != previous) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        FindTheElementThatAppearsOnceInSortedArray findTheElementThatAppearsOnceInSortedArray =
                new FindTheElementThatAppearsOnceInSortedArray();

        int[] a = {1, 2, 2, 3, 3, 4, 4, 5, 5};
        System.out.println("Ans is: " + findTheElementThatAppearsOnceInSortedArray.BruteForce(a));

        int[] b = {1, 1, 2, 2, 3, 4, 4, 5, 5};
        System.out.println("Ans is: " + findTheElementThatAppearsOnceInSortedArray.BruteForce(b));


        int[] c = {1, 1, 2, 2, 3, 3, 4, 4, 5};
        System.out.println("Ans is: " + findTheElementThatAppearsOnceInSortedArray.BruteForce(c));

        System.out.println("Efficient Approach");
        System.out.println("Ans is: " + findTheElementThatAppearsOnceInSortedArray.solve(a));
        System.out.println("Ans is: " + findTheElementThatAppearsOnceInSortedArray.solve(b));
        System.out.println("Ans is: " + findTheElementThatAppearsOnceInSortedArray.solve(c));
    }
}
