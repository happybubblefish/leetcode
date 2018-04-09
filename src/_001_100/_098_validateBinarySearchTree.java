package _001_100;

public class _098_validateBinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode tn2 = new TreeNode(5);
        TreeNode tn3 = new TreeNode(15);
        TreeNode tn4 = new TreeNode(6);
        TreeNode tn5 = new TreeNode(20);

        root.left = tn2;
        root.right = tn3;
        tn3.left = tn4;
        tn3.right = tn5;

        System.out.println(isValidBST(root));
    }

    public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    //root can be passed down as either min or max
    private static boolean helper(TreeNode root, TreeNode min, TreeNode max) {
        if(root == null) {
            return true;
        }

        if(min != null && root.val <= min.val || max != null && root.val >= max.val) {
            return false;
        }

        return helper(root.left, min, root) && helper(root.right, root, max);
    }
}
