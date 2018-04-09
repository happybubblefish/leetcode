package _101_200;

import _001_100.TreeNode;

public class _111_minimumDepthOfBT {
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

        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        //corner case for single linked tree
        if(left == 0) {
            return right + 1;
        }

        if(right == 0) {
            return left + 1;
        }

        return 1 + Math.min(left, right);
    }
}
