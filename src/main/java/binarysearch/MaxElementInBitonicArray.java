package binarysearch;

// it is same as Peak element
public class MaxElementInBitonicArray {
    public static void main(String[] args) {
        PeakElement peakElement = new PeakElement();
        int[] a = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        System.out.println("Max Element is: " + a[peakElement.peak(a)]);

        int[] b = {1, 3, 50, 10, 9, 7, 6};
        System.out.println("Max Element is: " + b[peakElement.peak(b)]);

        int[] c = {10, 20, 30, 40, 50};
        System.out.println("Max Element is: " + c[peakElement.peak(c)]);

        int[] d = {120, 100, 80, 20, 0};
        System.out.println("Max Element is: " + d[peakElement.peak(d)]);
    }
}
