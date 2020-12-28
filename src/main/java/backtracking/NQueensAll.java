package backtracking;

public class NQueensAll {

    final static int N = 4;
    static int K = 1;

    private boolean isValid(boolean[][] a, int row, int col) {

        int r, c;

        /* Check this column on top */
        for (c = 0; c < row; c++)
            if (a[c][col])
                return false;

        /* Check upper diagonal on left side */
        for (r = row, c = col; r >= 0 && c >= 0; r--, c--)
            if (a[r][c])
                return false;

        /* Check upper diagonal on right side */
        for (r = row, c = col; r >= 0 && c < N; r--, c++)
            if (a[r][c])
                return false;

        return true;
    }

    /* A utility function to print solution */
    void printSolution(boolean[][] board) {
        System.out.println(K++);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public boolean nQueens(boolean[][] a, int row) {

        if (row >= N) {
            printSolution(a);
            return true;
        }
        boolean res = false;
        for (int i = 0; i < N; i++) {
            if (isValid(a, row, i)) {
                a[row][i] = Boolean.TRUE;
                res = nQueens(a, row + 1) || res;
                a[row][i] = Boolean.FALSE;
            }
        }
        return res;
    }

    public static void main(String args[]) {
        boolean a[][] = new boolean[N][N];
        NQueensAll nqueens = new NQueensAll();
        nqueens.nQueens(a, 0);
    }
}
