package algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * The type GenerateParenthesesTest
 * {@link <a href="https://leetcode.com/problems/generate-parentheses/">...</a>}
 */
public class GenerateParenthesesTest {


    public static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(3, Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"))
        );
    }

    @DisplayName("22. Generate Parentheses")
    @ParameterizedTest
    @MethodSource("source")
    void generateParenthesis(
        int n,
        List<String> expected
    ) {

        List<String> res = new ArrayList<>();
        generate("", n, res, 0, 0);
        Assertions.assertEquals(expected, res);
    }

    private void generate(
        String s,
        int n,
        List<String> res,
        int open,
        int close
    ) {
        if (s.length() == 2 * n) {
            res.add(s);
            return;
        }

        if (open < n) generate(s + "(", n, res, open + 1, close);
        if (close < open) generate(s + ")", n, res, open, close + 1);

    }
}
