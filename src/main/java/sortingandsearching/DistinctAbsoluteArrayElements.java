package sortingandsearching;

//https://www.youtube.com/watch?v=9M0asQIYy0Q&list=PL-Jc9J83PIiHhXKonZxk7gbEWsmSYP5kq&index=31
public class DistinctAbsoluteArrayElements {

    public int BruteForce(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(a[i]) == Math.abs(a[j])) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                count++;
            }
        }
        return count;
    }

    public int count(int[] a) {
        int n = a.length;

        int count = 0;
        int i = 0, j = n - 1;
        int previous = Integer.MIN_VALUE;
        int next = Integer.MAX_VALUE;

        while (i <= j) {

            if (Math.abs(a[i]) == Math.abs(a[j])) {
                if (a[i] != previous && a[j] != next) {
                    count++;
                }
                previous = a[i++];
                next = a[j--];
            } else if (Math.abs(a[i]) > Math.abs(a[j])) {
                if (a[i] != previous) {
                    count++;
                }
                previous = a[i++];
            } else {
                if (a[j] != next) {
                    count++;
                }
                next = a[j--];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DistinctAbsoluteArrayElements distinctAbsoluteArrayElements =
                new DistinctAbsoluteArrayElements();

        int[] a = {-3, -3, -2, -1, 0, 0, 1, 3, 3, 3, 5, 5, 5};

        System.out.println("Count is: " + distinctAbsoluteArrayElements.BruteForce(a));
        System.out.println("Count is: " + distinctAbsoluteArrayElements.count(a));
    }
}
