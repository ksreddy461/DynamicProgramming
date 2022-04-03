package slidingwindow;

public class MaxSumInTheConfiguration {

    public int maxSum(int[] a) {
        int n = a.length;

        int sum = 0;
        int s0 = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            s0 += a[i] * i;
        }

        int maxSum = s0;
        int si = s0;
        for (int i = 1; i < n; i++) {
            int sip1 = si + sum - n * a[n - i];
            if (sip1 > maxSum) {
                maxSum = sip1;
            }
            si = sip1;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSumInTheConfiguration maxSumInTheConfiguration = new MaxSumInTheConfiguration();

        int[] a = {8,3,1,2};
        System.out.println("Max sum is: " + maxSumInTheConfiguration.maxSum(a));
    }
}
