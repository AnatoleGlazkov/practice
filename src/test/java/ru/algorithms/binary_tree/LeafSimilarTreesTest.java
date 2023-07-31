package ru.algorithms.binary_tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Named;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ru.utils.BTreePrinter;
import ru.utils.node.item.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static ru.utils.ArrayToTreeNode.createTree;

/**
 * The type LeafSimilarTreesTest
 * <p>
 * {@link <a href="https://leetcode.com/problems/leaf-similar-trees">...</a>}
 */
public class LeafSimilarTreesTest {


    public static Stream<Arguments> source() {
        return Stream.of(
            Arguments.of(
                Named.of("[3, 5, 1, 6, 2, 9, 8, null, null, 7, 4]", createTree(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4})),
                Named.of("[3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8]", createTree(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8})),
                true
            ),
            Arguments.of(
                Named.of("[1,2,3]", createTree(new Integer[]{1, 2, 3})),
                Named.of("[1,3,2]", createTree(new Integer[]{1, 3, 2})),
                false
            ),
            Arguments.of(
                Named.of("[1,2]", createTree(new Integer[]{1, 2})),
                Named.of("[2,2]", createTree(new Integer[]{2, 2})),
                true
            )
        );
    }

    @ParameterizedTest
    @DisplayName("872. Leaf-Similar Trees")
    @MethodSource("source")
    void leafSimilar(
        TreeNode root1,
        TreeNode root2,
        boolean expected
    ) {

        BTreePrinter.printNode(root1);
        BTreePrinter.printNode(root2);

        List<Integer> list = execute(root1, new ArrayList<>());
        List<Integer> list2 = execute(root2, new ArrayList<>());

        Assertions.assertEquals(expected, list.equals(list2));
    }

    private List<Integer> execute(
        TreeNode root,
        List<Integer> result
    ) {
        if (root.left == null && root.right == null) {
            result.add(root.val);
        } else if (root.left != null && root.right == null) {
            execute(root.left, result);
        } else if (root.left == null) {
            execute(root.right, result);
        } else {
            execute(root.left, result);
            execute(root.right, result);
        }

        return result;
    }
}
