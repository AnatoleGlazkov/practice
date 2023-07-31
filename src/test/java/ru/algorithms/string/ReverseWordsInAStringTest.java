package ru.algorithms.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

/**
 * The type ReverseWordsInAStringTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/reverse-words-in-a-string">...</a>}
 */
public class ReverseWordsInAStringTest {

    public static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of("the sky is blue", "blue is sky the"),
            Arguments.of("  hello world  ", "world hello"),
            Arguments.of("a good   example", "example good a")
        );
    }

    @DisplayName("151. Reverse Words in a String")
    @ParameterizedTest
    @MethodSource("source")
    public void reverseWords(
        String s,
        String expected
    ) {

        String[] split = s.split(" ");
        Stack<String> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();

        for (String word : split) {
            if (!word.isBlank()) {
                stack.push(word);
            }
        }

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
            if (!stack.isEmpty()) {
                builder.append(" ");
            }
        }
        Assertions.assertEquals(expected, builder.toString());
    }
}
