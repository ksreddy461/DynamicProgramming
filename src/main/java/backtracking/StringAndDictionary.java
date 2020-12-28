package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StringAndDictionary {

    public void breakString(String s, HashSet<String> dictionary, List<String> partial) {

        if (0 == s.length()) {
            System.out.println(Arrays.toString(partial.toArray()));
        }
        for (int i = 0; i < s.length(); i++) {
            String word = s.substring(0, i + 1);
            if (dictionary.contains(word)) {
                partial.add(word);
                breakString(s.substring(i + 1), dictionary, partial);
                partial.remove(partial.size() - 1);
            }
        }
    }

    public static void main(String[] args) {

        StringAndDictionary stringAndDictionary = new StringAndDictionary();
        HashSet<String> dictionary = new HashSet<String>();
        dictionary.add("cat");
        dictionary.add("cats");
        dictionary.add("and");
        dictionary.add("sand");
        dictionary.add("dog");

        List<String> partial = new ArrayList<String>();

        stringAndDictionary.breakString("catsanddog", dictionary, partial);
    }
}
