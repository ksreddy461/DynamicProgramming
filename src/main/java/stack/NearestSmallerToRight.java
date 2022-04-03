package stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToRight {

    Stack<Integer> s = new Stack<>();

    public static int[] NSRBruteForce(int[] a) {
        int n = a.length;
        int[] nsr = new int[n];
        Arrays.fill(nsr, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    nsr[i] = a[j];
                    break;
                }
            }
        }
        return nsr;
    }

    public int[] NSR(int[] a) {
        int n = a.length;
        int[] nsr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                nsr[i] = -1;
            } else {
                if (a[i] > s.peek()) {
                    nsr[i] = s.peek();
                } else {
                    while (!s.isEmpty() && a[i] <= s.peek()) {
                        s.pop();
                    }
                    if (s.isEmpty()) {
                        nsr[i] = -1;
                    } else {
                        nsr[i] = s.peek();
                    }
                }
            }
            s.push(a[i]);
        }
        return nsr;
    }

    public static void main(String[] args) {
        int[] arr = {5, 6, 3, 8, 4, 2};
        System.out.println(Arrays.toString(NSRBruteForce(arr)));
        NearestSmallerToRight nearestSmallerToRight = new NearestSmallerToRight();
        System.out.println(Arrays.toString(nearestSmallerToRight.NSR(arr)));
    }
}
