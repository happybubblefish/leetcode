package _101_200;

import _001_100.TreeNode;

public class _129_sumRootToLeafNumbers {

	public static void main(String[] args) {
		TreeNode tn1 = new TreeNode(1);
		TreeNode tn2 = new TreeNode(2);
		TreeNode tn3 = new TreeNode(3);
		TreeNode tn4 = new TreeNode(4);
		TreeNode tn5 = new TreeNode(5);

		tn1.left = tn2;
		tn1.right = tn3;
		tn2.left = tn4;
		tn2.right = tn5;

		System.out.println(sumNumbers(tn1));
	}

	private static int result = 0;
	public static int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return helper("", root);
	}

	private static int helper(String temp, TreeNode node) {
		if(node == null) {
			return 0;
		}
		
		temp += node.val;

		if (node.left == null && node.right == null) {
			result += Integer.parseInt(temp);
		}

		helper(temp, node.left);
		helper(temp, node.right);

		return result;
	}
}

