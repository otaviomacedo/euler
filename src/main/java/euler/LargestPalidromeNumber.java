package euler;

import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;

public class LargestPalidromeNumber {
    public static long withNDigits(int numberOfDigits) {
        long min = (long) Math.pow(10.0, numberOfDigits - 1);
        long max = (long) Math.pow(10.0, numberOfDigits) - 1;

        long maxPalindrome = 0;
        for (long i = min; i <= max; i++) {
            for (long j = i; j <= max; j++) {
                long candidate = i * j;
                if (isPalindrome(candidate) && candidate > maxPalindrome){
                    maxPalindrome = candidate;
                }
            }
        }

        return maxPalindrome;
    }

    private static boolean isPalindrome(long number){
        ImmutableList<String> digits = ImmutableList.copyOf(Splitter.fixedLength(1).split(String.valueOf(number)));
        int i = 0;
        int j = digits.size() - 1;

        while (i <= j){
            if (!digits.get(i++).equals(digits.get(j--))){
                return false;
            }
        }
        return true;
    }
}
