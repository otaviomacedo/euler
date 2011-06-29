package euler;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Problem019Test {

    @Test
    public void testname() throws Exception {
        int numberOfSundays = Month.countWeekDaysIn(WeekDay.SUNDAY, new Month(1, 1901), new Month(12, 2000));

        assertThat(numberOfSundays, is(171));
    }
}
