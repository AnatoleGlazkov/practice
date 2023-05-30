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
 * The type ReverseLinkedListTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/reverse-linked-list/description/">...</a>}
 */

public class ReverseLinkedListTest {

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(
                Named.named("-> [1,2,3,4,5]", arrayToListNode(1, 2, 3, 4, 5)),
                Named.named("[5,4,3,2,1]", arrayToListNode(5, 4, 3, 2, 1)))
        );
    }

    @ParameterizedTest
    @DisplayName("206. Reverse Linked List")
    @MethodSource("provideData")
    void reverseLinkedList(
        ListNode head,
        ListNode expectedNode
    ) {

        ListNode result = null;

        while (head != null) {
            ListNode tmp = head.next;
            head.next = result;
            result = head;
            head = tmp;
        }

        Assertions.assertTrue(checkToListNode(expectedNode, result));
    }

    private ListNode execute(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversed = execute(head.next);
        head.next.next = head;
        head.next = null;
        return reversed;
    }
}

