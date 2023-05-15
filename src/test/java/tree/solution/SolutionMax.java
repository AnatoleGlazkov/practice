

package tree.solution;

import lombok.Getter;
import tree.Solution;
import utils.node.item.DoublyNode;

/** The type SolutionMax */
public class SolutionMax implements Solution {

    private int answer = 0;

    @Getter
    private final DoublyNode root;

    public SolutionMax() {
        root = new DoublyNode(
            -10,
            new DoublyNode(9, null, null),
            new DoublyNode(20,
                new DoublyNode(-3,
                    new DoublyNode(5,
                        new DoublyNode(-2, null, null), null),
                    new DoublyNode(-4, null, null)),
                new DoublyNode(8,
                    null,
                    new DoublyNode(-2, null, null)))
        );
    }

    @Override
    public int maxPathSum() {
        execute(root);
        return answer;
    }

    private int execute(DoublyNode node) {
        if (node == null) return 0;

        int maxLeftPath = Math.max(execute(node.getLeft()), 0);
        int maxRightPath = Math.max(execute(node.getRight()), 0);

        this.answer = Math.max(this.answer, maxRightPath + maxLeftPath + node.getVal());
        return Math.max(maxLeftPath, maxRightPath) + node.getVal();
    }
}
