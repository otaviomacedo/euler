package euler;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class LargestPrimeFactorTest {

    @Test
    public void test() throws Exception{
        assertThat(LargestPrimeFactor.forNumber(13195L), is(29L));
    }

    @Test
    public void testname() throws Exception {
        assertThat(LargestPrimeFactor.forNumber(600851475143L), is(6857L));
    }
}
