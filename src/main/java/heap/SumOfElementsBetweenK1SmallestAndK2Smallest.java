package heap;

public class SumOfElementsBetweenK1SmallestAndK2Smallest {

    public static void main(String[] args)
    {

        int[] a = { 20, 8, 22, 4, 12, 10, 14 };
        int k1 = 3, k2 = 6;

        KthSmallestElement kthSmallestElement = new KthSmallestElement();
        int first = kthSmallestElement.smallest(a,k1);
        int second = kthSmallestElement.smallest(a,k2);

        int sum = 0;
        for (int i=0;i<a.length;i++){
            if(first < a[i] && a[i] < second){
                sum = sum + a[i];
            }
        }

        System.out.println("Sum is: " + sum);
    }
}
