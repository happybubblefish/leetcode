package _301_400;

public class _333_largestBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		Given a binary tree, find the largest subtree which is a Binary Search Tree (BST), where largest means subtree with largest number of nodes in it.
	
		Note:
		A subtree must include all of its descendants.
		Here's an example:
		    10
		    / \
		   5  15
		  / \   \ 
		 1   8   7
		The Largest BST Subtree in this case is the highlighted one. 
		The return value is the subtree's size, which is 3.
		Follow up:
		Can you figure out ways to solve it with O(n) time complexity?
	*/
	
	class Result {
		int size;
		int min;
		int max;
		
		public Result(int size, int min, int max) {
			this.size = size;
			this.min = min;
			this.max = max;
		}
	}
	
	public int largestBSTSubtree(TreeNode root) {
		Result result = helper(root);
		return result.size;
	}

	private Result helper(TreeNode root) {
		if(root == null) {
			return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		
		Result left = helper(root.left);
		Result right = helper(root.right);
		
		if(left.size < 0 || right.size < 0 || root.val <= left.max || root.val >= right.min) {
			return new Result(Math.max(Math.abs(left.size), Math.abs(right.size)), 0, 0);
		} else {
			return new Result(left.size + right.size + 1, Math.min(root.val, left.min), Math.max(root.val, right.max));
		}
	}
}

/*
//in brute-force solution, we get information in a top-down manner.
//for O(n) solution, we do it in bottom-up manner, meaning we collect information during backtracking. 

public class Solution {

class Result {  // (size, rangeLower, rangeUpper) -- size of current tree, range of current tree [rangeLower, rangeUpper]
    int size;
    int lower;
    int upper;
    
    Result(int size, int lower, int upper) {
        this.size = size;
        this.lower = lower;
        this.upper = upper;
    }
}

int max = 0;

public int largestBSTSubtree(TreeNode root) {
    if (root == null) { return 0; }    
    traverse(root, null);
    return max;
}

private Result traverse(TreeNode root, TreeNode parent) {
    if (root == null) { return new Result(0, parent.val, parent.val); }
    Result left = traverse(root.left, root);
    Result right = traverse(root.right, root);
    if (left.size==-1 || right.size==-1 || root.val<left.upper || root.val>right.lower) {
        return new Result(-1, 0, 0);
    }
    int size = left.size + 1 + right.size;
    max = Math.max(size, max);
    return new Result(size, left.lower, right.upper);
}
}
*/

/*
Since this is not an overall boolean check, and each subtree can decide if itself is a BST, and update a global size variable, I have chosen to decide BST at each subtree, and pass a 3-element array up. If subtree is not BST, size will be -1, and parent tree will not be BST

time complexity is O(n), since each node is visited exactly once

private int largestBSTSubtreeSize = 0;
public int largestBSTSubtree(TreeNode root) {
    helper(root);
    return largestBSTSubtreeSize;
}

private int[] helper(TreeNode root) {
    // return 3-element array:
    // # of nodes in the subtree, leftmost value, rightmost value
    // # of nodes in the subtree will be -1 if it is not a BST
    int[] result = new int[3];
    if (root == null) {
        return result;
    }
    int[] leftResult = helper(root.left);
    int[] rightResult = helper(root.right);
    if ((leftResult[0] == 0 || leftResult[0] > 0 && leftResult[2] <= root.val) &&
        (rightResult[0] == 0 || rightResult[0] > 0 && rightResult[1] >= root.val)) {
       int size = 1 + leftResult[0] + rightResult[0];
       largestBSTSubtreeSize = Math.max(largestBSTSubtreeSize, size);
       int leftBoundary = leftResult[0] == 0 ? root.val : leftResult[1];
       int rightBoundary = rightResult[0] == 0 ? root.val : rightResult[2];
       result[0] = size;
       result[1] = leftBoundary;
       result[2] = rightBoundary;
    } else {
    	result[0] = -1;
    }
    return result;
}
*/