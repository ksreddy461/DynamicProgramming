package sortingandsearching;

import binarysearch.FirstOccurrenceOfAnElementInASortedArray;

//https://www.youtube.com/watch?v=cWKLH1BDsIg&list=PL-Jc9J83PIiHhXKonZxk7gbEWsmSYP5kq&index=36
public class FindMaximum1sRow {

    public int max(int[][] a) {
        int rows = a.length;
        int cols = a[0].length;

        FirstOccurrenceOfAnElementInASortedArray firstOccurrenceOfAnElementInASortedArray =
                new FirstOccurrenceOfAnElementInASortedArray();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            int count1s = firstOccurrenceOfAnElementInASortedArray.firstOccurrence(a[i], 1);
            if (cols - count1s > max) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        FindMaximum1sRow findMaximum1sRow = new FindMaximum1sRow();

        int[][] a = {
                {0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1}
        };

        System.out.println("Max 1s row is: " + findMaximum1sRow.max(a));
    }
}
