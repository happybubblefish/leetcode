package _201_300;

public class _255_verifyPreorderSequenceInBST {

	public static void main(String[] args) {
		int[] preorder = { 5, 3, 2, 0, 4, 8, 7, 6, 9 };
		
		System.out.println(verifyPreorder(preorder));
	}

	/*
		Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
	
		You may assume each number in the sequence is unique.
	
		Follow up:
		Could you do it using only constant space complexity?
	*/
	
	public static boolean verifyPreorder(int[] preorder) {
		if (preorder == null || preorder.length <= 1) {
			return true;
		}

		int len = preorder.length;

		return helper(preorder, 0, len - 1);
	}

	private static boolean helper(int[] preorder, int start, int end) {
		if (start == end) {
			return true;
		} else if (start < end) {
			int root = preorder[start];
			int rightStart = -1;

			for (int i = start; i <= end; i++) {
				if (preorder[i] > root) {
					rightStart = i;
					break;
				}
			}

			if(rightStart == -1) {
				return helper(preorder, start + 1, end);
			} else {
				for (int i = rightStart; i <= end; i++) {
					if (preorder[i] < root) {
						return false;
					}
				}

				return helper(preorder, start + 1, rightStart - 1) && helper(preorder, rightStart, end);
			}
		}

		return true;
	}
	
	/* Solution ... 1
	 * Kinda simulate the traversal, keeping a stack of nodes (just their values) of which we're still in the left subtree. 
	 * If the next number is smaller than the last stack value, then we're still in the left subtree of all stack nodes, so just push the new one onto the stack. 
	 * But before that, pop all smaller ancestor values, as we must now be in their right subtrees (or even further, in the right subtree of an ancestor). 
	 * Also, use the popped values as a lower bound, since being in their right subtree means we must never come across a smaller number anymore.
	*/
	/*
		public boolean verifyPreorder(int[] preorder) {
		    int low = Integer.MIN_VALUE;
		    Stack<Integer> path = new Stack();
		    for (int p : preorder) {
		        if (p < low)
		            return false;
		        while (!path.empty() && p > path.peek())
		            low = path.pop();
		        path.push(p);
		    }
		    return true;
		}
	
	*/
	
	/* Solution 2 ... O(1) extra space
	public boolean verifyPreorder(int[] preorder) {
	    int low = Integer.MIN_VALUE, i = -1;
	    for (int p : preorder) {
	        if (p < low)
	            return false;
	        while (i >= 0 && p > preorder[i])
	            low = preorder[i--];
	        preorder[++i] = p;
	    }
	    return true;
	}
	
	*/
}
