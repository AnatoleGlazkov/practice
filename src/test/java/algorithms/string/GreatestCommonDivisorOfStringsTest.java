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
            Arguments.of("ABCDEF", "ABC", "")
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

//        StringBuilder result = new StringBuilder();
//
//        for (int i = 0; i < str1.length(); i++) {
//            char ch1 = str1.charAt(i);
//
//            if (str2.length() > i && ch1 == str2.charAt(i)) {
//                result.append(ch1);
//
//                String[] split = str1.split(result.toString());
//                if (split.length == 0) {
//                    break;
//                }
//            } else {
//                result.setLength(0);
//                break;
//            }
//        }

        Assertions.assertEquals(expected, gcdOfStrings(str1, str2));
    }


    public boolean valid(String str1, String str2, int k) {
        int len1 = str1.length(), len2 = str2.length();
        if (len1 % k > 0 || len2 % k > 0) {
            return false;
        } else {
            String base = str1.substring(0, k);
            return str1.replace(base, "").isEmpty() && str2.replace(base, "").isEmpty();
        }
    }


    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        for (int i = Math.min(len1, len2); i >= 1; --i) {
            if (valid(str1, str2, i)) {
                return str1.substring(0, i);
            }
        }
        return "";
    }

}
