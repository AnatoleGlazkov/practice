package ru.algorithms.sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * The type MaximumNumberOfVowelsTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">...</a>}
 */
public class MaximumNumberOfVowelsTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of("abciiidef", 3, 3),
            Arguments.of("aeiou", 2, 2),
            Arguments.of("leetcode", 3, 2)
        );
    }

    @DisplayName("1456. Maximum Number of Vowels in a Substring of Given Length")
    @ParameterizedTest
    @MethodSource("source")
    void maxVowels(
        String s,
        int k,
        int expected
    ) {
        int sum = 0;

        Predicate<Character> isVowel = c -> c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';

        for (int i = 0; i < k; i++) {
            if (isVowel.test(s.charAt(i))) sum++;
        }

        int result = sum;

        for (int i = k; i < s.length(); i++) {
            int left = isVowel.test(s.charAt(i)) ? 1 : 0;
            int right = isVowel.test(s.charAt(i - k)) ? 1 : 0;

            sum += left - right;

            result = Math.max(result, sum);
        }


        Assertions.assertEquals(expected, result);
    }
}
