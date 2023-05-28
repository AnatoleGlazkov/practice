package algorithms.pointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

/**
 * The type MaxNumberOfKSumPairsTest
 * <p>
 * {@link  <a href="https://leetcode.com/problems/max-number-of-k-sum-pairs">...</a>}
 */
public class MaxNumberOfKSumPairsTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[]{1, 2, 3, 4}, 5, 2),
            Arguments.of(new int[]{3, 1, 3, 4, 3}, 6, 1),
            Arguments.of(new int[]{2, 2, 2, 3, 1, 1, 4, 1}, 4, 2),
            Arguments.of(new int[]{3, 5, 1, 5}, 2, 0),
            Arguments.of(new int[]{4, 4, 1, 3, 1, 3, 2, 2, 5, 5, 1, 5, 2, 1, 2, 3, 5, 4}, 2, 2)
        );
    }

    @DisplayName("1679. Max Number of K-Sum Pairs")
    @ParameterizedTest
    @MethodSource("source")
    void maxOperations(
        int[] nums,
        int k,
        int expected
    ) {
        Map<Integer, Integer> bank = new HashMap<>();
        int count = 0;

        for (int n : nums) {
            int sub = k - n;
            if (bank.containsKey(sub) && bank.get(sub) > 0) {
                count++;
                bank.put(sub, bank.get(sub) - 1);
            } else {
                bank.put(n, bank.getOrDefault(sub, 0) + 1);
            }
        }

        Assertions.assertEquals(expected, count);
    }
}
