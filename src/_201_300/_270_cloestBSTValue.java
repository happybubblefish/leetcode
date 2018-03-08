package _201_300;

public class _270_cloestBSTValue {

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
//		tn1.right = tn3;
//		tn2.left = tn4;
//		tn2.right = tn5;
//		tn3.left = tn6;
//		tn3.right = tn7;
//		tn4.left = tn8;
		
		System.out.println(closestValue(tn1, 10));
	}

	/*	Google, Microsoft, Snapchat
		Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.
	
		Note:
		Given target value is a floating point.
		You are guaranteed to have only one unique value in the BST that is closest to the target.
	*/
	
	public static int closestValue(TreeNode root, double target) {
		int ret = root.val;   
	    while(root != null){
	        if(Math.abs(target - root.val) < Math.abs(target - ret)){
	            ret = root.val;
	        }      
	        root = root.val > target? root.left: root.right;
	    }     
	    return ret;
	}
}

/*
	public int closestValue(TreeNode root, double target) {
	    int a = root.val;
	    if (a == target) return a;
	    TreeNode kid = a < target ? root.right : root.left;
	    if (kid == null) return a;
	    int b = closestValue(kid, target);
	    return Math.abs(a - target) < Math.abs(b - target) ? a : b;
	}
*/
