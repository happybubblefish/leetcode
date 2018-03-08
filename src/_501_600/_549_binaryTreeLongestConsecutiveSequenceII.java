package _501_600;

public class _549_binaryTreeLongestConsecutiveSequenceII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.
	
		Especially, this path can be either increasing or decreasing. For example, [1,2,3,4] and [4,3,2,1] are both considered valid, but the path [1,2,4,3] is not valid. On the other hand, the path can be in the child-Parent-child order, where not necessarily be parent-child order.
	
		Example 1:
		Input:
		        1
		       / \
		      2   3
		Output: 2
		Explanation: The longest consecutive path is [1, 2] or [2, 1].
		Example 2:
		Input:
		        2
		       / \
		      1   3
		Output: 3
		Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].
		Note: All the values of tree nodes are in the range of [-1e7, 1e7].
	*/
	
	int max = 0;
    public int longestConsecutive(TreeNode root) {
        helper(root);
        return max;
    }
    
    private int[] helper(TreeNode root) {
        if (root == null) return new int[]{0,0};
        int inc = 1;
        int dec = 1;
        if (root.left != null) {
            int[] d = helper(root.left);
            if (root.left.val + 1 == root.val) {
                inc = d[0] + 1;
            }
            if (root.left.val -1 == root.val) {
                dec = d[1] + 1;
            }
        }
        if (root.right != null) {
            int[] d = helper(root.right);
            if (root.right.val + 1 == root.val) {
                inc = Math.max(d[0] + 1, inc);
            }
            if (root.right.val -1 == root.val) {
                dec = Math.max(d[1] + 1, dec);
            }
        }
        max = Math.max(max, inc+ dec -1);
        return new int[] {inc, dec};
    }
}
