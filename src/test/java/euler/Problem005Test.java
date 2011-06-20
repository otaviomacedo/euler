package euler;

import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.core.Is.*;
import static org.junit.Assert.assertThat;

public class Problem005Test {

    @Test
    public void test1() throws Exception {
        assertThat(LeastCommonMultiple.between(range(1, 10)), is(2520));
    }

    @Test
    public void test2() throws Exception {
        assertThat(LeastCommonMultiple.between(range(1, 20)), is(232792560));
    }

    private static List<Integer> range(int min, int max) {
        List<Integer> range = newArrayList();
        for (int i = min; i <= max; i++) {
            range.add(i);
        }
        return range;
    }


}
