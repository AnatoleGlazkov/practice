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

/**
 * The type MaximumTwinSumOfALinkedListTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list">...</a>}
 */
public class MaximumTwinSumOfALinkedListTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(
                Named.named("-> [5,4,2,1]", arrayToListNode(5, 4, 2, 1)), 6)
        );
    }

    @ParameterizedTest
    @DisplayName("2130. Maximum Twin Sum of a Linked List")
    @MethodSource("source")
    void pairSum(
        ListNode head,
        int expected
    ) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode middle = null;
        ListNode tmp = null;
        while (slow != null) {
            tmp = slow.next;
            slow.next = middle;
            middle = slow;
            slow = tmp;
        }

        ListNode start = head;
        ListNode reverseMiddle = middle;

        int max = 0;
        while (reverseMiddle != null) {
            max = Math.max(max, start.val + reverseMiddle.val);
            reverseMiddle = reverseMiddle.next;
            start = start.next;
        }

        Assertions.assertEquals(expected, max);
    }
}
