package slidingwindow;

public class MaximumSumSubArrayOfSizeK {

    int bruteForce(int[] a, int k) {

        int n = a.length;
        int maxSum = Integer.MIN_VALUE;
        int start = 0,end = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < i + k && j < n; j++) {
                sum += a[j];
            }

            if (sum > maxSum) {
                start = i;
                end = i+k-1;
                maxSum = sum;
            }
        }
        System.out.println("Start is: " + start + " & End is: " + end);
        return maxSum;
    }

    int solve(int[] a, int k) {
        int n = a.length;
        int maxSum = Integer.MIN_VALUE;
        int i = 0, j = 0, sum = 0;
        int start = 0, end = 0;
        while (j < n) {
            sum = sum + a[j];
            if (j - i + 1 == k) {
                if (sum > maxSum) {
                    start = i;
                    end = j;
                    maxSum = sum;
                }
                sum = sum - a[i];
                i++;
            }
            j++;
        }
        System.out.println("Start is: " + start + " & End is: " + end);
        return maxSum;
    }

    public static void main(String[] args) {
        MaximumSumSubArrayOfSizeK maximumSumSubArrayOfSizeK = new MaximumSumSubArrayOfSizeK();
        int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
        int k = 4;
        System.out.println("Max sum is: " + maximumSumSubArrayOfSizeK.bruteForce(arr, k));
        System.out.println("Max sum is: " + maximumSumSubArrayOfSizeK.solve(arr, k));
    }
}
