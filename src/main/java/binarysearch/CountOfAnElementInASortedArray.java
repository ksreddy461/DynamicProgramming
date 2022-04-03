package binarysearch;

public class CountOfAnElementInASortedArray {

    public static void main(String[] args) {

        int[] a = {7, 9, 10, 13, 17, 19};
        int[] b = {7, 9, 10, 13, 17, 17, 17, 17, 19};

        FirstOccurrenceOfAnElementInASortedArray firstOccurrenceOfAnElementInASortedArray = new FirstOccurrenceOfAnElementInASortedArray();
        LastOccurrenceOfAnElementInASortedArray lastOccurrenceOfAnElementInASortedArray = new LastOccurrenceOfAnElementInASortedArray();
        if (lastOccurrenceOfAnElementInASortedArray.lastOccurrence(a, 13) != -1) {
            System.out.println("Count is: " + (lastOccurrenceOfAnElementInASortedArray.lastOccurrence(a, 13)
                    - firstOccurrenceOfAnElementInASortedArray.firstOccurrence(a, 13) + 1));
        } else {
            System.out.println("Element not exist in the array");
        }

        if (lastOccurrenceOfAnElementInASortedArray.lastOccurrence(a, 20) != -1) {
            System.out.println("Count is: " + (lastOccurrenceOfAnElementInASortedArray.lastOccurrence(a, 20)
                    - firstOccurrenceOfAnElementInASortedArray.firstOccurrence(a, 20) + 1));
        } else {
            System.out.println("Element not exist in the array");
        }

        if (lastOccurrenceOfAnElementInASortedArray.lastOccurrence(b, 17) != -1) {
            System.out.println("Count is: " + (lastOccurrenceOfAnElementInASortedArray.lastOccurrence(b, 17)
                    - firstOccurrenceOfAnElementInASortedArray.firstOccurrence(b, 17) + 1));
        } else {
            System.out.println("Element not exist in the array");
        }

    }
}
