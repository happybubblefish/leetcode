package _001_100;

public class _100_sameTree {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);

        root1.left = tn2;
        root1.right = tn3;

        TreeNode root2 = new TreeNode(1);
        TreeNode tn4 = new TreeNode(2);
        TreeNode tn5 = new TreeNode(3);

        root2.left = tn4;
        root2.right = tn5;

        System.out.println(isSameTree(root1, root2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null) {
            return q == null;
        }

        if(q == null) {
            return p == null;
        }

        if(p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
