package algorithms.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static utils.ArrayUtils.check;

/** The type BubbleSortTest */
public class BubbleSortTest {


    public static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 4, 6, 2, 3}, new int[]{1, 2, 2, 3, 4, 6})
        );
    }

    @ParameterizedTest
    @DisplayName("bubble sort")
    @MethodSource("source")
    void sort(
        int[] array,
        int[] expected
    ) {

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {

                int prev = array[j - 1];
                int current = array[j];

                if (current < prev) {
                    array[j - 1] = current;
                    array[j] = prev;
                }
            }
        }

        Assertions.assertTrue(check(expected, array));
    }
}
