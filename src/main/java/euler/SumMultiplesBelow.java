package euler;

public class SumMultiplesBelow {

    private final int limit;

    public SumMultiplesBelow(int limit) {
        this.limit = limit;
    }

    public int calculate(int a, int b){
        return term(a) + term(b) - term(LeastCommonMultiple.between(a, b));
    }

    private int term(int x){
        return x * sumOfFirstIntegers(maxMultiplicand(x, limit));
    }

    private static int sumOfFirstIntegers(int n){
        return n * (n + 1) / 2;
    }

    private static int maxMultiplicand(int x, int limit){
        return limit % x == 0 ? limit / x - 1 : limit / x;
    }
}
