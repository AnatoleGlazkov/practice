package algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static utils.ArrayUtils.checkInt;

/**
 * The type MergeSortedArray
 * <p>
 * {@link <a href="https://leetcode.com/problems/merge-sorted-array/">...</a>}
 */
public class MergeSortedArrayTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(
                Named.of("[1,2,3,0,0,0]", new int[]{1, 2, 3, 0, 0, 0}), 3,
                Named.of("[2,5,6]", new int[]{2, 5, 6}), 3,
                Named.of("[1,2,2,3,5,6]", new int[]{1, 2, 2, 3, 5, 6})
            ),
            Arguments.of(Named.of("[1]", new int[]{1}), 1,
                Named.of("null", new int[]{}), 0,
                Named.of("[1]", new int[]{1})
            ),
            Arguments.of(
                Named.of("[0]", new int[]{0}), 0,
                Named.of("[1]", new int[]{1}), 1,
                Named.of("[1]", new int[]{1})
            ),
            Arguments.of(
                Named.of("[2, 0]", new int[]{2, 0}), 1,
                Named.of("[1]", new int[]{1}), 1,
                Named.of("[1]", new int[]{1, 2})
            ),
            Arguments.of(
                Named.of("[4,0,0,0,0,0]", new int[]{4, 0, 0, 0, 0, 0}), 1,
                Named.of("[1,2,3,5,6]", new int[]{1, 2, 3, 5, 6}), 5,
                Named.of("[1,2,3,4,5,6]", new int[]{1, 2, 3, 4, 5, 6})
            )
        );
    }

    @DisplayName("88. Merge Sorted Array")
    @ParameterizedTest
    @MethodSource("source")
    public void merge(
        int[] nums1,
        int m,
        int[] nums2,
        int n,
        int[] expected
    ) {

        for (int i = nums1.length - 1; i >= 0; i--) {

            if (m <= 0) {
                n--;
                nums1[i] = nums2[n];
                continue;
            }
            if (n <= 0) {
                continue;
            }

            int i1 = nums1[m - 1];
            int i2 = nums2[n - 1];


            if (i1 <= i2) {
                nums1[i] = i2;
                n--;
            } else {
                nums1[i] = i1;
                nums1[m - 1] = 0;
                m--;
            }
        }

        Assertions.assertTrue(checkInt(expected, nums1));
    }
}
