package algorithms.hash_map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * The type EqualRowAndColumnPairsTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/equal-row-and-column-pairs"></a>}
 */
public class EqualRowAndColumnPairsTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}, 1),
            Arguments.of(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}, 3),
            Arguments.of(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 4}, {2, 4, 2, 2}, {2, 5, 2, 2}}, 3),
            Arguments.of(new int[][]{{13, 13}, {13, 13}}, 4),
            Arguments.of(new int[][]{{11, 1}, {1, 11}}, 2)
        );
    }

    @ParameterizedTest
    @DisplayName("2352. Equal Row and Column Pairs")
    @MethodSource("source")
    void equalPairs(
        int[][] grid,
        int expected
    ) {

        List<String> rBank = new ArrayList<>();
        List<String> cBank = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            StringBuilder row = new StringBuilder();
            StringBuilder column = new StringBuilder();

            for (int j = 0; j < grid.length; j++) {
                row.append(grid[i][j]);
                row.append(".");
                column.append(grid[j][i]);
                column.append(".");
            }

            rBank.add(row.toString());
            cBank.add(column.toString());
        }

        int result = 0;

        for (String rKey : rBank) {
            for (String cKey : cBank) {
                if (rKey.equals(cKey)) {
                    result++;
                }
            }
        }

        Assertions.assertEquals(expected, result);
    }
}
