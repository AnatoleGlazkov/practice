

package utils.node.item;

import utils.node.Node;

/** The type TreeNode */
public class SingleNode implements Node {

    private final int val;
    private final SingleNode left;

    public SingleNode(
        int val,
        SingleNode left
    ) {
        this.val = val;
        this.left = left;
    }

    @Override
    public int getVal() {
        return val;
    }

    @Override
    public SingleNode getLeft() {
        return left;
    }
}
