package euler;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Problem009Test {

    @Test
    public void testname() throws Exception {
        assertThat(PythagoreanTriplet.productForSum(12), is(60));
    }

    @Test
    public void testname2() throws Exception {
        assertThat(PythagoreanTriplet.productForSum(1000), is(31875000));
    }

    @Test
    public void max() throws Exception {
        assertThat(PythagoreanTriplet.productForSum(Integer.MAX_VALUE), is(31875000));
    }


}
