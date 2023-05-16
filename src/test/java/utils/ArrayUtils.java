

package utils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/** The type ArrayUtils */
public final class ArrayUtils {

    public static boolean check(
        int[] expected,
        int[] result
    ) {

        if (expected.length != result.length) return false;

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != result[i]) {
                System.out.println(printArray(expected));
                System.out.println(printArray(result));
                return false;
            }
        }

        return true;
    }

    public static boolean checkInteger(
        Integer[] expected,
        Integer[] result
    ) {

        if (expected.length != result.length) return false;

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] == null && result[i] == null) {
                continue;
            } else if (expected[i] == null || result[i] == null) {
                System.out.println(printArray(expected));
                System.out.println(printArray(result));
                return false;
            }

            if (!expected[i].equals(result[i])) {
                System.out.println(printArray(expected));
                System.out.println(printArray(result));
                return false;
            }
        }

        return true;
    }

    private static String printArray(Integer[] array) {
        return Stream.of(array).map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
    }

    private static String printArray(int[] array) {
        return Stream.of(array).map(String::valueOf).collect(Collectors.joining(",", "[", "]"));
    }

    public static boolean check(
        String[] expected,
        String[] result
    ) {
        if (expected.length != result.length) return false;

        for (int i = 0; i < expected.length; i++) {
            if (!expected[i].equals(result[i])) return false;
        }

        return true;
    }

    public static boolean check(
        char[] expected,
        char[] result
    ) {
        if (expected.length != result.length) return false;

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != result[i]) return false;
        }

        return true;
    }

    public static boolean check(
        boolean[] expected,
        boolean[] result
    ) {
        if (expected.length != result.length) return false;

        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != result[i]) return false;
        }

        return true;
    }

}
