package algorithms.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

/**
 * The type DecodeStringTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/decode-string">...</a>}
 *
 * TODO 1.06
 */
public class DecodeStringTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of("3[a]2[bc]", "aaabcbc"),
            Arguments.of("3[a2[c]]", "accaccacc"),
            Arguments.of("2[abc]3[cd]ef", "abcabccdcdcdef")
        );
    }

    @ParameterizedTest
    @DisplayName("394. Decode String")
    @MethodSource("source")
    void decodeString(
        String s,
        String expected
    ) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> strBuild = new Stack<>();
        StringBuilder str = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                strBuild.push(str);
                str = new StringBuilder();
                numStack.push(num);
                num = 0;
            } else if (c == ']') {
                String temp = str.toString();
                str = strBuild.pop();
                str.append(temp.repeat(numStack.pop()));
            } else {
                str.append(c);
            }
        }

        Assertions.assertEquals(expected, str.toString());
    }

}


//        for (int i = s.length() - 1; i >= 0; i--) {
//            char c = s.charAt(i);
//            if (c == ']') {
//            buf.setLength(0);
//            continue;
//            } else if (c == '[') {
//            continue;
//            } else if (Character.isDigit(c)) {
//            String repeat = String.valueOf(buf).repeat(c - '0');
//            result.append(repeat);
//            } else {
//            buf.append(c);
//            }
//
//            }
