package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {

    Stack<Integer> stack = new Stack<>();

    public static int[] SSBruteForce(int[] a) {
        int n = a.length;
        int[] ss = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] > a[j]) {
                    count++;
                } else {
                    break;
                }
            }
            ss[i] = count;
        }
        return ss;
    }

    //Similar to NextGreaterToLeft , minor modifications
    public int[] SS(int[] a) {
        int n = a.length;
        int[] ss = new int[n];

        for (int i = 0; i < n; i++) {

            if (stack.isEmpty()) {
                ss[i] = -1;
            } else {
                if (a[i] < a[stack.peek()]) {
                    ss[i] = stack.peek();
                } else {
                    while (!stack.isEmpty() && a[i] >= a[stack.peek()]) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        ss[i] = -1;
                    } else {
                        ss[i] = stack.peek();
                    }
                }
            }
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            ss[i] = i - ss[i];
        }
        return ss;
    }

    public static void main(String[] args) {
        int[] a = {10, 4, 5, 90, 120, 80};
        System.out.println(Arrays.toString(SSBruteForce(a)));

        StockSpan stockSpan = new StockSpan();
        System.out.println(Arrays.toString(stockSpan.SS(a)));
        System.out.println("------------------------");
        int[] b = {100, 80, 60, 70, 60, 75, 85};
        System.out.println(Arrays.toString(SSBruteForce(b)));
        System.out.println(Arrays.toString(stockSpan.SS(b)));
    }
}
