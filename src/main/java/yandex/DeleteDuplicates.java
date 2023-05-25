package yandex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/** The type DeleteDuplicates */
public class DeleteDuplicates {

    private static final String readFileName = "src/main/resources/duplicates/input.txt";
    private static final String writeFileName = "src/main/resources/duplicates/output.txt";

    public static void main(String... args) throws IOException {

        final List<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(readFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                numbers.add(Integer.valueOf(line));
            }
        }

        final Stack<Integer> bank = new Stack<>();

        for (int num : numbers) {

            if (bank.empty()) bank.push(num);

            final int prevBankItem = bank.peek();

            if (prevBankItem == num) continue;
            if (prevBankItem > num) bank.clear();

            bank.push(num);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(writeFileName))) {
            while (!bank.empty()) {
                writer.write(String.valueOf(bank.pop()));
                writer.newLine();
            }
        }
    }
}
