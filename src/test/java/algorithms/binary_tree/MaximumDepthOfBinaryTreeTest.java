package algorithms.binary_tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.node.item.TreeNode;

import java.util.stream.Stream;

/**
 * The type MaximumDepthOfBinaryTreeTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree">...</a>}
 */
public class MaximumDepthOfBinaryTreeTest {

    public static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(
                Named.of("3,9,20,null,null,15,7", new TreeNode(3,
                    new TreeNode(9, null, null),
                    new TreeNode(20,
                        new TreeNode(15, null, null),
                        new TreeNode(7, null, null)))),
                3
            )
        );
    }

    @ParameterizedTest
    @DisplayName("104. Maximum Depth of Binary Tree")
    @MethodSource("source")
    void maxDepth(
        TreeNode root,
        int expected
    ) {
        Assertions.assertEquals(expected, deepCounter(root, 0));
    }

    private int deepCounter(
        TreeNode root,
        int i
    ) {
        return root == null
               ? i
               : Math.max(deepCounter(root.left, i), deepCounter(root.right, i)) + 1;
    }
}
