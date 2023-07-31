package ru.algorithms.sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * The type LongestSubarrayTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/">...</a>}
 */
public class LongestSubarrayTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{1, 1, 0, 1}, 3),
            Arguments.of(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}, 5),
            Arguments.of(new int[]{1, 1, 1}, 2),
            Arguments.of(new int[]{1, 1, 0, 0, 1, 1, 1, 0, 1}, 4)
        );
    }

    @ParameterizedTest
    @DisplayName("1493. Longest Subarray of 1's After Deleting One Element")
    @MethodSource("source")
    void longestSubarray(
        int[] nums,
        int expected
    ) {
        int left = 0;
        int zero = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) zero++;

            while (zero > 1) {
                if (nums[left] == 0) zero--;
                left++;
            }

            result = Math.max(result, i - left);
        }

        Assertions.assertEquals(expected, result);
    }
}