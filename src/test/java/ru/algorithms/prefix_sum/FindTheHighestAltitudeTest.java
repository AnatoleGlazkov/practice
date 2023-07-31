package ru.algorithms.prefix_sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * The type FindTheHighestAltitudeTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/find-the-highest-altitude">...</a>}
 */
public class FindTheHighestAltitudeTest {

    public static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{-5, 1, 5, 0, -7}, 1),
            Arguments.of(new int[]{-4, -3, -2, -1, 4, 3, 2}, 0)
        );
    }

    @DisplayName("1732. Find the Highest Altitude")
    @ParameterizedTest
    @MethodSource("source")
    void largestAltitude(
        int[] gain,
        int expected
    ) {
        int result = 0;
        int highestPoint = 0;

        for (int n : gain) {
            highestPoint += n;
            result = Math.max(highestPoint, result);
        }

        Assertions.assertEquals(expected, result);
    }
}
