

package tree.solution;

import tree.Solution;
import utils.node.item.TreeNode;

/** The type SolutionMaxPath */
public class SolutionMaxPath implements Solution {

    private final TreeNode root;

    public SolutionMaxPath() {
        this.root = new TreeNode(1,
            new TreeNode(4,
                new TreeNode(2, null, null),
                new TreeNode(3,
                    new TreeNode(2, null, null),
                    null)),
            new TreeNode(7,
                new TreeNode(5, null, null),
                new TreeNode(4, null, null))
        );
    }

    @Override
    public TreeNode getRoot() {
        return root;
    }

    @Override
    public int maxPathSum() {
        return execute(this.root);
    }

    private int execute(TreeNode root) {
        if (root == null) return 0;

        int leftPath = execute(root.left);
        int rightPath = execute(root.right);

        return Math.max(leftPath, rightPath) + root.val();
    }
}
