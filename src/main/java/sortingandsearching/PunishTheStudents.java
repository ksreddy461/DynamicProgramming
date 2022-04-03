package sortingandsearching;

//https://www.youtube.com/watch?v=VCA1_JapxqE&list=PL-Jc9J83PIiHhXKonZxk7gbEWsmSYP5kq&index=38
public class PunishTheStudents {

    private int BubbleSortSwaps(int[] a) {
        int n = a.length;
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swaps += 2;
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                }
            }
        }
        return swaps;
    }

    public boolean solve(int[] a, int[] marks, double average) {

        int swaps = BubbleSortSwaps(a);
        int totalMarks = 0;
        int n = a.length;

        for (int i = 0; i < n; i++) {
            totalMarks += marks[i];
        }

        int newTotalMarks = totalMarks - swaps;
        double newAverage = (newTotalMarks * 1.0) / n;
        return newAverage >= average;
    }

    public static void main(String[] args) {

        PunishTheStudents punishTheStudents = new PunishTheStudents();

        int[] a = {3, 2, 4, 1, 5};
        int[] marks = {50, 67, 89, 79, 58};
        double average = 68;

        if (punishTheStudents.solve(a, marks, average)) {
            System.out.println("Punish the students");
        } else {
            System.out.println("Don't Punish the students");
        }
    }
}
