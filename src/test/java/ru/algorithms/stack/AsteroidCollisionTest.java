package ru.algorithms.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

/**
 * The type AsteroidCollisionTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/asteroid-collision">...</a>}
 *
 * TODO 1.06
 */
public class AsteroidCollisionTest {

    public static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{5, 10, -5}, new int[]{5, 10}),
            Arguments.of(new int[]{8, -8}, new int[]{}),
            Arguments.of(new int[]{10, 2, -5}, new int[]{10}),
            Arguments.of(new int[]{-2, -1, 1, 2}, new int[]{-2, -1, 1, 2})
        );
    }

    @ParameterizedTest
    @DisplayName("735. Asteroid Collision")
    @MethodSource("source")

    public void asteroidCollision(
        int[] asteroids,
        int[] expected
    ) {
        Stack<Integer> stack = new Stack<>();

        for (int ast : asteroids) {

            collision:
            {
                while (!stack.isEmpty() && ast < 0 && 0 < stack.peek()) {
                    if (stack.peek() < -ast) {
                        stack.pop();
                        continue;
                    } else if (stack.peek() == -ast) {
                        stack.pop();
                    }
                    break collision;
                }

                stack.push(ast);
            }
        }

        int[] result = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        Assertions.assertArrayEquals(expected, result);
    }
}
