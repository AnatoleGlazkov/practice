package ru.algorithms.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * The type SymmetricTreeTest
 * {@link <a href="https://leetcode.com/problems/symmetric-tree/">...</a>}
 */
public class SymmetricTreeTest {

    private static Stream<Arguments> provideData() {
        return Stream.of(
            Arguments.of(
                Named.of("[1,2,2,3,4,4,3]",
                    new TreeNode(1,
                        new TreeNode(2, new TreeNode(3), new TreeNode(4)),
                        new TreeNode(2, new TreeNode(4), new TreeNode(3)))),
                true
            ),
            Arguments.of(
                Named.of("[1,2,2,null,3,null,3]",
                    new TreeNode(1,
                        new TreeNode(2, null, new TreeNode(3)),
                        new TreeNode(2, null, new TreeNode(3)))),
                false
            ),
            Arguments.of(
                Named.of("[2,3,3,4,5,5]",
                    new TreeNode(2,
                        new TreeNode(3, new TreeNode(4), new TreeNode(5)),
                        new TreeNode(3, new TreeNode(5), null))),
                false
            )
        );
    }

    @ParameterizedTest
    @DisplayName("101. Symmetric Tree")
    @MethodSource("provideData")
    void isSymmetric(
        TreeNode root,
        boolean expected
    ) {
        Assertions.assertEquals(expected, execute(root.left, root.right));
    }

    private boolean execute(
        TreeNode leftNode,
        TreeNode rightNode
    ) {
        if (leftNode == null && rightNode != null) return false;
        if (leftNode != null && rightNode == null) return false;
        if (leftNode == null) return true;

        if (leftNode.val == rightNode.val) {
            return execute(leftNode.right, rightNode.left) && execute(rightNode.right, leftNode.left);
        }

        return false;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(
            int val,
            TreeNode left,
            TreeNode right
        ) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
