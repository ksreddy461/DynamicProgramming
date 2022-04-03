package binarysearch;

public class NextAlphabeticalElement {

    public char nextAlphabet(char[] letters, char target) {
        int n = letters.length;
        int s = 0, e = n - 1;
        int res = 0;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (letters[mid] > target) {
                res = mid;
                e = mid - 1;
            } else if (letters[mid] <= target) {
                s = mid + 1;
            }
        }
        return letters[res];
    }

    public static void main(String[] args) {
        char[] a = {'A', 'K', 'S'};
        char K = 'L';
        NextAlphabeticalElement nextAlphabeticalElement = new NextAlphabeticalElement();

        System.out.println("Ans is: " + nextAlphabeticalElement.nextAlphabet(a, K));
        char[] b = {'D', 'J', 'K'};
        K = 'B';
        System.out.println("Ans is: " + nextAlphabeticalElement.nextAlphabet(b, K));

        char[] c = {'h', 'n', 's'};
        K = 't';
        System.out.println("Ans is: " + nextAlphabeticalElement.nextAlphabet(c, K));

        char[] d = {'A', 'r', 'z'};
        K = 'z';
        System.out.println("Ans is: " + nextAlphabeticalElement.nextAlphabet(d, K));

    }
}
