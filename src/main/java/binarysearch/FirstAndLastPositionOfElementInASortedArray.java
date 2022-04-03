package binarysearch;

public class FirstAndLastPositionOfElementInASortedArray {

    private class Pair {

        private int position1;
        private int position2;

        public Pair(int position1, int position2) {
            this.position1 = position1;
            this.position2 = position2;
        }

        public int getPosition1() {
            return position1;
        }

        public void setPosition1(int position1) {
            this.position1 = position1;
        }

        public int getPosition2() {
            return position2;
        }

        public void setPosition2(int position2) {
            this.position2 = position2;
        }
    }

    public int find(int[] a, int target, boolean flag) {

        int n = a.length;
        int s = 0, e = n - 1;
        int res = -1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (a[mid] == target) {
                res = mid;
                if (!flag) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            } else if (a[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {5, 7, 7, 8, 8, 10};
        int target = 8;

        FirstAndLastPositionOfElementInASortedArray firstAndLastPositionOfElementInASortedArray =
                new FirstAndLastPositionOfElementInASortedArray();
        int firstPos = firstAndLastPositionOfElementInASortedArray.find(a, target, false);
        int lastPos = -1;
        if (firstPos != -1) {
            lastPos = firstAndLastPositionOfElementInASortedArray.find(a, target, true);
        }
        System.out.println("Positions are: " + firstPos + ", " + lastPos);


        firstPos = firstAndLastPositionOfElementInASortedArray.find(a, 6, false);
        lastPos = -1;
        if (firstPos != -1) {
            lastPos = firstAndLastPositionOfElementInASortedArray.find(a, 6, true);
        }
        System.out.println("Positions are: " + firstPos + ", " + lastPos);

        int[] b = {};
        firstPos = firstAndLastPositionOfElementInASortedArray.find(b, 0, false);
        lastPos = -1;
        if (firstPos != -1) {
            lastPos = firstAndLastPositionOfElementInASortedArray.find(b, 0, true);
        }
        System.out.println("Positions are: " + firstPos + ", " + lastPos);
    }
}
