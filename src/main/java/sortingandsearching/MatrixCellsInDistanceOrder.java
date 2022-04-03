package sortingandsearching;

import java.util.Arrays;
import java.util.PriorityQueue;

//https://leetcode.com/problems/matrix-cells-in-distance-order/
public class MatrixCellsInDistanceOrder {


    private class Pair implements Comparable<Pair> {

        Integer distance;
        int xPosition;
        int yPosition;

        public Pair(Integer distance, int xPosition, int yPosition) {
            this.distance = distance;
            this.xPosition = xPosition;
            this.yPosition = yPosition;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }

        public int getxPosition() {
            return xPosition;
        }

        public void setxPosition(int xPosition) {
            this.xPosition = xPosition;
        }

        public int getyPosition() {
            return yPosition;
        }

        public void setyPosition(int yPosition) {
            this.yPosition = yPosition;
        }

        @Override
        public int compareTo(Pair o) {

            return this.distance.compareTo(o.getDistance());
        }
    }

    public int[][] BruteForce(int rows, int cols, int rCenter, int cCenter) {

        PriorityQueue<Pair> minHeap = new PriorityQueue<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int d = Math.abs(rCenter - i) + Math.abs(cCenter - j);
                minHeap.add(new Pair(d, i, j));
            }
        }

        int[][] res = new int[rows * cols][2];
        int i = 0;
        while (minHeap.size() > 0) {
            Pair p = minHeap.peek();
            res[i][0] = p.getxPosition();
            res[i][1] = p.getyPosition();
            i++;
            minHeap.poll();
        }
        return res;
    }

    public int[][] solve(int rows, int cols, int rCenter, int cCenter) {

        int[][] res = new int[rows * cols][2];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int boxNum = i * cols + j;
                res[boxNum][0] = i;
                res[boxNum][1] = j;
            }
        }

        Arrays.sort(res, (a, b) -> {
            int d1 = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
            int d2 = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);
            return d1 - d2;
        });
        return res;
    }

    public static void main(String[] args) {
        MatrixCellsInDistanceOrder matrixCellsInDistanceOrder = new MatrixCellsInDistanceOrder();

        int[][] res = matrixCellsInDistanceOrder.solve(1, 2, 0, 0);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("---------------------");
        res = matrixCellsInDistanceOrder.solve(2, 2, 0, 1);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
