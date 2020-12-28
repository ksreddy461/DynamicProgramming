package recursion;

public class SumOfDigits {
    public int sum(int number) {
        if (number == 0) {
            return 0;
        }
        return (number % 10 + sum(number / 10));
    }

    public static void main(String[] args) {
        SumOfDigits sumOfDigits = new SumOfDigits();
        int number = 123456;
        sumOfDigits.sum(number);
        System.out.print("Sum of digits of " + number + "is: " + sumOfDigits.sum(number));
    }
}
