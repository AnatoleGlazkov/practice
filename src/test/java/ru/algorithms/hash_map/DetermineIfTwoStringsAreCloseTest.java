package ru.algorithms.hash_map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * The type DetermineIfTwoStringsAreCloseTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/determine-if-two-strings-are-close">...</a>}
 */
public class DetermineIfTwoStringsAreCloseTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of("abc", "bca", true),
            Arguments.of("a", "aa", false),
            Arguments.of("cabbba", "abbccc", true),
            Arguments.of("uau", "ssx", false),
            Arguments.of("aaabbbbccddeeeeefffff", "aaaaabbcccdddeeeeffff", false)
        );
    }

    @ParameterizedTest
    @DisplayName("1657. Determine if Two Strings Are Close")
    @MethodSource("source")
    public void closeStrings(
        String word1,
        String word2,
        boolean expected
    ) {
        Assertions.assertEquals(expected, execute(word1, word2));
    }

    private boolean execute(
        String word1,
        String word2
    ) {

        if (word1.length() != word2.length()) return false;

        int[] bankW1 = new int[26];
        int[] bankW2 = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            bankW1[word1.charAt(i) - 'a']++;
            bankW2[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((bankW1[i] == 0 && bankW2[i] != 0) || (bankW1[i] != 0 && bankW2[i] == 0))
                return false;
        }

        Arrays.sort(bankW1);
        Arrays.sort(bankW2);

        return Arrays.equals(bankW1, bankW2);
    }
}
