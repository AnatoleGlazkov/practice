package ru.algorithms.yandex;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.utils.ArrayUtils.check;

/**
 * The type IntersectionOfTwoArraysIiTest
 * {@link <a href="https://leetcode.com/problems/intersection-of-two-arrays-ii/">350. Intersection of Two Arrays II</a>}
 */
public class IntersectionOfTwoArraysIiTest {


    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new int[]{9, 4, 9, 8, 4}, new int[]{4, 9, 5}, new int[]{4, 9}),
            Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2, 2})
        );
    }

    @ParameterizedTest
    @DisplayName("350. Intersection of Two Arrays II")
    @MethodSource("provideData")
    public void intersect(
        int[] nums1,
        int[] nums2,
        int[] expected
    ) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                list.add(num);
                map.put(num, map.get(num) - 1);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        assertTrue(check(expected, result));
    }

    private void execute(
        int[] master,
        int[] slave,
        PriorityQueue<Integer> queue,
        int count1,
        int count2
    ) {

        if (master.length <= count1 || slave.length <= count2) return;

        if (master[count1] == slave[count2]) {
            queue.add(master[count1]);
            execute(master, slave, queue, ++count1, ++count2);
        } else {
            execute(master, slave, queue, count1, ++count2);
        }
    }
}
