package ru.algorithms.array.bubble;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static ru.utils.ArrayUtils.check;

/** The type BubbleSortTest */
public class BubbleSortTest {

    public static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 4, 6, 2, 3}, new int[]{1, 2, 2, 3, 4, 6}),
            Arguments.of(new int[]{6, 1, 2, 4, 5, 2, 3}, new int[]{1, 2, 2, 3, 4, 5, 6}),
            Arguments.of(new int[]{6, 1, 1, 4, 5, 1, 1}, new int[]{1, 1, 1, 1, 4, 5, 6})
        );
    }

    @ParameterizedTest
    @DisplayName("bubble sort")
    @MethodSource("source")
    void sort(
        int[] array,
        int[] expected
    ) {
        int n = array.length - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        Assertions.assertTrue(check(expected, array));
    }
}
