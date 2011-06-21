package euler;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.UnmodifiableIterator;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class PrimeIterator extends UnmodifiableIterator<Long>{

    private long currentPrime = 1;
    private final CompositeSet compositeSet = new CompositeSet();

    public boolean hasNext() {
        return true; //by Euclid's theorem
    }

    public Long next() {
        long candidate = currentPrime + increment();
        while (compositeSet.contains(candidate)){
            candidate += 2;
        }
        currentPrime = candidate;
        compositeSet.addAllMultiplesOf(currentPrime);
        return currentPrime;
    }

    private int increment(){
        return currentPrime <= 2 ? 1 : 2;
    }

    private static class CompositeSet {
        private final List<CompositeSlider> sliders = newArrayList();

        public boolean contains(long number){
            return Predicates.or(sliders).apply(number);
        }

        public void addAllMultiplesOf(long number){
            sliders.add(new CompositeSlider(number));
        }
    }

    private static class CompositeSlider implements Predicate<Long> {
        private final long multiplicand;
        private long a, b;


        public CompositeSlider(long multiplicand) {
            a = 0;
            b = multiplicand * multiplicand;
            this.multiplicand = multiplicand;
        }

        public boolean apply(Long number) {
            // Look Ma, mutable state!
            if (number > b){
                a = b;
                b += multiplicand;
            }
            return a == number || b == number;
        }
    }
}
