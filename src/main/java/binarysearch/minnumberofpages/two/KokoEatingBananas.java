package binarysearch.minnumberofpages.two;

//https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBananas {

    public int solve(int[] piles, int h) {

        int max = Integer.MIN_VALUE;
        for (int value : piles) {
            if (max < value) {
                max = value;
            }
        }
        int s = 1, e = max, res = 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isValid(piles, mid, h)) {
                res = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return res;
    }

    private boolean isValid(int[] a, int threshold, int hours) {
        int hoursSpent = 0;
        for (int value : a) {
            hoursSpent += Math.ceil((double) value / threshold);
        }

        return hoursSpent <= hours;
    }

    public static void main(String[] args) {

        KokoEatingBananas kokoEatingBananas = new KokoEatingBananas();

        int[] a = {3, 6, 7, 11};
        int hours = 8;
        System.out.println("Ans is: " + kokoEatingBananas.solve(a, hours));

        int[] b = {30, 11, 23, 4, 2};
        hours = 5;
        System.out.println("Ans is: " + kokoEatingBananas.solve(b, hours));

        int[] c = {30, 11, 23, 4, 20};
        hours = 6;
        System.out.println("Ans is: " + kokoEatingBananas.solve(c, hours));

    }
}
