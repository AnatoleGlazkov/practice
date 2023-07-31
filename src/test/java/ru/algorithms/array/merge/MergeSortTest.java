package ru.algorithms.array.merge;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static ru.utils.ArrayUtils.check;

public class MergeSortTest {


    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 4, 6, 2, 3}, new int[]{1, 2, 2, 3, 4, 6}),
            Arguments.of(new int[]{6, 1, 2, 4, 5, 2, 3}, new int[]{1, 2, 2, 3, 4, 5, 6}),
            Arguments.of(new int[]{6, 1, 1, 4, 5, 1, 1}, new int[]{1, 1, 1, 1, 4, 5, 6})
        );
    }

    @ParameterizedTest
    @DisplayName("MergeSort")
    @MethodSource("source")
    public void mergeSort(
        int[] arr,
        int[] expected
    ) {

        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);

        Assertions.assertTrue(check(expected, arr));
    }

    private static void mergeSort(
        int[] arr,
        int[] temp,
        int left,
        int right
    ) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, temp, left, mid);
        mergeSort(arr, temp, mid + 1, right);
        merge(arr, temp, left, mid, right);
    }

    private static void merge(
        int[] arr,
        int[] temp,
        int left,
        int mid,
        int right
    ) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k] = temp[i];
                i++;
            } else {
                arr[k] = temp[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            arr[k] = temp[i];
            i++;
            k++;
        }
    }
}