package ru.algorithms.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * The type IncreasingTripletSubsequenceTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/increasing-triplet-subsequence">...</a>}
 */
public class IncreasingTripletSubsequenceTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4, 5}, true),
            Arguments.of(new int[]{5, 4, 3, 2, 1}, false),
            Arguments.of(new int[]{2, 1, 5, 0, 4, 6}, true),
            Arguments.of(new int[]{20, 100, 10, 12, 5, 13}, true)
        );
    }

    @DisplayName("334. Increasing Triplet Subsequence")
    @ParameterizedTest
    @MethodSource("source")
    public void increasingTriplet(
        int[] nums,
        boolean expected
    ) {
        boolean result = false;

        int max1 = Integer.MAX_VALUE;
        int max2 = Integer.MAX_VALUE;

        for(int n : nums) {
            if(n <= max1) max1 = n;
            else if(n <= max2) max2 = n;
            else result = true;
        }

        Assertions.assertEquals(expected, result);
    }
}
