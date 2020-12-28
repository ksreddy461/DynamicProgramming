package recursion;


import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Timer;

public class MaxValueInArray {

    public int maxValue(int[] a, int pos) {
        if (pos == 0) {
            return a[pos];
        }
        return (Math.max(a[pos], maxValue(a, pos - 1)));
    }

    public int maxValue(int[] a) {
        int max = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = i;
            }
        }
        return a[max];
    }

    public static void main(String[] args) {
        MaxValueInArray maxValueInArray = new MaxValueInArray();
        int[] a = {4, 3, 6, 7, 0, 9, 2};
        long start = System.currentTimeMillis();
        //Instant start2 = Instant.now();
        System.out.println("Maximum value in the array " + Arrays.toString(a) + " is " + maxValueInArray.maxValue(a, a.length - 1));
        long end = System.currentTimeMillis();
        //Instant end2 = Instant.now();
        long elapsedTime = end - start;
        //Duration timeElapsed = Duration.between(start2, end2);
        System.out.println("Time taken for this program in milli seconds is : " + elapsedTime);
        //System.out.println("Time taken for this program: " + timeElapsed);

        long start2 = System.currentTimeMillis();
        System.out.println("Maximum value in the array " + Arrays.toString(a) + " is " + maxValueInArray.maxValue(a));
        long end2 = System.currentTimeMillis();
        long elapsedTime2 = end2 - start2;
        System.out.println("Time taken for this program in milli seconds is : " + elapsedTime2);
    }
}
