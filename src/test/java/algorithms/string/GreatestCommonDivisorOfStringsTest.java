package algorithms.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * The type GreatestCommonDivisorOfStringsTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/greatest-common-divisor-of-strings/">...</a>}
 */
public class GreatestCommonDivisorOfStringsTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of("ABCABC", "ABC", "ABC"),
            Arguments.of("ABABAB", "ABAB", "AB"),
            Arguments.of("LEET", "CODE", ""),
            Arguments.of("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXX"),
            Arguments.of("CXTXNCXTXNCXTXNCXTXNCXTXN", "CXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXNCXTXN", "CXTXN"),
            Arguments.of("ABCDEF", "ABC", ""),
            Arguments.of("ABABABAB", "ABAB", "ABAB")
        );
    }

    @DisplayName("1071. Greatest Common Divisor of Strings")
    @ParameterizedTest
    @MethodSource("source")
    void gcdOfStrings(
        String str1,
        String str2,
        String expected
    ) {
        String result = "";
        int len1 = str1.length(), len2 = str2.length();

        for (int i = Math.min(len1, len2); i >= 1; --i) {
            if (len1 % i == 0 || len2 % i == 0) {
                String base = str1.substring(0, i);
                if (str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty()) {
                    result = base;
                    break;
                }
            }
        }

        Assertions.assertEquals(expected, result);
    }
}
