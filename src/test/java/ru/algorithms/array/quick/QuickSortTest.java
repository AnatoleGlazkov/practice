package ru.algorithms.array.quick;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static ru.utils.ArrayUtils.check;

/** The type QuickSortTest */
public class QuickSortTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 4, 6, 2, 3}, new int[]{1, 2, 2, 3, 4, 6}),
            Arguments.of(new int[]{6, 1, 2, 4, 5, 2, 3}, new int[]{1, 2, 2, 3, 4, 5, 6}),
            Arguments.of(new int[]{6, 1, 1, 4, 5, 1, 1}, new int[]{1, 1, 1, 1, 4, 5, 6})
        );
    }

    @ParameterizedTest
    @DisplayName("QuickSort")
    @MethodSource("source")
    public void quickSort(
        int[] arr,
        int[] expected
    ) {
        quickSort(arr, 0, arr.length - 1);
        Assertions.assertTrue(check(expected, arr));
    }

    private static void quickSort(
        int[] arr,
        int low,
        int high
    ) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(
        int[] arr,
        int low,
        int high
    ) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void swap(
        int[] arr,
        int i,
        int j
    ) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
