package _101_200;

import _001_100.TreeNode;

public class _108_convertSortedArrayToBST {
    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9 };

        _001_100.TreeNode root = sortedArrayToBST(nums);

        System.out.println(root.val);
    }

    public static _001_100.TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }

        return helper(nums, 0, nums.length - 1);
    }

    private static _001_100.TreeNode helper(int[] nums, int start, int end) {
        if(start > end) {
            return null;
        }

        int rootIndex = (start + end) / 2;
        _001_100.TreeNode root = new TreeNode(nums[rootIndex]);

        root.left = helper(nums, start, rootIndex - 1);
        root.right = helper(nums, rootIndex + 1, end);

        return root;
    }
}
