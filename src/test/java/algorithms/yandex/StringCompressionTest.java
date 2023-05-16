package algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

import static utils.ArrayUtils.check;

/**
 * The type StringCompressionTest
 * {@link <a href="https://leetcode.com/problems/string-compression">...</a>}
 * 42.5 MB
 */
public class StringCompressionTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(
                new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'},
                new char[]{'a', '2', 'b', '2', 'c', '3'},
                6
            ),
            Arguments.of(
                new char[]{'a'},
                new char[]{'a'},
                1
            ),
            Arguments.of(
                new char[]{'a', 'b', 'c'},
                new char[]{'a', 'b', 'c'},
                3
            )
        );
    }

    @ParameterizedTest
    @DisplayName("443. String Compression")
    @MethodSource("source")
    void compress(
        char[] chars,
        char[] expectedChar,
        int expected
    ) {

        Stack<Character> key = new Stack<>();
        Stack<Integer> value = new Stack<>();

        key.push(chars[0]);
        value.push(0);

        for (char c : chars) {
            if (key.peek() == c) {
                value.push(value.pop() + 1);
            } else {
                key.push(c);
                value.push(1);
            }
        }

        StringBuilder result = new StringBuilder();

        Stack<Character> keyResult = new Stack<>();
        Stack<Integer> valueResult = new Stack<>();

        while (!key.empty()) {
            keyResult.push(key.pop());
            valueResult.push(value.pop());
        }

        while (!keyResult.empty()) {
            result.append(keyResult.pop());
            if (valueResult.peek() != 1) result.append(valueResult.pop());
        }

        char[] charArray = result.toString().toCharArray();

        if (result.length() >= 0) System.arraycopy(charArray, 0, chars, 0, result.length());

        Assertions.assertEquals(expected, result.length());
        Assertions.assertTrue(check(expectedChar, result.toString().toCharArray()));
    }
}