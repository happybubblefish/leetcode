package _001_100;

import java.util.ArrayList;
import java.util.List;

public class _094_binaryTreeInorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn3 = new TreeNode(3);

        root.right = tn2;
        tn2.left = tn3;

        List<Integer> res = inorderTraversal(root);

        for(Integer i : res) {
            System.out.println(i);
        }
    }

    static List<Integer> res = new ArrayList<>();
    public static List<Integer> inorderTraversal(TreeNode root) {

        if(root == null) {
            return res;
        }

        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);

        return res;
    }
}
