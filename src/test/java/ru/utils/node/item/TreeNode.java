

package ru.utils.node.item;

import ru.utils.node.Node;

/** The type TreeNode */
public class TreeNode implements Node {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(
        int val,
        TreeNode left,
        TreeNode right
    ) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
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
