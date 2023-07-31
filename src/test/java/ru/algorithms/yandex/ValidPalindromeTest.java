package ru.algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * The type ValidPalindromeTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/valid-palindrome/">...</a>}
 */
public class ValidPalindromeTest {


    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of("A man, a plan, a canal: Panama", true),
            Arguments.of("race a car", false),
            Arguments.of(" ", true),
            Arguments.of("aa", true),
            Arguments.of("0P", false)
        );
    }

    @DisplayName("125. Valid Palindrome")
    @ParameterizedTest
    @MethodSource("source")
    void isPalindrome(
        String s,
        boolean expected
    ) {

        boolean result = true;

        StringBuilder builder = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (65 <= c && c <= 90) {
                builder.append(Character.toLowerCase(c));
            } else if (97 <= c && c <= 122 || 48 <= c && c <= 57) {
                builder.append(c);
            }
        }
        char[] pArray = builder.toString().toCharArray();

        int start = 0;
        int end = pArray.length;

        while (start < end) {
            if (pArray[start] != pArray[end - 1]) {
                result = false;
                break;
            }
            start++;
            end--;
        }

        Assertions.assertEquals(expected, result);
    }
}
