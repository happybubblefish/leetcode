package _101_200;

import _001_100.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _107_BTLevelOrderTraversalII {
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

        List<List<Integer>> res = levelOrderBottom(root);

        for(List<Integer> list : res) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrderBottom(_001_100.TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) {
            return res;
        }

        helper(res, root, 1);

        return res;
    }

    private static void helper(List<List<Integer>> res, TreeNode root, int deep) {
        if(root == null) {
            return;
        }

        if(res.size() < deep) {
            List<Integer> list = new ArrayList<>();
            res.add(0, list);
        }

        List<Integer> temp = res.get(res.size() - deep);
        temp.add(root.val);

        helper(res, root.left, deep + 1);
        helper(res, root.right, deep + 1);
    }
}
