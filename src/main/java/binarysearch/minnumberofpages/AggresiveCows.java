package binarysearch.minnumberofpages;

import java.util.Arrays;

//https://www.spoj.com/problems/AGGRCOW/
public class AggresiveCows {

    private boolean isValid(int[] a, int threshold, int k) {

        int cows = 1;
        int prev = a[0];
        for (int i = 1; i < a.length; i++) {
            if (Math.abs(a[i] - prev) >= threshold) {
                cows++;
                prev = a[i];
            }
            if (cows == k) {
                return true;
            }
        }
        return false;
    }

    public int solve(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int max = Integer.MIN_VALUE, res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if(max < position[i]){
                max = position[i];
            }
            if(min > position[i]){
                min = position[i];
            }
        }

        int s = min, e = max;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isValid(position, mid, m)) {
                res = mid;
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1, 5, 8, 11, 13, 16};
        int k = 4;

        AggresiveCows aggresiveCows = new AggresiveCows();
        System.out.println("Ans is:  " + aggresiveCows.solve(a, k));

        int[] b = {1, 2, 8, 4, 9};
        k = 3;

        System.out.println("Ans is:  " + aggresiveCows.solve(b, k));

        int[] c = {975017321, 74045490, 415097519, 76628781, 843696647, 709774845, 493571894, 23388841, 184522636, 794748308, 746534625, 248911596, 490131472, 321479956, 335523769, 748628710, 226578862, 959858170, 810159464, 85795199, 898777852, 163699246, 289742726, 945822015};
        k = 4;
        System.out.println("Ans is:  " + aggresiveCows.solve(c, k));
    }

}
