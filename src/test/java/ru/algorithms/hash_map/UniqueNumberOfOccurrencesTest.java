package ru.algorithms.hash_map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

/**
 * The type UniqueNumberOfOccurrencesTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/unique-number-of-occurrences">...</a>}
 */
public class UniqueNumberOfOccurrencesTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 2, 1, 1, 3}, true),
            Arguments.of(new int[]{1, 2}, false),
            Arguments.of(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}, true)
        );
    }

    @ParameterizedTest
    @DisplayName("1207. Unique Number of Occurrences")
    @MethodSource("source")
    void uniqueOccurrences(
        int[] arr,
        boolean expected
    ) {
        final Map<Integer, Integer> bank = new HashMap<>();

        for (int num : arr) {
            bank.put(num, bank.getOrDefault(num, 0) + 1);
        }

        Assertions.assertEquals(expected, bank.size() == new HashSet<>(bank.values()).size());
    }
}
