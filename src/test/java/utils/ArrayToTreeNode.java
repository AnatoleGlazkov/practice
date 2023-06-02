package utils;

import utils.node.item.TreeNode;

/** The type ArrayToTreeNode */
public class ArrayToTreeNode {

    public static TreeNode createTree(Integer[] nums) {
        return createTreeHelper(nums, 0);
    }

    private static TreeNode createTreeHelper(
        Integer[] nums,
        int index
    ) {
        if (index >= nums.length || nums[index] == null) {
            return null;
        }

        return new TreeNode(
            nums[index],
            createTreeHelper(nums, 2 * index + 1),
            createTreeHelper(nums, 2 * index + 2)
        );
    }
}
