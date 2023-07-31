package ru.algorithms.sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 *  The type MaximumAverageSubarrayTest
 * {@link <a href="https://leetcode.com/problems/maximum-average-subarray-i/">...</a>}
 */
public class MaximumAverageSubarrayTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{1, 12, -5, -6, 50, 3}, 4, 12.75000)
        );
    }

    @ParameterizedTest
    @DisplayName("643. Maximum Average Subarray I")
    @MethodSource("source")
    void findMaxAverage(
        int[] nums,
        int k,
        double expected
    ) {

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double result = sum;

        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            result = Math.max(result, sum);
        }


        Assertions.assertEquals(expected, result / k);
    }
}
