package sortingandsearching;

//https://www.youtube.com/watch?v=RIMkVshmVLs&list=PL-Jc9J83PIiHhXKonZxk7gbEWsmSYP5kq&index=34

/**
 * Forward declaration of guess API.
 *
 * @param num your guess
 * @return -1 if num is lower than the guess number
 * 1 if num is higher than the guess number
 * otherwise return 0
 * int guess(int num);
 */


public class GuessNumberHigherOrLower {

    private int guess(int n) {
        return 1;
    }

    public int guessNumber(int n) {

        int low = 1, high = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


}
