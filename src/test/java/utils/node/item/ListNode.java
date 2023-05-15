

package utils.node.item;

import lombok.RequiredArgsConstructor;

/** The type ListNode */

@RequiredArgsConstructor
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(
        int val,
        ListNode next
    ) {
        this.val = val;
        this.next = next;
    }
}
