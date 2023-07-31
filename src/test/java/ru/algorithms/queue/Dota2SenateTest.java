package ru.algorithms.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * The type Dota2SenateTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/dota2-senate">...</a>}
 * <p>
 * TODO 3.06
 */
public class Dota2SenateTest {

    public static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of("RD", "Radiant"),
            Arguments.of("RDD", "Dire"),
            Arguments.of("DDRRRR", "Radiant"),
            Arguments.of("D", "Dire")
        );
    }

    @ParameterizedTest
    @DisplayName("649. Dota2 Senate")
    @MethodSource("source")
    void predictPartyVictory(
        String senate,
        String expected
    ) {
        int n = senate.length();

        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // make 2 queue senators
            if (senate.charAt(i) == 'R') rQueue.add(i);
            else dQueue.add(i);
        }

        while (!dQueue.isEmpty() && !rQueue.isEmpty()) {
            // vote
            int rTurn = rQueue.poll();
            int dTurn = dQueue.poll();

            if (dTurn < rTurn) {
                // after ban put d senator at the tail
                dQueue.add(dTurn + n);
            } else {
                rQueue.add(rTurn + n);
            }
        }

        Assertions.assertEquals(expected, rQueue.isEmpty() ? "Dire" : "Radiant");
    }
}
