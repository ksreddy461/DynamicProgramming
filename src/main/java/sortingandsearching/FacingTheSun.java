package sortingandsearching;

//https://www.youtube.com/watch?v=yQPQtKM8HN0&list=PL-Jc9J83PIiHhXKonZxk7gbEWsmSYP5kq&index=30
public class FacingTheSun {

    public int count(int[] a) {

        int n = a.length;
        int count = 1;//Always Sun light will fall on First building
        int leftMax = a[0];

        for (int i = 1; i < n; i++) {
            if (leftMax < a[i]) {
                count++;
                leftMax = a[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        FacingTheSun facingTheSun = new FacingTheSun();

        int[] a = {7,4,8,2,9,6};
        System.out.println("Count is: " + facingTheSun.count(a));
    }
}
