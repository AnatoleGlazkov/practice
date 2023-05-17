package yandex;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/** The type Anagrams */
public class Anagrams {

    private static final String readFileName = "src/main/resources/anagrams/input.txt";
    private static final String writeFileName = "src/main/resources/anagrams/output.txt";

    @SneakyThrows
    public static void main(String... args) {

        int result = 1;
        String firstWord;
        String secondWord;

        try (BufferedReader reader = new BufferedReader(new FileReader(readFileName))) {
            firstWord = reader.readLine();
            secondWord = reader.readLine();
        }

        if (firstWord.length() == secondWord.length()) {

            int[] firstMap = new int[26];
            int[] secondMap = new int[26];

            for (char c : firstWord.toCharArray()) {
                firstMap[c - 'a']++;
            }

            for (char c : secondWord.toCharArray()) {
                secondMap[c - 'a']++;
            }

            for (int i = 0; i < firstMap.length; i++) {
                if (firstMap[i] != secondMap[i]) {
                    result = 0;
                    break;
                }
            }

        } else {
            result = 0;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFileName))) {
            writer.write(String.valueOf(result));
        }

    }
}
