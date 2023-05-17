package yandex;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/** The type ConsecutiveUnits */
public class ConsecutiveUnits {

    private static final String readFilePath = "src/main/resources/consecutive/input.txt";
    private static final String writeFilePath = "src/main/resources/consecutive/output.txt";

    @SneakyThrows
    public static void main(String... args) {

        final int[] numbers;

        try (BufferedReader reader = new BufferedReader(new FileReader(readFilePath))) {
            int read = reader.read() - '0';
            int[] letter = new int[read];

            for (int i = 0; i < read; i++) {
                letter[i] = reader.read() - '0';
            }

            numbers = letter;
        }

        int resultCount = 0;
        int currentCount = 0;

        for (int i : numbers) {
            if (i == 1) {
                currentCount++;
                resultCount = Math.max(currentCount, resultCount);
            } else {
                currentCount = 0;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFilePath))) {
            writer.write(String.valueOf(resultCount));
        }
    }

}
