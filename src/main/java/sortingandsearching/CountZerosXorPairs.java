package sortingandsearching;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=IWEVmB8QF2k&list=PL-Jc9J83PIiHhXKonZxk7gbEWsmSYP5kq&index=29
public class CountZerosXorPairs {

    public int count(int[] a) {
        int n = a.length;
        int count = 0;

        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (frequency.containsKey(a[i])) {
                frequency.put(a[i], 1 + frequency.get(a[i]));
            } else {
                frequency.put(a[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> e : frequency.entrySet()) {
            count += ((e.getValue() - 1) * e.getValue()) / 2; // Sum of first N natural number s , here N is "e.getValue() - 1"
        }
        return count;
    }

    public static void main(String[] args) {
        CountZerosXorPairs countZerosXorPairs = new CountZerosXorPairs();

        int[] a = {3, 1, 3, 1, 2, 1, 2};
        System.out.println("Count is: " + countZerosXorPairs.count(a));
    }
}
