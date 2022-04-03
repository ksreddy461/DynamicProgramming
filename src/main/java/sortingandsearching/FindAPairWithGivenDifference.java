package sortingandsearching;

public class FindAPairWithGivenDifference {

    private class Pair {

        private int element1;
        private int element2;

        public Pair(int element1, int element2) {
            this.element1 = element1;
            this.element2 = element2;
        }

        public int getElement1() {
            return element1;
        }

        public void setElement1(int element1) {
            this.element1 = element1;
        }

        public int getElement2() {
            return element2;
        }

        public void setElement2(int element2) {
            this.element2 = element2;
        }
    }

    public Pair pair(int[] a, int target) {
        Pair pair = new Pair(-1, -1);

        int n = a.length;
        int i = 0, j = 1;
        while (i < n && j < n) {
            if (a[j] - a[i] == target) {
                pair.setElement1(a[i]);
                pair.setElement2(a[j]);
                return pair;
            } else if (a[j] - a[i] > target) {
                i++;
            } else if (a[j] - a[i] < target) {
                j++;
            }
        }
        return pair;
    }

    public Pair pair2(int[] a, int target) {
        Pair pair = new Pair(-1, -1);

        int n = a.length;
        int i = 0, j = n-1;
        while ( i < n && j >=0) {
            if (a[j] - a[i] == target) {
                pair.setElement1(a[i]);
                pair.setElement2(a[j]);
                return pair;
            } else if (a[j] - a[i] > target) {
                j--;
            } else if (a[j] - a[i] < target) {
                i++;
            }
        }
        return pair;
    }

    public static void main(String[] args) {

        int[] a = {2, 3, 5, 5, 20, 80};
        FindAPairWithGivenDifference findAPairWithGivenDifference = new FindAPairWithGivenDifference();
        Pair pair = findAPairWithGivenDifference.pair(a, 17);
        System.out.println("Elements are: " + pair.getElement1() + "  " + pair.getElement2());

        pair = findAPairWithGivenDifference.pair(a, 30);
        System.out.println("Elements are: " + pair.getElement1() + "  " + pair.getElement2());


        pair = findAPairWithGivenDifference.pair(a, 17);
        System.out.println("Elements are: " + pair.getElement1() + "  " + pair.getElement2());

        pair = findAPairWithGivenDifference.pair(a, 30);
        System.out.println("Elements are: " + pair.getElement1() + "  " + pair.getElement2());
    }
}
