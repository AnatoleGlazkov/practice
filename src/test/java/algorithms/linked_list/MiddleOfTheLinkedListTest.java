package algorithms.linked_list;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.node.item.ListNode;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.ArrayToListNode.arrayToListNode;
import static utils.ArrayToListNode.checkToListNode;

/** The type MiddleOfTheLinkedList */
public class MiddleOfTheLinkedListTest {

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(
                Named.named("-> [1,2,3,4,5]", arrayToListNode(1, 2, 3, 4, 5)),
                Named.named("[3,4,5]", arrayToListNode(3, 4, 5))),
            Arguments.of(
                Named.named("-> [1,2,3,4,5,6]", arrayToListNode(1, 2, 3, 4, 5, 6)),
                Named.named("[4,5,6]", arrayToListNode(4, 5, 6))),
            Arguments.of(
                Named.named("-> [1,2]", arrayToListNode(1, 2)),
                Named.named("[2]", arrayToListNode(2)))
        );
    }

    @ParameterizedTest
    @DisplayName("876. Middle of the Linked List")
    @MethodSource("provideData")
    public void middleNode(
        final ListNode head,
        final ListNode expectedNode
    ) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        assertTrue(checkToListNode(expectedNode, slow));
    }
}

