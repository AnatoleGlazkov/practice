

package ru.utils;

import ru.utils.node.item.ListNode;

/** The type ArrayToListNode */
public final class ArrayToListNode {

    public static ListNode arrayToListNode(int... values) {
        return pack(values, 0);
    }

    private static ListNode pack(
        int[] values,
        int count
    ) {

        if (values.length == 0) return new ListNode(0, null);

        return values.length - 1 == count
               ? new ListNode(values[count], null)
               : new ListNode(values[count], pack(values, ++count));
    }

    public static boolean checkToListNode(
        final ListNode expectedNode,
        final ListNode result
    ) {

        if (expectedNode == null && result == null) {
            return true;
        }

        if (expectedNode != null && result != null && expectedNode.val == result.val) {
            return checkToListNode(expectedNode.next, result.next);
        }

        return false;
    }
}
