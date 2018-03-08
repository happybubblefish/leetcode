package _201_300;

public class _250_countUniValueSubtrees {

	public static void main(String[] args) {
		TreeNode tn1 = new TreeNode(5);
		TreeNode tn2 = new TreeNode(1);
		TreeNode tn3 = new TreeNode(5);
		TreeNode tn4 = new TreeNode(5);
		TreeNode tn5 = new TreeNode(5);
		TreeNode tn6 = new TreeNode(5);
		
		tn1.left = tn2;
		tn1.right = tn3;
		tn2.left = tn4;
		tn2.right = tn5;
		tn3.right = tn6;
		
		System.out.println(countUnivalSubtrees(tn1));
	}
	
	/*
		Given a binary tree, count the number of uni-value subtrees.
	
		A Uni-value subtree means all nodes of the subtree have the same value.
	
		For example:
		Given binary tree,
		              5
		             / \
		            1   5
		           / \   \
		          5   5   5
		return 4.
	*/

	private static int count = 0;
	
	public static int countUnivalSubtrees(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		helper(root);
	
		return count;
	}

	private static boolean helper(TreeNode node) {
		if(node == null) {
			return true;
		}
		
		boolean l = helper(node.left);
		boolean r = helper(node.right);
		
//		if(node.left == null && node.right == null) {
//			count++;
//			return true;
//		}
//		
//		if(!l && !r) {
//			return false;
//		} 
//		
//		if(!l) {
//			if(r && node.val == node.right.val) {
//				count++;
//			}
//			
//			return false;
//		}
//		
//		if(!r) {
//			if(l && node.val == node.left.val) {
//				count++;
//			}
//			
//			return false;
//		}
		
		if(l && r) {
			if(node.left != null && node.val != node.left.val) {
				return false;
			}
			
			if(node.right != null && node.val != node.right.val) {
				return false;
			}
			
			count++;
			return true;
		}
		
		return false;
	}
}

class TreeNode{
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
}
