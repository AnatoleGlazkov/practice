package ru.algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

/**
 * The type ValidParentheses
 * <p>
 * {@link <a href="https://leetcode.com/problems/valid-parentheses/">...</a>}
 */
public class ValidParenthesesTest {


    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of("()", true),
            Arguments.of("()[]{}", true),
            Arguments.of("(]", false),
            Arguments.of("{[]}", true)

        );
    }

    @DisplayName("20. Valid Parentheses")
    @ParameterizedTest
    @MethodSource("source")
    void isValidEquals(
        String s,
        boolean expected
    ) {

        Assertions.assertEquals(expected, getCharacters(s));
    }

    private boolean getCharacters(String s) {


        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            switch (c) {
                case '(', '[', '{' -> stack.push(c);
                case ')' -> {
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.pop() != ']') return false;
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.pop() != '}') return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
