package heap;

public class HeapSort {

    public void insert(int[] a, int n) {
        int val = a[n];
        int i = n, j = 0;
        if (n - 1 > 0) {
            j = (n - 1) / 2;
        }

        while (j > 0 && val > a[j]) {
            a[i] = a[j];
            i = j;
            j = (j - 1) / 2;
        }

        if (j == 0 && val > a[j]) {
            a[i] = a[j];
            a[j] = val;
        } else {
            a[i] = val;
        }
    }

    public void delete(int[] a, int n) {
        int tmp = a[0];

        int val = a[n];
        a[0] = a[n];
        int i = 0, j = 1;
        if (j + 1 < n && a[j] < a[j + 1])
            j = j + 1;
        while (j + 1 < n && val < a[j]) {
            if (j + 1 < n && a[j] < a[j + 1])
                j = j + 1;
            swap(a, i, j);
            i = j;
            j = 2 * i + 1;
        }
        if (j < n && val < a[j]) {
            swap(a, i, j);
        }

        a[n] = tmp;
    }

    void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    void heapify(int[] a,int i,int n) {

        int j = 2*i+1;
        if(j+1 <= n && a[j] < a[j+1]){
            j = j+1;
        }
        if(j <= n && a[i] < a[j]){
            swap(a,i,j);
            heapify(a,j,n);
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 15, 17, 9, 21};
        int n = arr.length;
        HeapSort heapSort = new HeapSort();
        for (int i = 1; i < n; i++) {
            heapSort.insert(arr, i);
        }
        for (int i = 0; i < n; i++) {
            heapSort.delete(arr, n - i - 1);
        }

        for (int j : arr) {
            System.out.print(j + " ");
        }

        System.out.println();
        System.out.println("-----Heapify-----");
        int[] b = {10, 20, 15, 17, 9, 21};
        for (int i = b.length-1; i >= 0; i--) {
            heapSort.heapify(b, i,b.length-1);
        }

        for (int j : b) {
            System.out.print(j + " ");
        }
        System.out.println();
        System.out.println("----------");
        int[] c = {26, 31, 25, 30, 50, 35,20};
        for (int i = c.length-1; i >= 0; i--) {
            heapSort.heapify(c, i,c.length-1);
        }

        for (int j : c) {
            System.out.print(j + " ");
        }

    }
}
