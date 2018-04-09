package _101_200;

import _001_100.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _102_BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        _001_100.TreeNode root = new _001_100.TreeNode(3);
        _001_100.TreeNode tn2 = new _001_100.TreeNode(9);
        _001_100.TreeNode tn3 = new _001_100.TreeNode(20);
        _001_100.TreeNode tn4 = new _001_100.TreeNode(15);
        _001_100.TreeNode tn5 = new _001_100.TreeNode(7);

        root.left = tn2;
        root.right = tn3;
        tn3.left = tn4;
        tn3.right = tn5;

        List<List<Integer>> res = levelOrder(root);

        for(List<Integer> list : res) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrder(_001_100.TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) {
            return res;
        }

        helper(root, res, 1);

        return res;
    }

    private static void helper(TreeNode root, List<List<Integer>> res, int deep) {
        if(root == null) {
            return;
        }

        if(res.size() < deep) {
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }

        List<Integer> temp = res.get(deep - 1);
        temp.add(root.val);

        helper(root.left, res, deep + 1);
        helper(root.right, res, deep + 1);
    }
}
