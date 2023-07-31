package ru.algorithms.pointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * The type IsSubsequence
 * <p>
 * {@link <a href="https://leetcode.com/problems/is-subsequence/">...</a>}
 */
public class IsSubsequence {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of("abc", "ahbgdc", true),
            Arguments.of("axc", "ahbgdc", false),
            Arguments.of("b", "abc", true)
        );
    }

    @ParameterizedTest
    @DisplayName("392. Is Subsequence")
    @MethodSource("source")
    public void isSubsequence(
        String s,
        String t,
        boolean expected
    ) {
        int slow = 0;
        int counter = s.length();

        for (int i = 0; i < t.length(); i++) {
            if(slow >= s.length()){
                break;
            }

            if (s.charAt(slow) == t.charAt(i)) {
                slow++;
                counter--;
            }
        }

        Assertions.assertEquals(expected, counter == 0);
    }
}
