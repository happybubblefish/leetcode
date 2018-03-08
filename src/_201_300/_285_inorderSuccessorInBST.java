package _201_300;

public class _285_inorderSuccessorInBST {

	public static void main(String[] args) {
		TreeNode tn1 = new TreeNode(5);
		TreeNode tn2 = new TreeNode(3);
		TreeNode tn3 = new TreeNode(7);
		TreeNode tn4 = new TreeNode(2);
		TreeNode tn5 = new TreeNode(4);
		TreeNode tn6 = new TreeNode(6);
		TreeNode tn7 = new TreeNode(8);
		TreeNode tn8 = new TreeNode(1);
		
		tn1.left = tn2;
		tn1.right = tn3;
		tn2.left = tn4;
		tn2.right = tn5;
		tn3.left = tn6;
		tn3.right = tn7;
		tn4.left = tn8;
		
		TreeNode p = new TreeNode(0);
		
		System.out.println(inorderSuccessor(tn1, p).val);
	}
	
	/* Facebook, Microsoft, Pocket Gems
		Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
	
		Note: If the given node has no in-order successor in the tree, return null.
	*/
	
	/*
		let's take the successor for example, basically we always want to find p's closest node (in inorder traversal) and the node's value is larger than p's value, right? That node can either be p's parent or the smallest node in p' right branch.

		When the code runs into the else block, that means the current root is either p's parent or a node in p's right branch.

		If it's p's parent node, there are two scenarios: 1. p doesn't have right child, in this case, the recursion will eventually return null, so p's parent is the successor; 2. p has right child, then the recursion will return the smallest node in the right sub tree, and that will be the answer.

		If it's p's right child, there are two scenarios: 1. the right child has left sub tree, eventually the smallest node from the left sub tree will be the answer; 2. the right child has no left sub tree, the recursion will return null, then the right child (root) is our answer.
	*/

	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if(root == null) {
			return null;
		}
		
		if(root.val <= p.val) {
			return inorderSuccessor(root.right, p);
		} else {
			TreeNode left = inorderSuccessor(root.left, p);
			return left != null ? left : root;
		}
	}
	
	public static TreeNode inorderPrecessor(TreeNode root, TreeNode p) {
		if(root == null) {
			return null;
		}
		
		if(root.val >= p.val) {
			return inorderPrecessor(root.left, p);
		} else {
			TreeNode right = inorderPrecessor(root.right, p);
			return right != null ? right : root;
		}
	}
}
