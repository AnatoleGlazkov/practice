

package utils.node.item;

import utils.node.Node;

/** The type TreeNode */
public class DoublyNode implements Node {

    private final int val;
    private final DoublyNode left;
    private final DoublyNode right;

    public DoublyNode(
        int val,
        DoublyNode left,
        DoublyNode right
    ) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public int getVal() {
        return val;
    }

    @Override
    public DoublyNode getLeft() {
        return left;
    }

    public DoublyNode getRight() {
        return right;
    }
}
