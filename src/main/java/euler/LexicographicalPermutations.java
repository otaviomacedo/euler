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

    private static List<Integer> search(BigInteger targetPosition, SortedSet<Integer> elementsToPermutate){
        BigInteger currentPosition = BigInteger.ZERO;
        List<Integer> permutated = newArrayList();
        BigInteger smallestPossiblePosition = Factorial.of(BigInteger.valueOf(elementsToPermutate.size() - 1));

        while (!currentPosition.equals(targetPosition)){
            BigInteger index = targetPosition.subtract(currentPosition).divide(smallestPossiblePosition);

            Integer element = Iterables.get(elementsToPermutate, index.intValue());

            elementsToPermutate.remove(element);
            permutated.add(element);

            currentPosition = currentPosition.add(smallestPossiblePosition.multiply(index));
            smallestPossiblePosition = smallestPossiblePosition.divide(sizeOf(elementsToPermutate));
        }

        return permutated;
    }

    private static BigInteger sizeOf(SortedSet<Integer> toOrder) {
        return BigInteger.valueOf(toOrder.size());
    }
}
