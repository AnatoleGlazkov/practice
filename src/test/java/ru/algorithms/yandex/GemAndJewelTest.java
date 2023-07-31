package ru.algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/** The type GemAndJewel */
public class GemAndJewelTest {

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of("ab", "aabbccd", 4),
            Arguments.of("xxo", "ukzxlzxlnqoplmvwltlkvatmnnlllxrzcuqlhgomacnpeudfjpvliodepczv", 6)
        );
    }

    @ParameterizedTest
    @DisplayName("Gem And Jewel")
    @MethodSource("provideData")
    void GemAndJewel(
        String jewels,
        String gems,
        int expected
    ) {
        int[] bank = new int[26];
        int jewelBank = 0;

        for (char gem : gems.toCharArray()) {
            bank[gem - 'a']++;
        }

        boolean[] visited = new boolean[26];

        for (char jewel : jewels.toCharArray()) {
            int i = jewel - 'a';
            if (!visited[i]) {
                jewelBank += bank[i];
                visited[i] = true;
            }
        }

        Assertions.assertEquals(expected, jewelBank);
    }
}