package stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToLeft {

    Stack<Integer> s = new Stack<>();

    public static int[] NSLBruteForce(int[] a) {
        int n = a.length;
        int[] nsl = new int[n];
        Arrays.fill(nsl, -1);

        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] > a[j]) {
                    nsl[i] = a[j];
                    break;
                }
            }
        }
        return nsl;
    }

    public int[] NSL(int[] a) {
        int n = a.length;
        int[] nsl = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                if (a[i] > s.peek()) {
                    nsl[i] = s.peek();
                } else {
                    while (!s.isEmpty() && a[i] <= s.peek()) {
                        s.pop();
                    }
                    if (s.isEmpty()) {
                        nsl[i] = -1;
                    } else {
                        nsl[i] = s.peek();
                    }
                }
            }
            s.push(a[i]);
        }
        return nsl;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 8, 4, 2};
        System.out.println(Arrays.toString(NSLBruteForce(arr)));
        NearestSmallerToLeft nearestSmallerToLeft = new NearestSmallerToLeft();
        System.out.println(Arrays.toString(nearestSmallerToLeft.NSL(arr)));
    }
}
