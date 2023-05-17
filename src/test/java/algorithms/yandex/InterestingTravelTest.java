package algorithms.yandex;

import lombok.val;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

/** The type InterestingTravelTest */
public class InterestingTravelTest {

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(
                List.of(
                    new City(0, 0),
                    new City(0, 2),
                    new City(2, 2),
                    new City(0, -2),
                    new City(2, -2),
                    new City(2, -1),
                    new City(2, 1)
                ), 2, 1, 3, 2
            )
        );
    }

    @ParameterizedTest
    @DisplayName("Интересное путешествие")
    @MethodSource("provideData")
    void interestingTravel(
        final List<City> cites,
        final int petrol,
        final int startCity,
        final int endCity,
        final int expected
    ) {
        int[][] matrix = new int[cites.size()][cites.size()];

        for (int i = 0; i < cites.size(); i++) {
            City currentCity = cites.get(i);

            for (int j = 0; j < cites.size(); j++) {
                if (i == j) continue;
                val city = cites.get(j);
                matrix[i][j] = Math.sqrt(Math.pow(currentCity.x - city.x, 2)
                    + Math.pow(currentCity.y - city.y, 2)) <= petrol
                               ? 1
                               : 0;
            }
        }

        int shortestPath = myMethod(matrix, startCity - 1, endCity - 1, new boolean[matrix.length], 0, matrix.length);

        if (shortestPath > matrix.length) shortestPath = -1;

        Assertions.assertEquals(expected, shortestPath);

    }

    private int myMethod(
        int[][] matrix,
        int startCity,
        int endCity,
        boolean[] visited,
        int count,
        int shortest
    ) {

        if (startCity == endCity) {
            if (count < shortest) {
                shortest = count;
            }
            return shortest;
        }

        visited[startCity] = true;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[startCity][i] == 1 && !visited[i]) {
                shortest = myMethod(matrix, i, endCity, visited, count + 1, shortest);
            }
        }

        visited[startCity] = false;

        return shortest;
    }


    record City(double x, double y) {
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//            {0, 1, 1, 1},
//            {1, 0, 1, 1},
//            {1, 1, 0, 1},
//            {1, 1, 1, 0}
//        };

        int[][] matrix = {
            {0, 1, 0, 1, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 1, 0, 1},
            {0, 0, 1, 0, 0, 1, 0}
        };

//        int[][] matrix = {
//            {0, 0, 0, 0},
//            {0, 0, 0, 0},
//            {0, 0, 0, 0},
//            {0, 0, 0, 0}
//        };

        int shortestPath = findShortestPath(matrix, 0, 2, new boolean[matrix.length], 0, matrix.length);

        if (shortestPath > matrix.length) shortestPath = -1;

        System.out.println(shortestPath);

    }

    public static int findShortestPath(
        int[][] matrix,
        int startNode,
        int endNode,
        boolean[] visited,
        int count,
        int shortest
    ) {
        if (startNode == endNode) {
            if (count < shortest) {
                shortest = count;
            }
            return shortest;
        }

        visited[startNode] = true;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[startNode][i] != 0 && !visited[i]) {
                shortest = findShortestPath(matrix, i, endNode, visited, count + 1, shortest);
            }
        }

        visited[startNode] = false;

        return shortest;
    }


}
