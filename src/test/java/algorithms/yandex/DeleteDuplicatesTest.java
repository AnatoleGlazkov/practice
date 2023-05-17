package algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

import static utils.ArrayUtils.check;

/** The type DeleteDuplicates */
public class DeleteDuplicatesTest {

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(new int[]{5, 2, 4, 8, 8, 8}, new int[]{2, 4, 8}),
            Arguments.of(new int[]{5, 2, 2, 2, 8, 8}, new int[]{2, 8})
        );
    }

    @ParameterizedTest
    @DisplayName("Удаление дубликатов")
    @MethodSource("provideData")
    void deleteDuplicates(
        int[] consecutive,
        int[] expected
    ) {

        final Stack<Integer> bank = new Stack<>();

        for (int item : consecutive) {

            if (bank.empty()) bank.push(item);

            final Integer prevBankItem = bank.peek();

            if (prevBankItem.equals(item)) continue;
            if (prevBankItem > item) bank.clear();

            bank.push(item);
        }

        Assertions.assertTrue(check(expected, bank.stream().mapToInt(Integer::intValue).toArray()));
    }

}
