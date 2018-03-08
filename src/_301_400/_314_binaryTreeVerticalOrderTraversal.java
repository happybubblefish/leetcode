package _301_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class _314_binaryTreeVerticalOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/* Google, Facebook, Snapchat
	Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

			If two nodes are in the same row and column, the order should be from left to right.

			Examples:

			Given binary tree [3,9,20,null,null,15,7],
			   3
			  /\
			 /  \
			 9  20
			    /\
			   /  \
			  15   7
			return its vertical order traversal as:
			[
			  [9],
			  [3,15],
			  [20],
			  [7]
			]
			Given binary tree [3,9,8,4,0,1,7],
			     3
			    /\
			   /  \
			   9   8
			  /\  /\
			 /  \/  \
			 4  01   7
			return its vertical order traversal as:
			[
			  [4],
			  [9],
			  [3,0,1],
			  [8],
			  [7]
			]
			Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
			     3
			    /\
			   /  \
			   9   8
			  /\  /\
			 /  \/  \
			 4  01   7
			    /\
			   /  \
			   5   2
			return its vertical order traversal as:
			[
			  [4],
			  [9,5],
			  [3,0,1],
			  [8,2],
			  [7]
			]
	*/
	
	/*
		The following solution takes 5ms.
	
		BFS, put node, col into queue at the same time
		Every left child access col - 1 while right child col + 1
		This maps node into different col buckets
		Get col boundary min and max on the fly
		Retrieve result from cols
		Note that TreeMap version takes 9ms.
	*/
//	time: O(n), space: O(n)
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
	    if (root == null) {
	        return res;
	    }
	    
	    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
	    Queue<TreeNode> q = new LinkedList<>();
	    Queue<Integer> cols = new LinkedList<>();

	    q.add(root); 
	    cols.add(0);

	    int min = 0;
	    int max = 0;
	    
	    while (!q.isEmpty()) {
	        TreeNode node = q.poll();
	        int col = cols.poll();
	        
	        if (!map.containsKey(col)) {
	            map.put(col, new ArrayList<Integer>());
	        }
	        map.get(col).add(node.val);

	        if (node.left != null) {
	            q.add(node.left); 
	            cols.add(col - 1);
	            min = Math.min(min, col - 1);
	        }
	        
	        if (node.right != null) {
	            q.add(node.right);
	            cols.add(col + 1);
	            max = Math.max(max, col + 1);
	        }
	    }

	    for (int i = min; i <= max; i++) {
	        res.add(map.get(i));
	    }

	    return res;
	}
}

class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}
}