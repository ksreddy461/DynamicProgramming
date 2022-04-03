package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class CountOfOccurrenceOfAnagram {

    public boolean areAnagrams(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if (m != n) {
            return false;
        }

        HashMap<Character, Integer> hash = new HashMap<>();

        for (int i = 0; i < m; i++) {
            char c = s1.charAt(i);
            if (hash.get(c) == null) {
                hash.put(c, 1);
            } else {
                int count = hash.get(c);
                hash.put(c, count + 1);
            }
        }

        for (int i = 0; i < n; i++) {
            char c = s2.charAt(i);
            if (hash.get(c) == null) {
                return false;
            } else {
                int count = hash.get(c);
                hash.put(c, count - 1);
            }
        }

        for (Map.Entry<Character, Integer> e : hash.entrySet()) {
            if (e.getValue() > 0) {
                return false;
            }
        }

        return true;
    }

    public int BruteForce(String s1, String pattern) {
        int n = s1.length();
        int k = pattern.length();
        int count = 0;
        for (int i = 0; i < n - k + 1; i++) {
            String sub = s1.substring(i, i + k);
            if (areAnagrams(pattern, sub)) {
                count++;
            }
        }
        return count;
    }

    public int solve(String s1, String pattern) {
        int n = s1.length();
        int k = pattern.length();

        HashMap<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < k; i++) {
            char c = pattern.charAt(i);
            if (hash.get(c) == null) {
                hash.put(c, 1);
            } else {
                int cnt = hash.get(c);
                hash.put(c, cnt + 1);
            }
        }

        int i = 0, j = 0, count = 0;
        while (j < n) {
            if (hash.get(s1.charAt(j)) != null) {
                int cnt = hash.get(s1.charAt(j));
                hash.put(s1.charAt(j), cnt - 1);
            }

            if (j - i + 1 == k) {

                boolean flag = false;
                for (Map.Entry<Character, Integer> e : hash.entrySet()) {
                    if (e.getValue() > 0) {
                        flag = true;
                        break;
                    }
                }

                if (!flag) {
                    count++;
                }

                if (hash.get(s1.charAt(i)) != null) {
                    int cnt = hash.get(s1.charAt(i));
                    hash.put(s1.charAt(i), cnt + 1);
                }
                i++;
            }
            j++;
        }
        return count;
    }

    public int solve2(String s1, String pattern) {
        int n = s1.length();
        int k = pattern.length();

        int count = 0;
        HashMap<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < k; i++) {
            char c = pattern.charAt(i);
            if (!hash.containsKey(c)) {
                hash.put(c, 1);
                count++;
            } else {
                int cnt = hash.get(c);
                hash.put(c, cnt + 1);
            }
        }

        int i = 0, j = 0, ans = 0;
        while (j < n) {
            if (hash.containsKey(s1.charAt(j))) {
                int cnt = hash.get(s1.charAt(j));
                if (cnt == 1) {
                    count--;
                }
                hash.put(s1.charAt(j), cnt - 1);
            }

            if (j - i + 1 == k) {

                if (count == 0) {
                    ans++;
                }

                if (hash.containsKey(s1.charAt(i))) {
                    int cnt = hash.get(s1.charAt(i));
                    if (cnt == 0) {
                        count++;
                    }
                    hash.put(s1.charAt(i), cnt + 1);
                }
                i++;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {


        CountOfOccurrenceOfAnagram countOfOccurrenceOfAnagram = new CountOfOccurrenceOfAnagram();
        System.out.println("BruteForce");
        System.out.println(countOfOccurrenceOfAnagram.BruteForce("forxxorfxdofr", "for"));
        System.out.println(countOfOccurrenceOfAnagram.BruteForce("aabaabaa", "aaba"));

        System.out.println("SlidingWindow");
        System.out.println(countOfOccurrenceOfAnagram.solve("forxxorfxdofr", "for"));
        System.out.println(countOfOccurrenceOfAnagram.solve("aabaabaa", "aaba"));

        System.out.println("SlidingWindow2");
        System.out.println(countOfOccurrenceOfAnagram.solve2("forxxorfxdofr", "for"));
        System.out.println(countOfOccurrenceOfAnagram.solve2("aabaabaa", "aaba"));


    }
}
