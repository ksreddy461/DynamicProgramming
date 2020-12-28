package backtracking;

/*
* nCr = n! / r! * (n - r)!
*
* */
public class BinomialCoefficient {

    public int BCoefficient(int n, int k) {
        if (n == k || k == 0) {
            return 1;
        }
        return (BCoefficient(n - 1, k - 1) + BCoefficient(n - 1, k));
    }

    public static void main(String[] args){
        BinomialCoefficient binomialCoefficient = new BinomialCoefficient();
        System.out.println(binomialCoefficient.BCoefficient(6,2));
    }
}
