package ru.algorithms.hash_map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

/**
 * The type FindTheDifferenceOfTwoArraysTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/find-the-difference-of-two-arrays">...</a>}
 * <p>
 */
public class FindTheDifferenceOfTwoArraysTest {


    public static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3}, new int[]{2, 4, 6}, List.of(List.of(1, 3), List.of(4, 6))),
            Arguments.of(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}, List.of(List.of(3), Collections.emptyList()))

        );
    }

    @ParameterizedTest
    @DisplayName("2215. Find the Difference of Two Arrays")
    @MethodSource("source")
    void findDifference(
        int[] nums1,
        int[] nums2,
        List<List<Integer>> expected
    ) {
        List<Integer> numsList1 = method(nums1, nums2);
        List<Integer> numsList2 = method(nums2, nums1);

        Assertions.assertEquals(expected, new ArrayList<>(List.of(numsList1, numsList2)));
    }

    private List<Integer> method(
        int[] master,
        int[] slave
    ) {
        Set<Integer> bank = new HashSet<>();
        Set<Integer> masterSet = new HashSet<>();

        for (int n : slave) bank.add(n);
        for (int n : master) if (!bank.contains(n)) masterSet.add(n);

        return new ArrayList<>(masterSet);
    }
}