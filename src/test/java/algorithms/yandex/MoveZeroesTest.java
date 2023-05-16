package algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static utils.ArrayUtils.check;

/**
 * The type MoveZeroes
 * {@link <a href="https://leetcode.com/problems/move-zeroes/">Move Zeroes</a>}
 */
public class MoveZeroesTest {

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(
                Named.of("[0,1,0,3,12]", new int[]{0, 1, 0, 3, 12}),
                Named.of("[1,3,12,0,0]", new int[]{1, 3, 12, 0, 0})
            )
        );
    }

    @ParameterizedTest
    @DisplayName("283. Move Zeroes")
    @MethodSource("provideData")
    void moveZeroes(
        int[] nums,
        int[] expected
    ) {
        int counter = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[counter] = nums[i];
                counter++;
            }
        }


        for (int i = counter; i < nums.length; i++) {
            nums[i] = 0;
        }

        Assertions.assertTrue(check(expected, nums));
    }

}
