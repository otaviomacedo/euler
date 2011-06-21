package euler;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class Problem007Test {

    @Test
    public void testFirst10Primes() throws Exception{
        List<Long> primes = ImmutableList.copyOf(Iterators.limit(new PrimeIterator(), 10));
        List<Long> expectedPrimes = ImmutableList.of(2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L);

        assertThat(primes, is(equalTo(expectedPrimes)));
    }

    @Test
    public void test10001stPrime() throws Exception {
        // Guava advances iterator position + 1 times, returning the element at the positionth position.
        assertThat(Iterators.get(new PrimeIterator(), 10000), is(104743L));
    }
}
