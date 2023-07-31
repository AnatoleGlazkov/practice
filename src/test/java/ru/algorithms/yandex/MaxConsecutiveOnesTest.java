package ru.algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * The type MaxConsecutiveOnesTest
 * <p>
 * {@link  <a href="https://leetcode.com/problems/max-consecutive-ones-iii/">...</a>}
 */
public class MaxConsecutiveOnesTest {


    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2, 6),
            Arguments.of(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3, 10)
        );
    }

    @DisplayName("1004. Max Consecutive Ones III")
    @ParameterizedTest
    @MethodSource("source")
    void longestOnes(
        int[] nums,
        int k,
        int expected
    ) {

        int left = 0;
        int zero = 0;
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) zero++;

            while (zero > k) {
                if (nums[left] == 0) zero--;
                left++;
            }

            result = Math.max(result, i - left + 1);
        }

        Assertions.assertEquals(expected, result);
    }
}
