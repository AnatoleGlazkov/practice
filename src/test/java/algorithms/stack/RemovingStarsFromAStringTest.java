package algorithms.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

/**
 * The type RemovingStarsFromAStringTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/removing-stars-from-a-string">...</a>}
 */
public class RemovingStarsFromAStringTest {

    private final static Character MAIN_CHAR = '*';

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of("leet**cod*e", "lecoe"),
            Arguments.of("erase*****", "")
        );
    }

    @ParameterizedTest
    @DisplayName("2390. Removing Stars From a String")
    @MethodSource("source")
    void removeStars(
        String s,
        String expected
    ) {
        Stack<Character> charStack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == MAIN_CHAR) {
                charStack.pop();
            } else {
                charStack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!charStack.isEmpty()) {
            result.append(charStack.pop());
        }

        Assertions.assertEquals(expected, result.reverse().toString());
    }
}
