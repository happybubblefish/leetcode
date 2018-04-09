package _101_200;

import _001_100.TreeNode;

public class _114_flattenBT2LinkedList {
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

        flatten(root);

        System.out.println(root.val);
    }

    static TreeNode pre = null;
    public static void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        flatten(root.right);
        flatten(root.left);

        root.right = pre;
        root.left = null;
        pre = root;

    }
}
