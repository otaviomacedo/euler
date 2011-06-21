package euler;

public class SumOfPrimes {
    public static long below(long number){
        PrimeIterator iterator = new PrimeIterator();
        long sum = 0;
        long prime = iterator.next();
        while (prime < number){
            sum += prime;
            prime = iterator.next();
        }
        return sum;
    }
}
