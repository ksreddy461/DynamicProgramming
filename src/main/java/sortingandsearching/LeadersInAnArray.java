package sortingandsearching;

import java.util.ArrayList;
import java.util.Collections;

//https://www.youtube.com/watch?v=jaWfUvmf7iU&list=PL-Jc9J83PIiHhXKonZxk7gbEWsmSYP5kq&index=41
public class LeadersInAnArray {

    public ArrayList<Integer> leaders(int[] a) {
        int n = a.length;

        int rMax = Integer.MIN_VALUE;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >=0; i--) {
            if (a[i] >= rMax) {
                res.add(a[i]);
                rMax = a[i];
            }
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        LeadersInAnArray leadersInAnArray = new LeadersInAnArray();

        int[] a = {16, 17, 5, 4, 3, 5, 2};
        System.out.println(leadersInAnArray.leaders(a));
    }
}
