package algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/** The type AnagramsTest */
public class AnagramsTest {

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of("qiu", "iuq", true),
            Arguments.of("zprl", "zprc", false)
        );
    }

    @ParameterizedTest
    @DisplayName("Анаграммы")
    @MethodSource("provideData")
    void anagrams(
        String firstWord,
        String secondWord,
        boolean expected
    ) {

        boolean result = true;

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
                    result = false;
                    break;
                }
            }

        } else {
            result = false;
        }

        Assertions.assertEquals(expected, result);
    }
}
