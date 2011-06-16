package euler;

public class SumMultiplesBelow {

    private final int limit;

    public SumMultiplesBelow(int limit) {
        this.limit = limit;
    }

    public int calculate(int a, int b){
        return term(a) + term(b) - term(mcm(a, b));
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

    private static int mcm(int x, int y){
        int result = 1;
        Division division = new Division(x, y, 2);
        while (division.hasNext()){
            division = division.next();
            result *= division.divisor;
        }
        return result;
    }

    private static class Division {
        private final int a, b, divisor;

        private Division(int a, int b, int divisor) {
            this.a = a;
            this.b = b;
            this.divisor = divisor;
        }

        public Division next(){
            int nextDivisor = divisor;
            while (true){
                int nextA = a, nextB = b;
                if (a % nextDivisor == 0){
                    nextA = a/nextDivisor;
                }
                if (b % nextDivisor == 0){
                    nextB = b/nextDivisor;
                }
                if (nextA != a || nextB != b){
                    return new Division(nextA, nextB, nextDivisor);
                }
                nextDivisor++;
            }
        }

        public boolean hasNext(){
            return a > 1 || b > 1;
        }

        @Override
        public String toString() {
            return String.format("%d, %d | %d", a, b, divisor);
        }
    }

}
