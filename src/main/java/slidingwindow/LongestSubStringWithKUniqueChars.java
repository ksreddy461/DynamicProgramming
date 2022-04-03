package slidingwindow;

import java.util.HashMap;

public class LongestSubStringWithKUniqueChars {

    public boolean BruteForce(String s, int windowSize, int k) {

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

                if (hash.size() == k) {
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

    public int solve(String s, int k) {

        int n = s.length();
        HashMap<Character, Integer> hash = new HashMap<>();
        int i = 0, j = 0, max = 0;
        //int count = 0;
        char[] s1 = s.toCharArray();
        while (j < n) {
            if (!hash.containsKey(s1[j])) {
                hash.put(s1[j], 1);
                //count++;
            } else {
                int c = hash.get(s1[j]);
                hash.put(s1[j], c + 1);
            }

            if (hash.size() == k) {
                if (max < j - i + 1) {
                    max = j - i + 1;
                }
            } else if (hash.size() > k) {
                while (hash.size() > k) {
                    int c = hash.get(s1[i]);
                    if (c == 1) {
                        //count--;
                        hash.remove(s1[i]);
                    } else {
                        hash.put(s1[i], c - 1);
                    }

                    i++;
                }
                /* if(count == k){
                    if (max < j - i + 1) {
                        max = j - i + 1;
                    }
                }*/
            }
            j++;
        }
        return max;
    }

    public int solve2(String s, int k) {

        int n = s.length();
        HashMap<Character, Integer> hash = new HashMap<>();
        int i = 0, j = 0, max = 0;
        //int count = 0;
        char[] s1 = s.toCharArray();
        while (j < n) {
            if (!hash.containsKey(s1[j])) {
                hash.put(s1[j], 1);
                //count++;
            } else {
                int c = hash.get(s1[j]);
                hash.put(s1[j], c + 1);
            }

            if (hash.size() <= k) {
                if (max < j - i + 1) {
                    max = j - i + 1;
                }
            }
            if (hash.size() > k) {
                while (hash.size() > k) {
                    int c = hash.get(s1[i]);
                    if (c == 1) {
                        //count--;
                        hash.remove(s1[i]);
                    } else {
                        hash.put(s1[i], c - 1);
                    }

                    i++;
                }
                /* if(count == k){
                    if (max < j - i + 1) {
                        max = j - i + 1;
                    }
                }*/
            }
            j++;
        }
        return max;
    }

    static public void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;

        System.out.println("Brute Force");
        LongestSubStringWithKUniqueChars longestSubStringWithKUniqueChars = new LongestSubStringWithKUniqueChars();
        boolean flag = false;
        int answer = 0;
        for (int i = s.length(); i >= k; i--) {
            if (longestSubStringWithKUniqueChars.BruteForce(s, i, k)) {
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

        String s1 = "aabbcc";
        int k1 = 1;
        flag = false;
        answer = 0;
        for (int i = s1.length(); i >= k1; i--) {
            if (longestSubStringWithKUniqueChars.BruteForce(s1, i, k1)) {
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

        String s2 = "aabbcc";
        int k2 = 2;
        flag = false;
        answer = 0;
        for (int i = s2.length(); i >= k2; i--) {
            if (longestSubStringWithKUniqueChars.BruteForce(s2, i, k2)) {
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
        for (int i = s2.length(); i >= k2; i--) {
            if (longestSubStringWithKUniqueChars.BruteForce(s2, i, 3)) {
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

        String s3 = "aaabbb";
        int k3 = 3;
        flag = false;
        answer = 0;

        for (int i = s3.length(); i >= k3; i--) {
            if (longestSubStringWithKUniqueChars.BruteForce(s3, i, k3)) {
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

        System.out.println("Longest substring length is: " + longestSubStringWithKUniqueChars.solve(s, k));
        System.out.println("Longest substring length is: " + longestSubStringWithKUniqueChars.solve(s1, k1));
        System.out.println("Longest substring length is: " + longestSubStringWithKUniqueChars.solve(s2, k2));
        System.out.println("Longest substring length is: " + longestSubStringWithKUniqueChars.solve(s2, 3));
        System.out.println("Longest substring length is: " + longestSubStringWithKUniqueChars.solve(s3, k3));

        System.out.println("Sliding window + at most k unique chars ");// means uniqueChars <=k
        System.out.println("Longest substring length is: " + longestSubStringWithKUniqueChars.solve2(s, k));
        System.out.println("Longest substring length is: " + longestSubStringWithKUniqueChars.solve2(s1, k1));
        System.out.println("Longest substring length is: " + longestSubStringWithKUniqueChars.solve2(s2, k2));
        System.out.println("Longest substring length is: " + longestSubStringWithKUniqueChars.solve2(s2, 3));
        System.out.println("Longest substring length is: " + longestSubStringWithKUniqueChars.solve2(s3, k3));
    }
}
