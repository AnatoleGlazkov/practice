package ru.yandex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** The type GenerationOfBracketSequences */
public class GenerationOfBracketSequences {

    private static final String readFilePath = "src/main/resources/bracket/input.txt";
    private static final String writeFilePath = "src/main/resources/bracket/output.txt";

    public static void main(String... args) throws IOException {

        List<String> results = new ArrayList<>();
        int count;

        try (BufferedReader reader = new BufferedReader(new FileReader(readFilePath))) {
            count = Integer.parseInt(reader.readLine());
        }

        generate("", 0, 0, count, results);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFilePath))) {
            for (String res : results) {
                writer.write(res);
                writer.newLine();
            }
        }
    }

    private static void generate(
        String s,
        int openBrackets,
        int closedBrackets,
        int n,
        List<String> results
    ) {
        if (s.length() == 2 * n) {
            results.add(s);
            return;
        }

        if (openBrackets < n) {
            generate(s + "(", openBrackets + 1, closedBrackets, n, results);
        }

        if (closedBrackets < openBrackets) {
            generate(s + ")", openBrackets, closedBrackets + 1, n, results);
        }
    }


}
