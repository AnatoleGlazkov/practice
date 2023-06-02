package algorithms.binary_tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.BTreePrinter;
import utils.node.item.TreeNode;

import java.util.stream.Stream;

import static utils.ArrayToTreeNode.createTree;

/**
 * The type CountGoodNodesInBinaryTreeTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/count-good-nodes-in-binary-tree">...</a>}
 *
 * TODO 10.06
 */
public class CountGoodNodesInBinaryTreeTest {

    private static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(
                Named.of("[3,1,4,3,null,1,5]", createTree(new Integer[]{3, 1, 4, 3, null, 1, 5})),
                4),
            Arguments.of(
                Named.of("[3,3,null,4,2]", createTree(new Integer[]{3, 3, null, 4, 2})),
                3),
            Arguments.of(
                Named.of("[1]", createTree(new Integer[]{1})),
                1),
            Arguments.of(
                Named.of("[2,null,4,10,8,null,null,4]", new TreeNode(2,
                    null,
                    new TreeNode(4,
                        new TreeNode(10),
                        new TreeNode(8, null, new TreeNode(4))))),
                4)
        );
    }

    @ParameterizedTest
    @DisplayName("1448. Count Good Nodes in Binary Tree")
    @MethodSource("source")
    void goodNodes(
        TreeNode root,
        int expected
    ) {
        BTreePrinter.printNode(root);

        int execute = dfs(root, Integer.MIN_VALUE);
        Assertions.assertEquals(expected, execute);
    }

    public int dfs(
        TreeNode root,
        int good
    ) {
        if (root == null) return 0;

        int res = root.val >= good ? 1 : 0;

        //call recursion for left and right subtree
        res += dfs(root.left, Math.max(root.val, good));
        res += dfs(root.right, Math.max(root.val, good));

        return res;
    }
}
