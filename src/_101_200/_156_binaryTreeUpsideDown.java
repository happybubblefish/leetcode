package _101_200;

import _001_100.TreeNode;

public class _156_binaryTreeUpsideDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode upsideDownBinaryTree(TreeNode root) {
		if(root == null || root.left == null) {
			return root;
		}
		
		TreeNode newRoot = upsideDownBinaryTree(root.left);
		
		root.left.left = root.right;	
		root.left.right = root;
		root.left = null;
		root.right = null;
		
		return newRoot;
	}
}
