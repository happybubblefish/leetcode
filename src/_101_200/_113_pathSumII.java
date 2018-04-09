package _101_200;

import _001_100.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _113_pathSumII {
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

        List<List<Integer>> res = pathSum(root, 22);

        for(List<Integer> list : res) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();

        if(root == null) {
            return res;
        }

        helper(root, res, new ArrayList<Integer>(), sum);

        return res;
    }

    private static void helper(TreeNode root, List<List<Integer>> res, List<Integer> temp, int sum) {
        if(root == null) {
            return;
        }

        temp.add(root.val);

        if(root.left == null && root.right == null && sum == root.val) {
            res.add(new ArrayList<>(temp));
        }

        sum -= root.val;

        helper(root.left, res, temp, sum);
        helper(root.right, res, temp, sum);
        temp.remove(temp.size() - 1);
    }
}
