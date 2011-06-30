package euler;

import com.google.common.collect.Iterables;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;

public class LexicographicalPermutations {

    public static List<Integer> nthPermutationOf(long n, SortedSet<Integer> set){
        List<Integer> foo = search(BigInteger.ZERO, BigInteger.valueOf(n - 1), set, new ArrayList<Integer>());
        foo.addAll(set);
        return foo;
    }


    private static List<Integer> search(BigInteger acc, BigInteger limit, SortedSet<Integer> toOrder, List<Integer> ordered){
        if (acc.equals(limit)){
            return ordered;
        }

        BigInteger factorial = Factorial.of(BigInteger.valueOf(toOrder.size() - 1));
        int position = limit.subtract(acc).divide(factorial).intValue();

        Integer nextOrderedElement = Iterables.get(toOrder, position);

        toOrder.remove(nextOrderedElement);
        ordered.add(nextOrderedElement);

        return search(acc.add(factorial.multiply(BigInteger.valueOf(position))), limit, toOrder, ordered);
    }
}
