package algorithms.yandex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** The type ConsecutiveUnits */
public class ConsecutiveUnitsTest {

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new int[]{5, 1, 0, 1, 0, 1}, 1),
            Arguments.of(new int[]{5, 1, 0, 1, 1, 0, 1}, 2),
            Arguments.of(new int[]{5, 1, 0, 1, 1, 0, 1, 1, 1, 1}, 4),
            Arguments.of(new int[]{5, 5, 0, 4, 4, 0, 4}, 0),
            Arguments.of(new int[]{5, 1, 1, 1, 0, 1, 0, 1}, 3)
        );
    }

    @ParameterizedTest
    @DisplayName("ConsecutiveUnits")
    @MethodSource("provideData")
    void consecutiveUnits(
            int[] consecutive,
        int expected
    ) {
        int resultCount = 0;
        int currentCount = 0;

        for (int c : consecutive) {
            if (c == 1) {
                currentCount++;
                resultCount = Math.max(currentCount, resultCount);
            } else {
                currentCount = 0;
            }
        }

        assertEquals(expected, resultCount);
    }
}