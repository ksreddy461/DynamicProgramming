package sortingandsearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/sequential-digits/
//Sliding window approach
public class SequentialDigits {

    public List<Integer> solve(int low, int high) {

        int minDigits = getLength(low);
        int maxDigits = getLength(high);

        List<Integer> res = new ArrayList<>();
        String all = "123456789";
        for (int i = minDigits; i <= maxDigits; i++) {
            for (int j = 0; j < 9 - i + 1; j++) {
                String sub = all.substring(j, j + i);
                int subNum = Integer.parseInt(sub);

                if (subNum >= low && subNum <= high) {
                    res.add(subNum);
                }
            }
        }
        return res;
    }

    private int getLength(int num) {
        int len = 0;

        while (num > 0) {
            len++;
            num = num / 10;
        }
        return len;
    }

    public List<Integer> solve2(int low, int high) {

        List<Integer> res = new ArrayList<>();
        int[] all = {12, 23, 34, 45, 56, 67, 78, 89,
                123, 234, 345, 456, 567, 678, 789,
                1234, 2345, 3456, 4567, 5678, 6789,
                12345, 23456, 34567, 45678, 56789,
                123456, 234567, 345678, 45678,
                1234567, 2345678, 3456789,
                12345678, 23456789,
                123456789};
        for (int i = 0; i < all.length; i++) {
            if (all[i] < low) {
                continue;
            }
            if (all[i] > high) {
                break;
            }
            res.add(all[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        SequentialDigits sequentialDigits = new SequentialDigits();

        System.out.println("Ans is: " + Arrays.asList(sequentialDigits.solve(100, 300)));
        System.out.println("Ans is: " + Arrays.asList(sequentialDigits.solve(1000, 13000)));

        System.out.println("------------");
        System.out.println("Ans is: " + Arrays.asList(sequentialDigits.solve2(100, 300)));
        System.out.println("Ans is: " + Arrays.asList(sequentialDigits.solve2(1000, 13000)));

    }
}
