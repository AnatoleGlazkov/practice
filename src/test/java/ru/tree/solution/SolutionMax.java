

package ru.tree.solution;

import ru.tree.Solution;
import ru.utils.node.item.TreeNode;

/** The type SolutionMax */
public class SolutionMax implements Solution {

    private int answer = 0;
    private final TreeNode root;

    public SolutionMax() {
        root = new TreeNode(
            -10,
            new TreeNode(9, null, null),
            new TreeNode(20,
                new TreeNode(-3,
                    new TreeNode(5,
                        new TreeNode(-2, null, null), null),
                    new TreeNode(-4, null, null)),
                new TreeNode(8,
                    null,
                    new TreeNode(-2, null, null)))
        );
    }

    @Override
    public TreeNode getRoot() {
        return root;
    }

    @Override
    public int maxPathSum() {
        execute(root);
        return answer;
    }

    private int execute(TreeNode node) {
        if (node == null) return 0;

        int maxLeftPath = Math.max(execute(node.left), 0);
        int maxRightPath = Math.max(execute(node.right), 0);

        this.answer = Math.max(this.answer, maxRightPath + maxLeftPath + node.val());
        return Math.max(maxLeftPath, maxRightPath) + node.val();
    }
}
