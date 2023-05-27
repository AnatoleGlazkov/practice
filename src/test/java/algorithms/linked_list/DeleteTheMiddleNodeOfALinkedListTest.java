package algorithms.linked_list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.node.item.ListNode;

import java.util.stream.Stream;

import static utils.ArrayToListNode.arrayToListNode;
import static utils.ArrayToListNode.checkToListNode;

/**
 * The type DeleteTheMiddleNodeOfALinkedListTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/">...</a>}
 * <p>
 * TODO 3.06
 */
public class DeleteTheMiddleNodeOfALinkedListTest {

    public static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(
                Named.of("1,3,4,7,1,2,6", arrayToListNode(1, 3, 4, 7, 1, 2, 6)),
                Named.of("1,3,4,1,2,6", arrayToListNode(1, 3, 4, 1, 2, 6))
            ),
            Arguments.of(
                Named.of("2,1", arrayToListNode(2, 1)),
                Named.of("2", arrayToListNode(2))
            )
        );
    }

    @ParameterizedTest
    @DisplayName("2095. Delete the Middle Node of a Linked List")
    @MethodSource("source")
    void deleteMiddle(
        ListNode head,
        ListNode expected
    ) {
        ListNode fast = head.next.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        Assertions.assertTrue(checkToListNode(expected, head));

    }
}
