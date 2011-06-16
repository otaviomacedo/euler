package euler;

import com.google.common.base.Splitter;
import org.apache.commons.lang.StringUtils;

import java.util.Collections;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;

public class ProductOfConsecutiveDigits {

    public static long forNumberAndLength(String number, int length){
        Set<Long> products = newHashSet();
        for (int i = 0; i <= number.length() - length; i++) {
            String substring = StringUtils.substring(number, i, i + length);
            Iterable<String> digits = Splitter.fixedLength(1).split(substring);

            long product = 1;
            for (String digit : digits) {
                product *= Integer.valueOf(digit);
            }
            products.add(product);
        }

        return Collections.max(products);
    }
}
