package euler;

import com.google.common.collect.Iterables;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.SortedSet;

import static com.google.common.collect.Lists.newArrayList;

/**
 * In this code the term "position" refers to the position in the list of lexicographically sorted permutations. Since
 * the number of permutations for n elements is n!, it would be impractical to actually build such a list in memory. So
 * it is only hypothetical. Let's call such list, P. Even without building P, we can infer some of its properties. The
 * ones that are important for this algorithm are:
 *
 *   (1) Let E be the set of elements to be permutated. If |E| = n, then P can be partitioned into n sublists, such that
 *       every permutation in a given sublist starts with the same element.
 *
 *   (2) Each sublist of P has (n-1)! elements.
 *
 *   (3) Let F(i) be the first element of all the permutations in the ith sublist, and E(i) the ith element of E. So,
 *       F(i) = E(i).
 *
 * Initially, the search space is the whole list of permutations. At each iteration, the search space is reduced to one
 * of its sublists. To find which of these sublists contain the target position the following formula is used:
 *
 *       sublistIndex = (targetPosition - currentPosition) div sublistSize
 *
 * Once the correct sublist is identified, its first element is added to the result. Using the property (3) above, we
 * know that such element is E(sublistIndex). To account for the fact that such element was already used, it is removed
 * from the set E.
 * 
 * The algorithm stops when the current position reaches the target position. At this point, the result may not have
 * been completely built. But this means that the elements that were not yet appended are exactly the elements that
 * remained in E. Since E is a sorted set (and remains so after each removal), we only need to append it to the
 * incomplete result, to get the complete permutation.
 *
 * Since exactly one element is appended to the resulting permutation at each iteration and the factorial is calculated
 * only for n, this algorithm has worst case complexity O(n).
 */
public class LexicographicalPermutations {

    public static <E> List<E> nthPermutationOf(long n, SortedSet<E> set) {
        List<E> incomplete = assemble(BigInteger.valueOf(n - 1), set);
        incomplete.addAll(set);
        return incomplete;
    }

    private static <E> List<E> assemble(BigInteger targetPosition, SortedSet<E> elementsToPermutate) {
        List<E> permutation = newArrayList();
        BigInteger currentPosition = BigInteger.ZERO;
        BigInteger sublistSize = Factorial.of(elementsToPermutate.size() - 1);

        while (!currentPosition.equals(targetPosition)) {
            BigInteger sublistIndex = targetPosition.subtract(currentPosition).divide(sublistSize);

            move(sublistIndex, elementsToPermutate, permutation);

            currentPosition = currentPosition.add(sublistSize.multiply(sublistIndex));
            sublistSize = sublistSize.divide(sizeOf(elementsToPermutate));
        }

        return permutation;
    }

    private static BigInteger sizeOf(SortedSet<?> toOrder) {
        return BigInteger.valueOf(toOrder.size());
    }

    private static <E> void move(BigInteger index, Collection<E> from, Collection<E> to){
        E element = get(from, index);
        from.remove(element);
        to.add(element);
    }

    private static <E> E get(Collection<E> set, BigInteger index){
        return Iterables.get(set, Integer.valueOf(index.toString()));
    }
}
