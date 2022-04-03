package sortingandsearching;

public class CountZerosInSortedMatrix {

    public int count(int[][] a) {
        int m = a.length;
        int n = a[0].length;

        int i = 0, j = n - 1;
        int count = 0;
        while (i < m && j >= 0) {

            if (a[i][j] < 1) {
                count += j + 1;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountZerosInSortedMatrix countZerosInSortedMatrix = new CountZerosInSortedMatrix();

        int[][] a = {{0, 0, 0, 0, 1},
                {0, 0, 0, 1, 1},
                {0, 0, 1, 1, 1},
                {0, 1, 1, 1, 1}};

        System.out.println("Count is: " + countZerosInSortedMatrix.count(a));
    }
}
