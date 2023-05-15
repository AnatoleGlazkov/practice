

package tree.solution;

import lombok.Getter;
import tree.Solution;
import utils.node.item.DoublyNode;

/** The type SolutionMaxPath */
@Getter
public class SolutionMaxPath implements Solution {

    private final DoublyNode root;

    public SolutionMaxPath() {
        this.root = new DoublyNode(1,
            new DoublyNode(4,
                new DoublyNode(2, null, null),
                new DoublyNode(3,
                    new DoublyNode(2, null, null),
                    null)),
            new DoublyNode(7,
                new DoublyNode(5, null, null),
                new DoublyNode(4, null, null))
        );
    }

    @Override
    public int maxPathSum() {
        return execute(this.root);
    }

    private int execute(DoublyNode root) {
        if (root == null) return 0;

        int leftPath = execute(root.getLeft());
        int rightPath = execute(root.getRight());

        return Math.max(leftPath, rightPath) + root.getVal();
    }
}
