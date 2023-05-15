

package utils.node.item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import utils.node.Node;

/** The type TreeNode */
@Getter
@RequiredArgsConstructor
public class DoublyNode implements Node {

    private final int val;
    private final DoublyNode left;
    private final DoublyNode right;

}
