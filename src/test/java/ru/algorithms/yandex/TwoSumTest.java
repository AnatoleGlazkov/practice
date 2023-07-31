package ru.algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static ru.utils.ArrayUtils.check;

/**
 * The type TwoSumTest
 * {@link  <a href="https://leetcode.com/problems/two-sum/">...</a>}
 */
public class TwoSumTest {

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new int[]{2, 7, 11, 15}, new int[]{0, 1}, 9),
            Arguments.of(new int[]{3, 2, 4}, new int[]{1, 2}, 6),
            Arguments.of(new int[]{3, 3}, new int[]{0, 1}, 6),
            Arguments.of(new int[]{3, 2, 3}, new int[]{0, 2}, 6)
        );
    }

    @ParameterizedTest
    @DisplayName("1. Two Sum")
    @MethodSource("provideData")
    void twoSum(
        int[] nums,
        int[] expected,
        int target
    ) {

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i < j && nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        Assertions.assertTrue(check(expected, result));
    }
}