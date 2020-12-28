package backtracking;

import java.util.Arrays;

public class Anagrams {

    public void anagram(String str) {

        char[] aStr = str.toCharArray();
        Arrays.sort(aStr);
        anagramUtil(aStr, 0);
    }

    private void anagramUtil(char[] aStr, int pos) {

        if (pos == aStr.length) {
            System.out.println(aStr);
            return;
        }

        for (int i = pos; i < aStr.length; i++) {

            if (!(i > pos && aStr[i] == aStr[i - 1])){
                swap(aStr, i, pos);
                anagramUtil(aStr, pos + 1);
                swap(aStr, i, pos);
            }
        }
    }

    private void swap(char[] aStr, int a, int b) {
        char tmp = aStr[a];
        aStr[a] = aStr[b];
        aStr[b] = tmp;
    }

    public static void main(String[] args) {

        Anagrams anagrams = new Anagrams();
        anagrams.anagram("abca");
    }
}
