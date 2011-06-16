package euler;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SumMultiplesBelowTest {

    @Test
    public void test1() throws Exception{
        SumMultiplesBelow sum = new SumMultiplesBelow(10);
        assertThat(sum.calculate(3, 5), is(23));
    }

    @Test
    public void test2() throws Exception {
        SumMultiplesBelow sum = new SumMultiplesBelow(27);
        assertThat(sum.calculate(4, 11), is(117));
    }

    @Test
    public void test3() throws Exception {
        SumMultiplesBelow sum = new SumMultiplesBelow(25);
        assertThat(sum.calculate(6, 8), is(84));
    }


    @Test
    public void testname() throws Exception {
        SumMultiplesBelow sum = new SumMultiplesBelow(1000);
        System.out.println(sum.calculate(3, 5));

    }
}
