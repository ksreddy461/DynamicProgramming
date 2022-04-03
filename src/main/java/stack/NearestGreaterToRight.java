package stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterToRight {

    Stack<Integer> s = new Stack<>();

    public static int[] NGRBruteForce(int[] a) {
        int n = a.length;
        int[] ngr = new int[n];
        Arrays.fill(ngr, -1);
        //ngr[n - 1] = -1;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] < a[j]) {
                    ngr[i] = a[j];
                    break;
                }
            }
        }
        return ngr;
    }

    public int[] NGR(int[] a) {

        int n = a.length;
        int[] ngr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                ngr[i] = -1;
            } else {
                if (a[i] < s.peek()) {
                    ngr[i] = s.peek();
                } else {
                    while (!s.isEmpty() && a[i] >= s.peek()) {
                        s.pop();
                    }
                    if (s.isEmpty()) {
                        ngr[i] = -1;
                    } else {
                        ngr[i] = s.peek();
                    }
                }
            }
            s.push(a[i]);
        }
        return ngr;
    }

    public static void main(String[] args) {
        int[] arr = {11, 13, 21, 3};
        System.out.println(Arrays.toString(NGRBruteForce(arr)));
        NearestGreaterToRight nearestGreaterToRight = new NearestGreaterToRight();
        System.out.println(Arrays.toString(nearestGreaterToRight.NGR(arr)));
    }
}
