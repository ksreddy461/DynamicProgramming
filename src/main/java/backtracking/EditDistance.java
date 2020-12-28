package backtracking;

public class EditDistance {

    public int minEditDistance(int i, int j, String A, String B) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }

        if (A.charAt(i) == B.charAt(j)) {
            return minEditDistance(i - 1, j - 1, A, B);
        } else {
            return (Math.min(minEditDistance(i, j - 1, A, B),
                    Math.min(minEditDistance(i - 1, j - 1, A, B), minEditDistance(i - 1, j, A, B))) + 1);
        }
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        String A = "GOAT", B = "GET";
        System.out.println("Edit distance between " + A + "," + B + " is : " +
                editDistance.minEditDistance(A.length() - 1, B.length() - 1, A, B));
    }
}
