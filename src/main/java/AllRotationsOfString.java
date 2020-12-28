public class AllRotationsOfString {

    public void generateAllRotations(char[] S) {

        int len = S.length;
        for (int i = 0; i < len; i++) {
            char first = S[0];
            for (int j = 0; j < len - 1; j++) {
                S[j] = S[j + 1];
            }
            S[len - 1] = first;
            System.out.println(S);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        AllRotationsOfString allRotationsOfString = new AllRotationsOfString();
        allRotationsOfString.generateAllRotations(s.toCharArray());
    }
}
