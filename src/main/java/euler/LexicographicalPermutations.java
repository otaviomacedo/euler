package euler;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.SortedSet;

public class LexicographicalPermutations {

    public static List<Integer> nthPermutationOf(long n, SortedSet<Integer> set){
        List<Integer> foo = foo(0, n - 1, set, Lists.<Integer>newArrayList());
        foo.addAll(set);
        return foo;
    }


    private static List<Integer> foo(long acc, long limit, SortedSet<Integer> toOrder, List<Integer> ordered){
        if (acc == limit){
            return ordered;
        }

        long factorial = Factorial.of(toOrder.size() - 1);
        int position = (int) ((limit - acc) / factorial);
        Integer nextOrderedElement = Iterables.get(toOrder, position);

        toOrder.remove(nextOrderedElement);
        ordered.add(nextOrderedElement);

        return foo(acc + position * factorial, limit, toOrder, ordered);
    }
}
