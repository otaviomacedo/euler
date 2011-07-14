package euler;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.List;
import java.util.SortedSet;

import static com.google.common.collect.Sets.newTreeSet;
import static euler.LexicographicalPermutations.nthPermutationOf;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Problem024Test {

    @Test
    public void small() throws Exception {
        List<Integer> fourthPermutation = ImmutableList.of(1, 2, 0);

        assertThat(nthPermutationOf(4, sortedSet(0, 1, 2)), is(fourthPermutation));
    }

    @Test
    public void large() throws Exception {
        List<Integer> millionthPermutation = ImmutableList.of(2, 7, 8, 3, 9, 1, 5, 4, 6, 0);

        assertThat(nthPermutationOf(1000000, sortedSet(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)), is(millionthPermutation));
    }

    @Test
    public void monstrous() throws Exception {
        SortedSet<Integer> input = newTreeSet();
        for (int i = 0; i < 30000; i++) {
            input.add(i);
        }

        nthPermutationOf(Long.MAX_VALUE, input);
    }

    private SortedSet<Integer> sortedSet(Integer... values) {
        return Sets.newTreeSet(ImmutableList.copyOf(values));
    }
}
