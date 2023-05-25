package yandex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** The type InterestingTravel */
public class InterestingTravel {

    private static final String readFilePath = "src/main/resources/travel/input.txt";
    private static final String writeFilePath = "src/main/resources/travel/output.txt";

    public static void main(String... args) throws IOException {
        final List<City> cites = new ArrayList<>();
        int petrol;
        int startCity;
        int endCity;

        try (BufferedReader reader = new BufferedReader(new FileReader(readFilePath))) {
            int countLine = Integer.parseInt(reader.readLine());
            // read cities
            for (int i = 0; i < countLine; i++) {
                String[] number = reader.readLine().split(" ");
                cites.add(new City(Integer.parseInt(number[0]), Integer.parseInt(number[1])));
            }
            // read gas
            petrol = Integer.parseInt(reader.readLine());
            // read start to end city
            String[] path = reader.readLine().split(" ");
            startCity = Integer.parseInt(path[0]) - 1;
            endCity = Integer.parseInt(path[1]) - 1;

        }

        int[][] matrix = new int[cites.size()][cites.size()];

        for (int i = 0; i < cites.size(); i++) {
            City currentCity = cites.get(i);

            for (int j = 0; j < cites.size(); j++) {
                if (i == j) continue;
                City city = cites.get(j);
                matrix[i][j] = Math.sqrt(Math.pow(currentCity.x - city.x, 2)
                    + Math.pow(currentCity.y - city.y, 2)) <= petrol
                               ? 1
                               : 0;
            }
        }

        int length = matrix.length;
        int shortestPath = findShortestPath(
            matrix,
            startCity,
            endCity,
            new boolean[length],
            0,
            length
        );

        if (shortestPath > length) shortestPath = -1;


        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFilePath))) {
            writer.write(String.valueOf(shortestPath));
        }

    }

    record City(double x, double y) {
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
