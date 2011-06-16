package euler;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.primitives.Ints;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class LeastCommonMultiple {

    public static int between(int...values){
        return between(Ints.asList(values));
    }

    public static int between(List<Integer> values){
        int result = 1;
        Division division = new Division(2, values);
        while (division.hasNext()){
            division = division.next();
            result *= division.divisor;
        }
        return result;

    }

    private static class Division {
        private final int divisor;
        private final List<Integer> values;

        private Division(int divisor, List<Integer> values) {
            this.divisor = divisor;
            this.values = values;
        }

        public Division next(){
            int nextDivisor = divisor;
            while (true){
                List<Integer> nextValues = newArrayList(values);

                for (int i = 0; i < values.size(); i++) {
                    if (values.get(i) % nextDivisor == 0){
                        nextValues.set(i, values.get(i) / nextDivisor);
                    }
                }

                if (!nextValues.equals(values)){
                    return new Division(nextDivisor, nextValues);
                }
                nextDivisor++;
            }
        }

        public boolean hasNext(){
            Predicate<Integer> greaterThanOne = new Predicate<Integer>() {
                public boolean apply(Integer value) {
                    return value > 1;
                }
            };
            return Iterables.any(values, greaterThanOne);
        }

        @Override
        public String toString() {
            return String.format("%s | %d", Joiner.on(", ").join(values), divisor);
        }
    }
}
