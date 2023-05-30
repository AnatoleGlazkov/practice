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
 * The type OddEvenLinkedListTest
 * <p>
 * {@link  <a href="https://leetcode.com/problems/odd-even-linked-list">...</a>}
 */
public class OddEvenLinkedListTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(
                Named.of("1,2,3,4,5", arrayToListNode(1, 2, 3, 4, 5)),
                Named.of("1,3,5,2,4", arrayToListNode(1, 3, 5, 2, 4))
            ),
            Arguments.of(
                Named.of("2,1,3,5,6,4,7", arrayToListNode(2, 1, 3, 5, 6, 4, 7)),
                Named.of("2,3,6,7,1,5,4", arrayToListNode(2, 3, 6, 7, 1, 5, 4))
            )
        );
    }

    @ParameterizedTest
    @DisplayName("328. Odd Even Linked List")
    @MethodSource("source")
    void oddEvenList(
        ListNode head,
        ListNode expected
    ) {

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        Assertions.assertTrue(checkToListNode(expected, head));
    }
}
