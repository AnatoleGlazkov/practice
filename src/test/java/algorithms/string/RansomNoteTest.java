package algorithms.string;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** The type RansomNote */
public class RansomNoteTest {


    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of("a", "b", false),
            Arguments.of("aa", "ab", false),
            Arguments.of("aa", "aab", true),
            Arguments.of("aab", "baa", true),
            Arguments.of("bg", "efjbdfbdgfjhhaiigfhbaejahgfbbgbjagbddfgdiaigdadhcfcj", true)
        );
    }

    @ParameterizedTest
    @DisplayName("383. Ransom Note")
    @MethodSource("provideData")
    void canConstruct(
        String ransomNote,
        String magazine,
        boolean expected
    ) {
        boolean result = ransomNote.length() <= magazine.length();

        int[] alphabetCount = new int[26];

        for (char c : magazine.toCharArray()) {
            alphabetCount[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (alphabetCount[c - 'a'] == 0) {
                result = false;
            }
            alphabetCount[c - 'a']--;
        }

        assertEquals(expected, result);
    }
}