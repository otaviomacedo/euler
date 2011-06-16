package euler;

public class FibonacciSum {

    public static long sumOfEvens(long limit) {
        long result = 0;
        Fibonacci fibonacci = new Fibonacci(1, 2);
        while (fibonacci.second() < limit){
            fibonacci = fibonacci.next();
            if (fibonacci.first() % 2 == 0){
                result += fibonacci.first();
            }
        }
        return result;
    }



    private static class Fibonacci {
        private final long a, b;

        private Fibonacci(long a, long b) {
            this.a = a;
            this.b = b;
        }

        public Fibonacci next() {
            return new Fibonacci(b, a + b);
        }

        public long second() {
            return b;
        }

        public long first(){
            return a;
        }
    }
}
