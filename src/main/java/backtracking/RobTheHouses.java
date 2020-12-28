package backtracking;

public class RobTheHouses {

    public int maxProfit(int[] a, int i) {
        if (i < 0) {
            return 0;
        }
        if (i == 0) {
            return a[0];
        }
        int include = a[i] + maxProfit(a, i - 2);
        int exclude = maxProfit(a, i - 1);
        return Math.max(include, exclude);
    }

    public static void main(String[] args) {
        RobTheHouses robTheHouses = new RobTheHouses();
        int a[] = {20, 25, 30, 15, 10};
        System.out.println("Max profit for Robbing: " + robTheHouses.maxProfit(a, a.length - 1));
    }
}
