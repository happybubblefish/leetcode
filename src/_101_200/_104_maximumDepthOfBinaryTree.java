package _101_200;

import _001_100.TreeNode;

public class _104_maximumDepthOfBinaryTree {
    public static void main(String[] args) {
        _001_100.TreeNode root = new _001_100.TreeNode(1);
        _001_100.TreeNode tn2 = new _001_100.TreeNode(2);
        _001_100.TreeNode tn3 = new _001_100.TreeNode(3);
        _001_100.TreeNode tn4 = new _001_100.TreeNode(4);
        _001_100.TreeNode tn5 = new _001_100.TreeNode(5);

        root.left = tn2;
        root.right = tn3;
        tn3.left = tn4;
        tn3.right = tn5;

        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
