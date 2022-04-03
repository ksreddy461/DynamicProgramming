package slidingwindow;


import java.util.LinkedList;
import java.util.PriorityQueue;

public class MaximumOfMinimumForEveryWindowSize {

    public class Pair implements Comparable<Pair> {
        private Integer position;
        private Integer element;

        Pair(Integer position, Integer element) {
            this.position = position;
            this.element = element;
        }

        public Integer getElement() {
            return element;
        }

        public void setElement(Integer element) {
            this.element = element;
        }

        public Integer getPosition() {
            return position;
        }

        public void setPosition(Integer position) {
            this.position = position;
        }

        @Override
        public int compareTo(Pair o) {
            return this.element.compareTo(o.getElement());
        }
    }

    public int solve3(int[] a, int k) {
        int n = a.length;
        LinkedList<Pair> deQueue = new LinkedList<>();

        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;
        while (j < n) {
            while (!deQueue.isEmpty() && deQueue.peek().getElement() >= a[j]) {
                deQueue.poll();
            }
            deQueue.add(new Pair(j, a[j]));

            if (j - i + 1 == k) {
                if (!deQueue.isEmpty()) {
                    int tmp = deQueue.peek().getElement();
                    if (tmp > max) {
                        max = tmp;
                    }
                    if (tmp == a[i] && i == deQueue.peek().getPosition()) {
                        deQueue.poll();
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }

    public int solve(int[] a, int k) {
        int n = a.length;
        LinkedList<Integer> deQueue = new LinkedList<>();

        int i = 0, j = 0;
        int max = Integer.MIN_VALUE;
        while (j < n) {
            while (!deQueue.isEmpty() && deQueue.peek() > a[j]) {
                deQueue.poll();
            }
            deQueue.add(a[j]);

            if (j - i + 1 == k) {
                if (!deQueue.isEmpty()) {
                    int tmp = deQueue.peek();
                    if (tmp > max) {
                        max = tmp;
                    }
                    if (tmp == a[i]) {
                        deQueue.poll();
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }

    public int solve2(int[] a, int k) {
        int n = a.length;
        int max = Integer.MIN_VALUE;
        PriorityQueue<Integer> deQueue = new PriorityQueue<>();

        int i = 0, j = 0;
        while (j < n) {
            /*while (!deQueue.isEmpty() && deQueue.peek() > a[j]) {
                deQueue.poll();
            }*/
            deQueue.add(a[j]);

            if (j - i + 1 == k) {
                if (!deQueue.isEmpty()) {
                    int tmp = deQueue.peek();
                    if (tmp > max) {
                        max = tmp;
                    }
                    if (tmp == a[i]) {
                        deQueue.poll();
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        //int[] a = {10, 20, 30, 50, 10, 70, 30};
        int[] a = {15, 20, 8, 30, 12, 20};
        MaximumOfMinimumForEveryWindowSize maximumOfMinimumForEveryWindowSize = new MaximumOfMinimumForEveryWindowSize();

        for (int i = 1; i <= a.length; i++) {
            System.out.println(maximumOfMinimumForEveryWindowSize.solve3(a, i));
        }
    }

}
