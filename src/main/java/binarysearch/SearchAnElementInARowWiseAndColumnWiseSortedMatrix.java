package binarysearch;

public class SearchAnElementInARowWiseAndColumnWiseSortedMatrix {

    private class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }

    public Pair search(int[][] a, int target) {
        int rows = a.length;
        int cols = a[0].length;

        if (target < a[0][0] || target > a[rows - 1][cols - 1]) {
            new Pair(-1, -1);
        }
        int i = 0, j = cols - 1;
        while (i >= 0 && i < rows && j >= 0 && j < cols) {
            if (a[i][j] == target) {
                return new Pair(i, j);
            } else if (a[i][j] < target) {
                i++;
            } else if (a[i][j] > target) {
                j--;
            }
        }
        return new Pair(-1, -1);
    }

    public static void main(String[] args) {
        int[][] a = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        int x = 29;
        SearchAnElementInARowWiseAndColumnWiseSortedMatrix searchAnElementInARowWiseAndColumnWiseSortedMatrix =
                new SearchAnElementInARowWiseAndColumnWiseSortedMatrix();
        Pair pair = searchAnElementInARowWiseAndColumnWiseSortedMatrix.search(a, x);
        System.out.println("row is: " + pair.getRow() + " & col is: " + pair.getCol());
        int[][] b = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};
        x = 100;
        pair = searchAnElementInARowWiseAndColumnWiseSortedMatrix.search(b, x);
        System.out.println("row is: " + pair.getRow() + " & col is: " + pair.getCol());
    }
}
