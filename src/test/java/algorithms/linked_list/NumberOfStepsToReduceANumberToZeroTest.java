package algorithms.linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/** The type NumberOfStepsToReduceANumberToZeroTest */
public class NumberOfStepsToReduceANumberToZeroTest {

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.arguments(14, 6),
            Arguments.arguments(123, 12),
            Arguments.arguments(8, 4)
        );
    }

    @ParameterizedTest
    @DisplayName("1342. Number of Steps to Reduce a Number to Zero")
    @MethodSource("provideData")
    void numberOfSteps(
        final int number,
        final int expected
    ) {
        int actual = executed(number, 0);
        Assertions.assertEquals(expected, actual);
    }

    private int executed(
        int number,
        int counter
    ) {
        if (number == 0) {
            return counter;
        } else if (number % 2 == 1) {
            counter++;
            return executed(number - 1, counter);
        } else {
            counter++;
            return executed(number / 2, counter);
        }
    }
}
