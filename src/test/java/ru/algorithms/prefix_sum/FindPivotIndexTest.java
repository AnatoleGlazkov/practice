package ru.algorithms.prefix_sum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * The type FindPivotIndexTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/find-pivot-index">...</a>}
 *
 * TODO 27.05
 *
 */
public class FindPivotIndexTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{1, 7, 3, 6, 5, 6}, 3),
            Arguments.of(new int[]{1, 2, 3}, -1),
            Arguments.of(new int[]{2, 1, -1}, 0),
            Arguments.of(new int[]{-1, -1, -1, -1, -1, 0}, 2),
            Arguments.of(new int[]{-1, -1, -1, -1, 1, 1}, -1),
            Arguments.of(new int[]{-1, -1, -1, 0, 1, 1}, 0)
        );
    }

    @DisplayName("724. Find Pivot Index")
    @ParameterizedTest
    @MethodSource("source")
    void pivotIndex(
        int[] nums,
        int expected
    ) {

        int pivot = -1;
        int n = nums.length;
        int left=0,right=0;

        for (int num : nums) right += num;

        for(int i=0;i<n;i++){
            right -=nums[i];
            if(right==left) {
                pivot =  i;
                break;
            }
            left +=nums[i];
        }

        Assertions.assertEquals(expected, pivot);
    }
}
