package ru.algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.utils.node.item.ListNode;

import java.util.stream.Stream;

import static ru.utils.ArrayToListNode.arrayToListNode;
import static ru.utils.ArrayToListNode.checkToListNode;

/**
 * The type MergeTwoSortedListsTest
 * {@link <a href="https://leetcode.com/problems/merge-two-sorted-lists/">21. Merge Two Sorted Lists</a>}
 */
public class MergeTwoSortedListsTest {

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(
                Named.of("[1,2,4]", arrayToListNode(1, 2, 4)),
                Named.of("[1,3,4]", arrayToListNode(1, 3, 4)),
                Named.of("[1,1,2,3,4,4]", arrayToListNode(1, 1, 2, 3, 4, 4))
            ),
            Arguments.of(
                Named.of("[5,6]", arrayToListNode(5, 6)),
                Named.of("[1,2,3,4]", arrayToListNode(1, 2, 3, 4)),
                Named.of("[1,2,3,4,5]", arrayToListNode(1, 2, 3, 4, 5, 6))
            ),
            Arguments.of(
                Named.of("[1,2,3,4, 9]", arrayToListNode(1, 2, 3, 4, 9)),
                Named.of("[5,6]", arrayToListNode(5, 6)),
                Named.of("[1,2,3,4,5,6,9]", arrayToListNode(1, 2, 3, 4, 5, 6, 9))
            )
        );
    }

    @ParameterizedTest
    @DisplayName("21. Merge Two Sorted Lists")
    @MethodSource("provideData")
    void mergeTwoSortedLists(
        final ListNode list1,
        final ListNode list2,
        final ListNode expected
    ) {
        ListNode result = execute(list1, list2);

        Assertions.assertTrue(checkToListNode(expected, result));
    }

    private ListNode execute(
        ListNode list1,
        ListNode list2
    ) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = execute(list1.next, list2);
            return list1;
        } else {
            list2.next = execute(list1, list2.next);
            return list2;
        }
    }
}
