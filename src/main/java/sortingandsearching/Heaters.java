package sortingandsearching;

import java.util.Arrays;

//https://leetcode.com/problems/heaters/
public class Heaters {

    public int BruteForce(int[] houses, int[] heaters) {
        int m = houses.length;
        int n = heaters.length;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, houses[i]);
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, heaters[i]);
        }

        int res = -1;
        int s = 0, e = max;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (isValid(houses, heaters, mid)) {
                res = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return res;
    }


    public int solve(int[] houses, int[] heaters) {
        int m = houses.length;
        int n = heaters.length;

        int res = 0;
        Arrays.sort(heaters);
        for (int i = 0; i < m; i++) {
            int d = ClosestHeaterDistance(heaters, houses[i]);
            if (d > res) {
                res = d;
            }
        }
        return res;
    }

    private boolean isValid(int[] houses, int[] heaters, int threshold) {
        int m = houses.length;
        int n = heaters.length;

        for (int i = 0; i < m; i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (Math.abs(houses[i] - heaters[j]) <= threshold) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }


    private int ClosestHeaterDistance(int[] heaters, int house) {

        int n = heaters.length;
        int s = 0, e = n - 1;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (heaters[mid] == house) {
                return 0;
            } else if (heaters[mid] < house) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        if (s > n - 1) {
            return Math.abs(heaters[e] - house);
        } else if (e < 0) {
            return Math.abs(heaters[s] - house);
        }

        if (Math.abs(heaters[s] - house) < Math.abs(heaters[e] - house)) {
            return Math.abs(heaters[s] - house);
        } else {
            return Math.abs(heaters[e] - house);
        }
    }

    public int findRadius(int[] houses, int[] heaters) {
        if (houses == null || houses.length == 0 || heaters == null || heaters.length == 0) {
            return 0;
        }

        Arrays.sort(houses);
        Arrays.sort(heaters);

        int n = houses.length;
        int m = heaters.length;

        int i = 0;
        int j = 0;

        int res = 0;
        while (i < n && j < m) {
            // for each heaters[j],  compare to heaters[j + 1]
            int dist1 = Math.abs(heaters[j] - houses[i]);
            int dist2 = Integer.MAX_VALUE;
            if (j + 1 < m) {
                dist2 = Math.abs(heaters[j + 1] - houses[i]);
            }
            // if j closer to i than j + 1, settle and i ++;
            if (dist1 < dist2) {
                res = Math.max(res, dist1);
                i++;
                // else j++;
            } else {
                j++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Heaters heaters = new Heaters();

        int[] houses = {1, 2, 3};
        int[] heates = {2};
        System.out.println("Ans is: " + heaters.BruteForce(houses, heates));

        int[] houses2 = {1, 2, 3, 4};
        int[] heates2 = {1, 4};
        System.out.println("Ans is: " + heaters.BruteForce(houses2, heates2));


        int[] houses3 = {1, 5};
        int[] heates3 = {2};
        System.out.println("Ans is: " + heaters.BruteForce(houses3, heates3));

        System.out.println("Second Approach");
        System.out.println("Ans is: " + heaters.solve(houses, heates));
        System.out.println("Ans is: " + heaters.solve(houses2, heates2));
        System.out.println("Ans is: " + heaters.solve(houses3, heates3));

        int[] houses4 = {282475249, 622650073, 984943658, 144108930, 470211272, 101027544, 457850878, 458777923};
        int[] heates4 = {823564440, 115438165, 784484492, 74243042, 114807987, 137522503, 441282327, 16531729, 823378840, 143542612};
        System.out.println("Ans is: " + heaters.solve(houses4, heates4));

    }
}
