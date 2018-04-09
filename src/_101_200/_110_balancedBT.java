package _101_200;

import _001_100.TreeNode;

public class _110_balancedBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(2);
        TreeNode tn4 = new TreeNode(3);
        TreeNode tn5 = new TreeNode(3);
        TreeNode tn6 = new TreeNode(4);
        TreeNode tn7 = new TreeNode(4);

        root.left = tn2;
        root.right = tn3;
        tn2.left = tn4;
        tn2.right = tn5;
        tn4.left = tn6;
        tn4.right = tn7;

        System.out.println(isBalanced(root));
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        int leftDepth = helper(root.left);
        int rightDepth = helper(root.right);

        boolean temp = Math.abs(leftDepth - rightDepth) <= 1 ? true : false;

        return temp && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(helper(root.left), helper(root.right));
    }
}
