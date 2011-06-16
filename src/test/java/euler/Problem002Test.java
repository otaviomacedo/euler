package euler;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.*;

public class Problem002Test {

    @Test
    public void test() throws Exception{
        assertThat(FibonacciSum.sumOfEvens(90), is(44L));
        assertThat(FibonacciSum.sumOfEvens(4000000), is(4613732L));
        assertThat(FibonacciSum.sumOfEvens(3472998263123445L), is(2763969850442378L));
    }
}
