package euler;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.*;

public class Problem004Test {

    @Test
    public void twoDigitsCase() throws Exception {
        assertThat(LargestPalidromeNumber.withNDigits(2), is(9009L));
    }

    @Test
    public void threeDigitsCase() throws Exception {
        assertThat(LargestPalidromeNumber.withNDigits(3), is(906609L));
    }
}
