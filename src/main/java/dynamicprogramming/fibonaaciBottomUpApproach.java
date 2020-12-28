package dynamicprogramming;

public class fibonaaciBottomUpApproach {

    public Long getNthFibonaaci(int n) {
        Long a[] = new Long[n+1];
        a[0] = 0L;
        a[1] = 1L;
        for (int i = 2; i <=n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return (a[n]);
    }

    public static void main(String[] args) {
        fibonaaciBottomUpApproach fib = new fibonaaciBottomUpApproach();
        System.out.println("Fibonaaci value is " + fib.getNthFibonaaci(50));
    }
}
