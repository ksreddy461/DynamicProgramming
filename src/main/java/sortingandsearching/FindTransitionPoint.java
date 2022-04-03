package sortingandsearching;

import binarysearch.FirstOccurrenceOfAnElementInASortedArray;

//https://www.youtube.com/watch?v=wMCnl-TSk8Q&list=PL-Jc9J83PIiHhXKonZxk7gbEWsmSYP5kq&index=32
public class FindTransitionPoint {

    public int solve(int[] a) {
        FirstOccurrenceOfAnElementInASortedArray firstOccurrenceOfAnElementInASortedArray =
                new FirstOccurrenceOfAnElementInASortedArray();

        return firstOccurrenceOfAnElementInASortedArray.firstOccurrence(a, 1);
    }

    public static void main(String[] main) {
        FindTransitionPoint findTransitionPoint = new FindTransitionPoint();

        int[] a = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1};
        System.out.println("Ans is: " + findTransitionPoint.solve(a));

    }
}
