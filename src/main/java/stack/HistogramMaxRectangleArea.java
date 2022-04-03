package stack;

import java.util.Stack;

public class HistogramMaxRectangleArea {

    public static Stack<Integer> s = new Stack<>();

    public static int[] NSRIndex(int[] a) {
        int n = a.length;
        int[] nsr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (s.isEmpty()) {
                nsr[i] = n;//store last building + 1
            } else {
                if (a[i] > a[s.peek()]) {
                    nsr[i] = s.peek();
                } else {
                    while (!s.isEmpty() && a[i] <= a[s.peek()]) {
                        s.pop();
                    }
                    if (s.isEmpty()) {
                        nsr[i] = n;
                    } else {
                        nsr[i] = s.peek();
                    }
                }
            }
            s.push(i);
        }
        return nsr;
    }

    public static int[] NSLIndex(int[] a) {
        int n = a.length;
        int[] nsl = new int[n];
        s.clear();
        for (int i = 0; i < n; i++) {
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                if (a[i] > a[s.peek()]) {
                    nsl[i] = s.peek();
                } else {
                    while (!s.isEmpty() && a[i] <= a[s.peek()]) {
                        s.pop();
                    }
                    if (s.isEmpty()) {
                        nsl[i] = -1;
                    } else {
                        nsl[i] = s.peek();
                    }
                }
            }
            s.push(i);
        }
        return nsl;
    }


    public static int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] nsr = new int[n];
        nsr[n-1]=n;
        for(int i=n-2;i>=0;i--){
            int j = i+1;

            while(j<n && heights[j]>=heights[i]){
                j = nsr[j];
            }
            nsr[i]=j;
        }

        int[] nsl = new int[n];
        nsl[0] = -1;
        for(int i=0;i<n;i++){
            int j = i-1;

            while(j>=0 && heights[j]>=heights[i]){
                j = nsl[j];
            }
            nsl[i]=j;
        }


        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){

            int area = (nsr[i]-nsl[i]-1)*heights[i];

            if(area>max){
                max = area;
            }
        }
        return max;
    }

    public static int largestRectangleArea2(char[] heights) {

        int n = heights.length;

        int[] nsr = new int[n];
        nsr[n-1]=n;
        for(int i=n-2;i>=0;i--){
            int j = i+1;

            while(j<n && heights[j]>=heights[i]){
                j = nsr[j];
            }
            nsr[i]=j;
        }

        int[] nsl = new int[n];
        nsl[0] = -1;
        for(int i=0;i<n;i++){
            int j = i-1;

            while(j>=0 && heights[j]>=heights[i]){
                j = nsl[j];
            }
            nsl[i]=j;
        }


        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){

            int area = (nsr[i]-nsl[i]-1)*heights[i];

            if(area>max){
                max = area;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        int n = arr.length;
        int[] width = new int[n];
        int[] nsr = NSRIndex(arr);
        int[] nsl = NSLIndex(arr);
        for (int i = 0; i < n; i++) {
            width[i] = nsr[i] - nsl[i] - 1;
        }
        int[] area = new int[n];
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            area[i] = width[i] * arr[i];
            if (maxArea < area[i]) {
                maxArea = area[i];
            }
        }
        System.out.println("Max Area of given histogram is: " + maxArea);
        System.out.println("---------------");
        System.out.println("Max Area of given histogram is: " + largestRectangleArea(arr));
    }
}
