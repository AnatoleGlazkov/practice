package ru.algorithms.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * The type KidsWithTheGreatestNumberOfCandiesTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/kids-with-the-greatest-number-of-candies">...</a>}
 */
public class KidsWithTheGreatestNumberOfCandiesTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{2, 3, 5, 1, 3}, 3, List.of(true, true, true, false, true)),
            Arguments.of(new int[]{4, 2, 1, 1, 2}, 1, List.of(true, false, false, false, false)),
            Arguments.of(new int[]{12, 1, 12}, 10, List.of(true, false, true)),
            Arguments.of(new int[]{4, 1, 4, 8, 9, 6, 4}, 1, List.of(false, false, false, true, true, false, false))
        );
    }

    @ParameterizedTest
    @DisplayName("1431. Kids With the Greatest Number of Candies")
    @MethodSource("source")
    void kidsWithCandies(
        int[] candies,
        int extraCandies,
        List<Boolean> expected
    ) {
        int maxCandies = 0;
        List<Boolean> result = new ArrayList<>();

        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        Assertions.assertEquals(expected, result);
    }
}
