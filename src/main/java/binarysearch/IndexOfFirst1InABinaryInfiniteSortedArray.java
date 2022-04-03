package binarysearch;

public class IndexOfFirst1InABinaryInfiniteSortedArray {

    public int index(int[] a){

        int s =0,e = 1;
        while (a[e] < 1){
            s =e;
            e =2*e;
        }

        FirstOccurrenceOfAnElementInASortedArray firstOccurrenceOfAnElementInASortedArray =
                new FirstOccurrenceOfAnElementInASortedArray();
        return firstOccurrenceOfAnElementInASortedArray.firstOccurrence(a,s,e,1);
    }

    public static void main(String[] args){
        int[] a = {1,1,1,1,1,1,1,1,1,1};
        IndexOfFirst1InABinaryInfiniteSortedArray indexOfFirst1InABinaryInfiniteSortedArray =
                new IndexOfFirst1InABinaryInfiniteSortedArray();
        System.out.println(indexOfFirst1InABinaryInfiniteSortedArray.index(a));

        int[] b = {0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1};
        System.out.println(indexOfFirst1InABinaryInfiniteSortedArray.index(b));

        int[] c = {0,1,1,1,1,1,1,1,1,1,1};
        System.out.println(indexOfFirst1InABinaryInfiniteSortedArray.index(c));
    }
}
