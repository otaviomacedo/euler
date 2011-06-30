package euler;

import java.math.BigInteger;

public class Factorial {

    public static BigInteger of(BigInteger n){
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = BigInteger.ONE; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            result = result.multiply(i);
        }
        return result;
    }


}
