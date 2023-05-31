

package utils.node.item;

import utils.node.Node;

/** The type TreeNode */
public class TreeNode implements Node {

    public final int val;
    public final TreeNode left;
    public final TreeNode right;

    public TreeNode(
        int val,
        TreeNode left,
        TreeNode right
    ) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public int val() {
        return val;
    }

    @Override
    public Node left() {
        return left;
    }
}
