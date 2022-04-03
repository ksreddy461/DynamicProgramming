package slidingwindow;

import java.util.HashMap;

public class MinimumWindowSubString {

    public boolean BruteForce(String s, String p, int k) {
        int n = s.length();

        char[] p1 = p.toCharArray();
        HashMap<Character, Integer> hash = new HashMap<>();
        int count = 0;
        for (int i = 0; i < p.length(); i++) {
            if (hash.containsKey(p1[i])) {
                int c = hash.get(p1[i]);
                hash.put(p1[i], c + 1);
            } else {
                hash.put(p1[i], 1);
                count++;
            }
        }

        char[] s1 = s.toCharArray();

        int i = 0, j = 0;
        while (j < n) {
            if (hash.containsKey(s1[j])) {
                int c = hash.get(s1[j]);
                if (c == 1) {
                    count--;
                }
                hash.put(s1[j], c - 1);
            }

            if (j - i + 1 == k) {
                if (count == 0) {
                    return true;
                }

                if (hash.containsKey(s1[i])) {
                    int c = hash.get(s1[i]);
                    if (c == 0) {
                        count++;
                    }
                    hash.put(s1[i], c + 1);
                }
                i++;
            }
            j++;
        }
        return false;
    }

    public String solve(String s, String t) {
        int n = s.length();

        char[] p1 = t.toCharArray();
        HashMap<Character, Integer> hash = new HashMap<>();
        int count = 0;
        for (int i = 0; i < t.length(); i++) {
            if (hash.containsKey(p1[i])) {
                int c = hash.get(p1[i]);
                hash.put(p1[i], c + 1);
            } else {
                hash.put(p1[i], 1);
                count++;
            }
        }

        char[] s1 = s.toCharArray();

        int i = 0, j = 0;
        int start = -1, end = -1;
        int min = Integer.MAX_VALUE;
        while (j < n) {
            if (hash.containsKey(s1[j])) {
                int c = hash.get(s1[j]);
                if (c == 1) {
                    count--;
                }
                hash.put(s1[j], c - 1);
            }

            if (count == 0) {
                if (min > j - i + 1) {
                    min = j - i + 1;
                    start = i;
                    end = j;
                }
                while (count == 0) {
                    if (hash.containsKey(s1[i])) {
                        int c = hash.get(s1[i]);
                        if (c == 0) {
                            count++;
                        }
                        hash.put(s1[i], c + 1);
                    }
                    i++;

                    if (count == 0) {
                        if (min > j - i + 1) {
                            min = j - i + 1;
                            start = i;
                            end = j;
                        }
                    }
                }
            }
            j++;
        }
        if (start == -1 && end == -1) {
            return "";
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        String str = "thisisateststring";
        String pat = "tist";

        String str2 = "geeksforgeeks";
        String pat2 = "ork";

        String str3 = "ADOBECODEBANC";
        String pat3 = "ABC";

        String str4 = "a";
        String pat4 = "a";

        String str5 = "a";
        String pat5 = "aa";

        MinimumWindowSubString minimumWindowSubString = new MinimumWindowSubString();
        boolean flag = false;
        int answer = 0;
        for (int i = pat.length(); i <= str.length(); i++) {
            if (minimumWindowSubString.BruteForce(str, pat, i)) {
                flag = true;
                answer = i;
                break;
            }
        }
        if (flag) {
            System.out.println("Smallest window is: " + answer);
        } else {
            System.out.println("No Answer");
        }

        flag = false;
        answer = 0;
        for (int i = pat2.length(); i <= str2.length(); i++) {
            if (minimumWindowSubString.BruteForce(str2, pat2, i)) {
                flag = true;
                answer = i;
                break;
            }
        }
        if (flag) {
            System.out.println("Smallest window is: " + answer);
        } else {
            System.out.println("No Answer");
        }

        flag = false;
        answer = 0;
        for (int i = pat3.length(); i <= str3.length(); i++) {
            if (minimumWindowSubString.BruteForce(str3, pat3, i)) {
                flag = true;
                answer = i;
                break;
            }
        }
        if (flag) {
            System.out.println("Smallest window is: " + answer);
        } else {
            System.out.println("No Answer");
        }

        flag = false;
        answer = 0;
        for (int i = pat4.length(); i <= str4.length(); i++) {
            if (minimumWindowSubString.BruteForce(str4, pat4, i)) {
                flag = true;
                answer = i;
                break;
            }
        }
        if (flag) {
            System.out.println("Smallest window is: " + answer);
        } else {
            System.out.println("No Answer");
        }

        flag = false;
        answer = 0;
        for (int i = pat5.length(); i <= str5.length(); i++) {
            if (minimumWindowSubString.BruteForce(str5, pat5, i)) {
                flag = true;
                answer = i;
                break;
            }
        }
        if (flag) {
            System.out.println("Smallest window is: " + answer);
        } else {
            System.out.println("No Answer");
        }

        System.out.println("Sliding Window");
        System.out.println("Smallest window is: " + minimumWindowSubString.solve(str, pat));
        System.out.println("Smallest window is: " + minimumWindowSubString.solve(str2, pat2));
        System.out.println("Smallest window is: " + minimumWindowSubString.solve(str3, pat3));
        System.out.println("Smallest window is: " + minimumWindowSubString.solve(str4, pat4));
        System.out.println("Smallest window is: " + minimumWindowSubString.solve(str5, pat5));
    }

}
