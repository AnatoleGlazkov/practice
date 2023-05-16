package algorithms.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

/**
 * The type ReverseVowelsOfAStringTest
 * {@link  <a href="https://leetcode.com/problems/reverse-vowels-of-a-string/">...</a>}
 */
public class ReverseVowelsOfAStringTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of("hello", "holle"),
            Arguments.of("leetcode", "leotcede")
        );
    }

    @DisplayName("345. Reverse Vowels of a String")
    @ParameterizedTest
    @MethodSource("source")
    void reverseVowels(
        String s,
        String expected
    ) {
        char[] word = s.toCharArray();

        boolean[] isVowels = new boolean[s.length()];
        Stack<Character> vowels = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < word.length; i++) {
            char c = word[i];
            if (
                c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                    || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'
            ) {
                isVowels[i] = true;
                vowels.push(c);
            }
        }

        for (int i = 0; i < isVowels.length; i++) {
            if (isVowels[i]) {
                result.append(vowels.pop());
            } else {
                result.append(word[i]);
            }
        }

        Assertions.assertEquals(expected, result.toString());
    }
}
