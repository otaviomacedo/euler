package euler;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class Problem003Test {

    @Test
    public void test() throws Exception{
        assertThat(LargestPrimeFactor.forNumber(13195L), is(29L));
    }

    @Test
    public void testname() throws Exception {
        assertThat(LargestPrimeFactor.forNumber(600851475143L), is(6857L));
    }

    @Test
    public void testname1() throws Exception {
        assertThat(LargestPrimeFactor.forNumber(94L), is(47L));
    }

    @Test
    public void maxNumber() throws Exception {
        assertThat(LargestPrimeFactor.forNumber(Long.MAX_VALUE), is(649657L));
    }

}
