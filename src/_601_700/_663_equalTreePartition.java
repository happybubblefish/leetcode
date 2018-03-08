package _601_700;

import java.util.HashMap;
import java.util.Map;

public class _663_equalTreePartition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
		Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have the equal sum of values after removing exactly one edge on the original tree.
	
		Example 1:
		Input:     
		    5
		   / \
		  10 10
		    /  \
		   2   3
	
		Output: True
		Explanation: 
		    5
		   / 
		  10
		      
		Sum: 15
	
		   10
		  /  \
		 2    3
	
		Sum: 15
		Example 2:
			Input:     
			    1
			   / \
			  2  10
			    /  \
			   2   20
			
			Output: False
			Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.
			
		Note:
			The range of tree node value is in the range of [-100000, 100000].
			1 <= n <= 10000
	*/
	
	/*
		The idea is to use a hash table to record all the different sums of each subtree in the tree. If the total sum of the tree is sum, we just need to check if the hash table constains sum/2.
	
		The following code has the correct result at a special case when the tree is [0,-1,1], which many solutions dismiss. I think this test case should be added.
	*/
	
	public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = getsum(root, map);
        if(sum == 0)return map.getOrDefault(sum, 0) > 1;
        return sum%2 == 0 && map.containsKey(sum/2);
    }
    
    public int getsum(TreeNode root, Map<Integer, Integer> map ){
        if(root == null)return 0;
        int cur = root.val + getsum(root.left, map) + getsum(root.right, map);
        map.put(cur, map.getOrDefault(cur,0) + 1);
        return cur;
    }
}

/*
boolean res = false;
public boolean checkEqualTree(TreeNode root) {
    if(root == null) return false;
    int sum = getSum(root);
    if((sum & 1) == 1) return false;
    dfs(root.right, sum);
    dfs(root.left, sum);
    return res;
}

public int dfs(TreeNode root, int sum){
    if(root == null || res == true) return 0;
    int cur = root.val + dfs(root.left, sum) + dfs(root.right, sum);
    if(cur == sum - cur) {
        res = true;
    }
    return cur;
}

public int getSum(TreeNode root){
    if(root == null) return 0;
    return root.val + getSum(root.left) + getSum(root.right);
}
*/

class TreeNode {
	 public int val;
	 public  TreeNode left;
	 public  TreeNode right;
	  TreeNode(int x) { val = x; }
}
