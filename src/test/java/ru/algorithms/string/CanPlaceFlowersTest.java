package ru.algorithms.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * The type CanPlaceFlowersTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/can-place-flowers/">...</a>}
 */
public class CanPlaceFlowersTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{1, 0, 0, 0, 1}, 1, true),
            Arguments.of(new int[]{1, 0, 0, 0, 1}, 2, false),
            Arguments.of(new int[]{1, 0, 0, 0, 0, 0, 1}, 2, true),
            Arguments.of(new int[]{1, 0, 0, 0, 0, 1}, 2, false),
            Arguments.of(new int[]{1, 0, 1, 0, 1, 0, 1}, 1, false),
            Arguments.of(new int[]{0, 0, 1, 0, 1}, 1, true),
            Arguments.of(new int[]{0}, 1, true),
            Arguments.of(new int[]{1}, 1, false)
        );
    }

    @DisplayName("605. Can Place Flowers")
    @ParameterizedTest
    @MethodSource("source")
    void canPlaceFlowers(
        int[] flowerbed,
        int n,
        boolean expected
    ) {
        int count = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                if (
                    (i == 0 || flowerbed[i - 1] == 0) &&
                        (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)
                ) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }

        Assertions.assertEquals(expected, count >= n);
    }
}
