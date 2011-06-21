package euler;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Problem010Test {

    @Test
    public void sumOfPrimesBelowTen() throws Exception {
        assertThat(SumOfPrimes.below(10L), is(17L));
    }

    @Test
    public void sumOfPrimesBelowTwoMillion() throws Exception {
        assertThat(SumOfPrimes.below(2000000L), is(142913828922L));
    }
}
