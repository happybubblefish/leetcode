package _101_200;

import _001_100.TreeNode;

public class _101_symmetricTree {
    public static void main(String[] args) {
        _001_100.TreeNode root1 = new _001_100.TreeNode(1);
        _001_100.TreeNode tn2 = new _001_100.TreeNode(2);
        _001_100.TreeNode tn3 = new _001_100.TreeNode(2);
        _001_100.TreeNode tn4 = new _001_100.TreeNode(3);
        _001_100.TreeNode tn5 = new _001_100.TreeNode(3);

        root1.left = tn2;
        root1.right = tn3;
        tn2.left = tn4;
        tn3.right = tn5;

        _001_100.TreeNode root2 = new _001_100.TreeNode(1);
        _001_100.TreeNode tn6 = new _001_100.TreeNode(2);
        _001_100.TreeNode tn7 = new _001_100.TreeNode(2);
        _001_100.TreeNode tn8 = new _001_100.TreeNode(3);
        _001_100.TreeNode tn9 = new _001_100.TreeNode(3);

        root2.left = tn6;
        root2.right = tn7;
        tn6.left = tn8;
        tn7.right = tn9;

        System.out.println(isSymmetric(root2));
    }

    public static boolean isSymmetric(_001_100.TreeNode root) {
        if(root == null) {
            return true;
        }

        return helper(root.left, root.right);
    }

    private static boolean helper(_001_100.TreeNode left, TreeNode right) {
        if(left == null) {
            return right == null;
        }

        if(right == null) {
            return left == null;
        }

        if(left.val != right.val) {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
