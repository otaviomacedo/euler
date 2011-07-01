package euler;

import com.google.common.collect.Iterables;

import java.math.BigInteger;
import java.util.List;
import java.util.SortedSet;

import static com.google.common.collect.Lists.newArrayList;

public class LexicographicalPermutations {

    public static List<Integer> nthPermutationOf(long n, SortedSet<Integer> set){
        List<Integer> incomplete = search(BigInteger.valueOf(n - 1), set);
        incomplete.addAll(set);
        return incomplete;
    }

    private static List<Integer> search(BigInteger limit, SortedSet<Integer> toOrder){
        BigInteger acc = BigInteger.ZERO;
        List<Integer> ordered = newArrayList();
        BigInteger factorial = Factorial.of(BigInteger.valueOf(toOrder.size() - 1));

        while (!acc.equals(limit)){
            int position = limit.subtract(acc).divide(factorial).intValue();

            Integer nextOrderedElement = Iterables.get(toOrder, position);

            toOrder.remove(nextOrderedElement);
            ordered.add(nextOrderedElement);

            acc = acc.add(factorial.multiply(BigInteger.valueOf(position)));
            factorial = factorial.divide(BigInteger.valueOf(toOrder.size()));
        }

        return ordered;
    }
}
