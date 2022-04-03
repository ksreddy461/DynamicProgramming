package binarysearch;

public class MinimumDiffElementInASortedArray {

    public int solve(int[] a, int target) {

        if (target <= a[0]) {
            return a[0];
        } else if (target >= a[a.length - 1]) {
            return a[a.length - 1];
        }
        FloorOfAnElementInASortedArray floorOfAnElementInASortedArray =
                new FloorOfAnElementInASortedArray();
        int floor = floorOfAnElementInASortedArray.floor(a, target);

        CeilOfAnElementInASortedArray ceilOfAnElementInASortedArray = new CeilOfAnElementInASortedArray();
        int ceil = ceilOfAnElementInASortedArray.ceil(a, target);

        if (target - floor < ceil - target) {
            return floor;
        } else {
            return ceil;
        }
    }

    public int solve2(int[] a, int target) {

        int n = a.length;
        if (target <= a[0]) {
            return a[0];
        } else if (target >= a[n - 1]) {
            return a[n - 1];
        }
        int s = 0, e = n - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (a[mid] == target) {
                return a[mid];
            } else if (a[mid] > target) {
                e = mid - 1;
            } else if (a[mid] < target) {
                s = mid + 1;
            }
        }

        if (Math.abs(target - a[s]) < Math.abs(a[e] - target)) {
            return a[s];
        } else {
            return a[e];
        }
    }

    public static void main(String[] args) {

        int[] a = {3, 5, 9, 12, 15, 18, 24, 35, 67, 90};
        MinimumDiffElementInASortedArray minimumDiffElementInASortedArray =
                new MinimumDiffElementInASortedArray();
        System.out.println("Ans is: " + minimumDiffElementInASortedArray.solve(a, 3));
        System.out.println("Ans is: " + minimumDiffElementInASortedArray.solve2(a, 3));

        System.out.println("Ans is: " + minimumDiffElementInASortedArray.solve(a, 2));
        System.out.println("Ans is: " + minimumDiffElementInASortedArray.solve2(a, 2));

        System.out.println("Ans is: " + minimumDiffElementInASortedArray.solve(a, 100));
        System.out.println("Ans is: " + minimumDiffElementInASortedArray.solve2(a, 100));

        System.out.println("Ans is: " + minimumDiffElementInASortedArray.solve(a, 50));
        System.out.println("Ans is: " + minimumDiffElementInASortedArray.solve2(a, 50));

    }
}
