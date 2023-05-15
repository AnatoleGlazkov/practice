package algorithms.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type MergeStringsAlternately
 * <p>
 * {@link <a href="https://leetcode.com/problems/merge-strings-alternately">...</a>}
 */
public class MergeStringsAlternatelyTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of("abc", "pqr", "apbqcr"),
            Arguments.of("ab", "pqrs", "apbqrs"),
            Arguments.of("abcd", "pq", "apbqcd")
        );
    }

    @DisplayName("1768. Merge Strings Alternately")
    @ParameterizedTest
    @MethodSource("source")
    void mergeAlternately(
        String word1,
        String word2,
        String expected
    ) {

        final StringBuilder res = new StringBuilder();
        final int w1l = word1.length();
        final int w2l = word2.length();

        for (int i = 0; i < Math.max(w1l, w2l); i++) {
            if (i < w1l) res.append(word1.charAt(i));
            if (i < w2l) res.append(word2.charAt(i));
        }

        assertEquals(expected, res.toString());
    }
}
