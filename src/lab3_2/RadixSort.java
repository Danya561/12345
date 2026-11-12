package lab3_2;

import java.math.BigInteger;
import java.util.List;

public class RadixSort implements Sorting<BigInteger> {

    private static final int DIGITS = 20;

    private int digit(BigInteger x, int k) {
        String s = x.toString();
        int index = s.length() - 1 - k;

        if (index < 0) {
            return 0;
        }

        return s.charAt(index) - '0';
    }

    private void sortByDigit(List<BigInteger> nums, int k) {
        int[] count = new int[10];

        for (BigInteger x : nums) {
            count[digit(x, k)]++;
        }

        int sum = 0;

        for (int d = 0; d < count.length; d++) {
            int old = count[d];
            count[d] = sum;
            sum += old;
        }

        BigInteger[] output = new BigInteger[nums.size()];

        for (BigInteger x : nums) {
            int d = digit(x, k);
            output[count[d]] = x;
            count[d]++;
        }

        for (int i = 0; i < output.length; i++) {
            nums.set(i, output[i]);
        }
    }

    @Override
    public void sort(List<BigInteger> nums) {
        for (int k = 0; k < DIGITS; k++) {
            sortByDigit(nums, k);
        }
    }
}