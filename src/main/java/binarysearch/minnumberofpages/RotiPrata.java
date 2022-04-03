package binarysearch.minnumberofpages;

public class RotiPrata {

    public int solve(int[] a, int p) {

        int s = 1, e = 1, res = 1;
        boolean flag = false;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (isValid(a, p, mid)) {
                res = mid;
                e = mid - 1;
                flag = true;
            } else {
                if (!flag) {
                    s = e;
                    e = 2 * e;
                } else {
                    s = mid + 1;
                }
            }
        }
        return res;
    }

    private boolean isValid(int[] a, int p, int threshold) {
        int n = a.length;
        int parothaPrepared = 0;
        for (int i : a) {
            int tmp = threshold;
            int j = 1;
            while (tmp >= j * i) {
                parothaPrepared++;
                tmp = tmp - j * i;
                j++;
            }
            if (parothaPrepared >= p) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RotiPrata rotiPrata = new RotiPrata();
        int[] a = {1, 2, 3, 4};
        int p = 10;
        System.out.println("Ans is: " + rotiPrata.solve(a, p));

        int[] b = {1};
        p = 8;
        System.out.println("Ans is: " + rotiPrata.solve(b, p));

        int[] c = {1,1,1,1,1,1,1,1};
        p = 8;
        System.out.println("Ans is: " + rotiPrata.solve(c, p));
    }
}
