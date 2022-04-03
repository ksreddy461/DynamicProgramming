package stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestGreaterToLeft {

    Stack<Integer> s = new Stack<>();

    public static int[] NGLBruteForce(int[] a) {
        int n = a.length;
        int[] ngl = new int[n];
        Arrays.fill(ngl, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] < a[j]) {
                    ngl[i] = a[j];
                    break;
                }
            }
        }
        return ngl;
    }

    public int[] NGL(int[] a) {
        int n = a.length;
        int[] ngl = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.isEmpty()) {
                ngl[i] = -1;
            } else {
                if (a[i] < s.peek()) {
                    ngl[i] = s.peek();
                } else {
                    while (!s.isEmpty() && a[i] >= s.peek()) {
                        s.pop();
                    }
                    if(s.isEmpty()){
                        ngl[i] = -1;
                    }else{
                        ngl[i] = s.peek();
                    }
                }
            }
            s.push(a[i]);
        }
        return ngl;
    }

    public static void main(String[] args) {
        int[] arr = {11, 13, 21, 3};
        System.out.println(Arrays.toString(NGLBruteForce(arr)));
        NearestGreaterToLeft nearestGreaterToLeft = new NearestGreaterToLeft();
        System.out.println(Arrays.toString(nearestGreaterToLeft.NGL(arr)));
    }
}
