package slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public boolean BruteForce(String s, int windowSize) {

        int n = s.length();
        char[] s1 = s.toCharArray();

        HashMap<Character, Integer> hash = new HashMap<>();

        int i = 0, j = 0;
        //int count = 0;
        while (j < n) {

            if (!hash.containsKey(s1[j])) {
                hash.put(s1[j], 1);
                //count++;
            } else {
                int c = hash.get(s1[j]);
                hash.put(s1[j], c + 1);
            }

            if (j - i + 1 == windowSize) {
                /*for (Map.Entry<Character, Integer> e : hash.entrySet()) {
                    if (e.getValue() > 0) {
                        count++;
                    }
                } */

                if (hash.size() == windowSize) {
                    return true;
                }

                int c = hash.get(s1[i]);
                if (c == 1) {
                    //count--;
                    hash.remove(s1[i]);
                }else {
                    hash.put(s1[i], c - 1);
                }
                i++;
            }
            j++;
        }

        return false;
    }

    public int solve(String s) {

        int n = s.length();
        HashMap<Character, Integer> hash = new HashMap<>();
        int i = 0, j = 0, count = 0, max = 0;
        char[] s1 = s.toCharArray();
        while (j < n) {
            if (!hash.containsKey(s1[j])) {
                hash.put(s1[j], 1);
                count++;
            } else {
                int c = hash.get(s1[j]);
                hash.put(s1[j], c + 1);
            }

            if (count == j - i + 1) {
                if (max < j - i + 1) {
                    max = j - i + 1;
                }
            } else if (j - i + 1 > count) {
                while (j - i + 1 > count) {
                    int c = hash.get(s1[i]);
                    if (c == 1) {
                        count--;
                        hash.remove(s1[i]);
                    } else {
                        hash.put(s1[i], c - 1);
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }

    static public void main(String[] args) {
        String s = "ABDEFGABEF";
        String s1 = "GEEKSFORGEEKS";
        String s2 = "BBBB";
        String s3 = "ababccbb";
        String s4 = "pwwkew";


        LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println("Brute Force");
        boolean flag = false;
        int answer = 0;
        for (int i = s.length(); i >0; i--) {
            if (longestSubstringWithoutRepeatingCharacters.BruteForce(s, i)) {
                flag = true;
                answer = i;
                break;
            }
        }
        if (flag) {
            System.out.println("Longest substring length is: " + answer);
        } else {
            System.out.println("No Answer");
        }

        flag = false;
        answer = 0;
        for (int i = s1.length(); i >0; i--) {
            if (longestSubstringWithoutRepeatingCharacters.BruteForce(s1, i)) {
                flag = true;
                answer = i;
                break;
            }
        }

        if (flag) {
            System.out.println("Longest substring length is: " + answer);
        } else {
            System.out.println("No Answer");
        }

        flag = false;
        answer = 0;
        for (int i = s2.length(); i >0; i--) {
            if (longestSubstringWithoutRepeatingCharacters.BruteForce(s2, i)) {
                flag = true;
                answer = i;
                break;
            }
        }

        if (flag) {
            System.out.println("Longest substring length is: " + answer);
        } else {
            System.out.println("No Answer");
        }

        flag = false;
        answer = 0;
        for (int i = s2.length(); i >0; i--) {
            if (longestSubstringWithoutRepeatingCharacters.BruteForce(s3, i)) {
                flag = true;
                answer = i;
                break;
            }
        }

        if (flag) {
            System.out.println("Longest substring length is: " + answer);
        } else {
            System.out.println("No Answer");
        }

        int k3 = 3;
        flag = false;
        answer = 0;

        for (int i = s3.length(); i >0; i--) {
            if (longestSubstringWithoutRepeatingCharacters.BruteForce(s4, i)) {
                flag = true;
                answer = i;
                break;
            }
        }

        if (flag) {
            System.out.println("Longest substring length is: " + answer);
        } else {
            System.out.println("No Answer");
        }

        System.out.println("Sliding window");

        System.out.println("Longest substring length is: " + longestSubstringWithoutRepeatingCharacters.solve(s));
        System.out.println("Longest substring length is: " + longestSubstringWithoutRepeatingCharacters.solve(s1));
        System.out.println("Longest substring length is: " + longestSubstringWithoutRepeatingCharacters.solve(s2));
        System.out.println("Longest substring length is: " + longestSubstringWithoutRepeatingCharacters.solve(s3));
        System.out.println("Longest substring length is: " + longestSubstringWithoutRepeatingCharacters.solve(s4));
    }
}
