package algorithms.pointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * The type ContainerWithMostWaterTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/container-with-most-water">...</a>}
 * <p>
 * TODO return 26.06
 */
public class ContainerWithMostWaterTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49),
            Arguments.of(new int[]{3, 2, 2, 2, 2, 2, 3, 2, 2}, 18)
        );
    }

    @DisplayName("11. Container With Most Water")
    @ParameterizedTest
    @MethodSource("source")
    void maxArea(
        int[] height,
        int expected
    ) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int w = right - left;
            int h = Math.min(height[right], height[left]);
            int area = w * h;

            max = Math.max(max, area);

            if (height[left] < height[right]) left++;
            else if (height[left] > height[right]) right--;
            else {
                left++;
                right--;
            }
        }

        Assertions.assertEquals(expected, max);
    }
}
