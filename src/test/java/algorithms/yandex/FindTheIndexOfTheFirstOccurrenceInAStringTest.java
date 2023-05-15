package algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * The type FindTheIndexOfTheFirstOccurrenceInAStringTest
 * {@link <a href="https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/">...</a>}
 */
public class FindTheIndexOfTheFirstOccurrenceInAStringTest {


    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of("sadbutsad", "sad", 0),
            Arguments.of("leetcode", "leeto", -1)
        );
    }

    @ParameterizedTest
    @DisplayName("28. Find the Index of the First Occurrence in a String")
    @MethodSource("source")
    public void strStr(
        String haystack,
        String needle,
        int expected
    ) {
        Assertions.assertEquals(expected, haystack.indexOf(needle));
    }

}
