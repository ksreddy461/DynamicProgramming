package sortingandsearching;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=KVY27ZrLgZE&list=PL-Jc9J83PIiHhXKonZxk7gbEWsmSYP5kq&index=42
public class IshaanAndSticks {

    public ArrayList<Integer> solve(int[] a) {

        int n = a.length;
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < n; i++) {

            if (frequency.containsKey(a[i])) {
                int value = frequency.get(a[i]);
                frequency.put(a[i], value + 1);
            } else {
                frequency.put(a[i], 1);
            }
        }

        int maxArea = Integer.MIN_VALUE;
        int count = 0;
        //Traverse the hashmap
        for (Map.Entry<Integer, Integer> e : frequency.entrySet()) {

            if (e.getValue() >= 4) {
                int area = e.getKey() * e.getKey();
                if (area > maxArea) {
                    maxArea = area;
                    count = e.getValue() / 4;
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(maxArea);
        res.add(count);
        return res;
    }

    public static void main(String[] args) {
        IshaanAndSticks ishaanAndSticks = new IshaanAndSticks();

        int[] a = {2,3,2,3,2,3,3,3,2,3,3,3,4};
        System.out.println(ishaanAndSticks.solve(a));
    }
}
