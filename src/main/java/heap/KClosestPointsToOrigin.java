package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {

    public class Point {
        Integer x;
        Integer y;

        Point(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Integer getX() {
            return x;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public Integer getY() {
            return y;
        }

        public void setY(Integer y) {
            this.y = y;
        }
    }

    public class Pair implements Comparable<Pair> {

        Integer distance;
        Point point;

        public Pair(Integer distance, Point point) {
            this.distance = distance;
            this.point = point;
        }

        public Integer getDistance() {
            return distance;
        }

        public void setDistance(Integer distance) {
            this.distance = distance;
        }

        public Point getPoint() {
            return point;
        }

        public void setPoint(Point point) {
            this.point = point;
        }

        @Override
        public int compareTo(Pair o) {
            return this.getDistance().compareTo(o.getDistance());
        }
    }

    public void solve(Integer[][] a, int k) {
        PriorityQueue<Pair> pQueue = new PriorityQueue<>(Collections.reverseOrder());//Max heap

        for (int i = 0; i < a.length; i++) {
            Integer d = a[i][0] * a[i][0] + a[i][1] * a[i][1];

            if (pQueue.size() < k) {
                pQueue.add(new Pair(d, new Point(a[i][0], a[i][1])));
            } else if ((pQueue.size() == k) && pQueue.peek().getDistance() > d) {
                pQueue.poll();
                pQueue.add(new Pair(d, new Point(a[i][0], a[i][1])));
            }
        }

        while (pQueue.size() > 0) {
            Pair pair = pQueue.peek();
            System.out.println("Point is: " + pair.getPoint().getX() + "  " + pair.getPoint().getY());
            pQueue.poll();
        }
    }

    public static void main(String[] args) {
        Integer[][] points = {{3, 3},
                {5, -1},
                {-2, 4}};

        int K = 2;
        KClosestPointsToOrigin kClosestPointsToOrigin = new KClosestPointsToOrigin();
        kClosestPointsToOrigin.solve(points, K);

        System.out.println("--------------");
        Integer[][] points2 = {{1, 3}, {-2, 2}};
        kClosestPointsToOrigin.solve(points2, 1);
    }
}
