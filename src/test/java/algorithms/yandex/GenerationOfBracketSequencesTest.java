package algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/** The type GenerationOfBracketSequencesTest */
public class GenerationOfBracketSequencesTest {

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(1, List.of("()")),
            Arguments.of(2, List.of("(())", "()()")),
            Arguments.of(3, List.of("((()))", "(()())", "(())()", "()(())", "()()()"))
        );
    }

    @ParameterizedTest
    @DisplayName("Генерация скобочных последовательностей")
    @MethodSource("provideData")
    void GenerationOfBracketSequences(
        int number,
        List<String> expected
    ) {
        Assertions.assertEquals(expected, executed(number));
    }

    private static List<String> executed(int n) {
        List<String> results = new ArrayList<>();

        generate("", 0, 0, n, results);

        for (String res : results) {
            System.out.println(res);
        }

        return results;
    }

    private static void generate(
        String s,
        int openBrackets,
        int closedBrackets,
        int n,
        List<String> results
    ) {
        if (s.length() == 2 * n) {
            results.add(s);
            return;
        }

        if (openBrackets < n) {
            generate(s + "(", openBrackets + 1, closedBrackets, n, results);
        }

        if (closedBrackets < openBrackets) {
            generate(s + ")", openBrackets, closedBrackets + 1, n, results);
        }
    }
}
