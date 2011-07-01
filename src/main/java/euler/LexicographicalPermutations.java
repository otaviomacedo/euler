package euler;

import com.google.common.collect.Iterables;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class LexicographicalPermutations {

    public static List<Integer> nthPermutationOf(long n, SortedSet<Integer> set){
        BigInteger factorial = Factorial.of(BigInteger.valueOf(set.size() - 1));
        List<Integer> foo = search(BigInteger.ZERO, BigInteger.valueOf(n - 1), set, new ArrayList<Integer>(), factorial);
        foo.addAll(set);
        return foo;
    }


    private static List<Integer> search(BigInteger acc, BigInteger limit, SortedSet<Integer> toOrder, List<Integer> ordered, BigInteger factorial){
        if (acc.equals(limit)){
            return ordered;
        }

        int position = limit.subtract(acc).divide(factorial).intValue();

        Integer nextOrderedElement = Iterables.get(toOrder, position);

        toOrder.remove(nextOrderedElement);
        ordered.add(nextOrderedElement);

        return search(acc.add(factorial.multiply(BigInteger.valueOf(position))), limit, toOrder, ordered, factorial.divide(BigInteger.valueOf(toOrder.size())));
    }
}
