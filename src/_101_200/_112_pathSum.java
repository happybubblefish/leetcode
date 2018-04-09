package _101_200;

import _001_100.TreeNode;

public class _112_pathSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode tn2 = new TreeNode(4);
        TreeNode tn3 = new TreeNode(8);
        TreeNode tn4 = new TreeNode(11);
        TreeNode tn5 = new TreeNode(13);
        TreeNode tn6 = new TreeNode(4);
        TreeNode tn7 = new TreeNode(7);
        TreeNode tn8 = new TreeNode(2);
        TreeNode tn9 = new TreeNode(1);

        root.left = tn2;
        root.right = tn3;
        tn2.left = tn4;
        tn3.left = tn5;
        tn3.right = tn6;
        tn4.left = tn7;
        tn4.right = tn8;
        tn6.right = tn9;

        System.out.println(hasPathSum(root, 22));
    }

    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }

        if(root.left == null && root.right == null) {
            return sum == root.val;
        }

        sum -= root.val;
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
