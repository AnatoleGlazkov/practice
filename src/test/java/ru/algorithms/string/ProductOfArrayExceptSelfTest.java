package ru.algorithms.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static ru.utils.ArrayUtils.check;

/**
 * The type ProductOfArrayExceptSelfTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/product-of-array-except-self">238. Product of Array Except Self</a>}
 */
public class ProductOfArrayExceptSelfTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4}, new int[]{24, 12, 8, 6}),
            Arguments.of(new int[]{-1, 1, 0, -3, 3}, new int[]{0, 0, 9, 0, 0}),
            Arguments.of(new int[]{0, 0}, new int[]{0, 0}),
            Arguments.of(new int[]{0, 4, 0}, new int[]{0, 0, 0})
        );
    }

    @DisplayName("238. Product of Array Except Self")
    @ParameterizedTest
    @MethodSource("source")
    public void productExceptSelf(
        int[] nums,
        int[] expected
    ) {
        int zeroCount = 0;
        int[] result = new int[nums.length];
        int max = 0;

        for (int n : nums) {
            if (n != 0) {
                max = max != 0 ? max * n : n;
            } else {
                zeroCount++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (zeroCount == 0) {
                result[i] = max / num;
            } else if (zeroCount == 1 && num == 0) {
                result[i] = max;
            } else {
                result[i] = 0;
            }
        }

        Assertions.assertTrue(check(expected, result));
    }
}
