package dynamicprogramming;

public class fibonaaciTopdownApproach {


    public Long getNthFibonaaci(int n) {
        Long a[] = new Long[n+1];
        a[0] = 0L;
        a[1] = 1L;

        for (int i = 2; i <= n; i++) {
            a[i] = Long.valueOf(0);
        }
        return getNthFibonaaciHelper(a, n);
    }

    public Long getNthFibonaaciHelper(Long a[], int n) {
        if (n <= 1) {
            return Long.valueOf(n);
        }
        if (a[n] != 0) {
            return a[n];
        }
        a[n] = getNthFibonaaciHelper(a,n - 1) + getNthFibonaaciHelper(a,n - 2);
        return a[n];
    }

    public static void main(String[] args) {
        fibonaaciTopdownApproach fib = new fibonaaciTopdownApproach();
        System.out.println("Fibonaaci value is " + fib.getNthFibonaaci(10));
    }
}
