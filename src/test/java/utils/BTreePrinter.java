

package utils;

import utils.node.Node;
import utils.node.item.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BTreePrinter {

    public static void printNode(Node root) {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(
        List<Node> nodes,
        int level,
        int maxLevel
    ) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<Node> newNodes = new ArrayList<>();
        for (Node node : nodes) {
            if (node != null) {
                System.out.print(node.val());
                newNodes.add(node.left());

                if (node instanceof TreeNode) {
                    newNodes.add(((TreeNode) node).right);
                }

            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println();

        for (int i = 1; i <= endLines; i++) {
            for (Node node : nodes) {
                printWhitespaces(firstSpaces - i);
                if (node == null) {
                    printWhitespaces(endLines + endLines + i + 1);
                    continue;
                }

                if (node.left() != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (node instanceof TreeNode && ((TreeNode) node).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endLines + endLines - i);
            }

            System.out.println();
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(Node node) {
        if (node == null)
            return 0;

        if (node instanceof TreeNode) {
            return Math.max(maxLevel(node.left()), maxLevel(((TreeNode) node).right)) + 1;
        } else {
            return maxLevel(node.left()) + 1;
        }

    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
}