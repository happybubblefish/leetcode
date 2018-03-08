package _601_700;

import java.util.HashMap;
import java.util.Map;

public class _666_pathSumIV {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.
	
		For each integer in this list:
		The hundreds digit represents the depth D of this node, 1 <= D <= 4.
		The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
		The units digit represents the value V of this node, 0 <= V <= 9.
		Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.
	
		Example 1:
		Input: [113, 215, 221]
		Output: 12
		Explanation: 
		The tree that the list represents is:
		    3
		   / \
		  5   1
	
		The path sum is (3 + 5) + (3 + 1) = 12.
		Example 2:
		Input: [113, 221]
		Output: 4
		Explanation: 
		The tree that the list represents is: 
		    3
		     \
		      1
	
		The path sum is (3 + 1) = 4.
	*/
	
	/*
		How do we solve problem like this if we were given a normal tree? Yes, traverse it, keep a root to leaf running sum. If we see a leaf node (node.left == null && node.right == null), we add the running sum to the final result.

		Now each tree node is represented by a number. 1st digits is the level, 2nd is the position in that level (note that it starts from 1 instead of 0). 3rd digit is the value. We need to find a way to traverse this tree and get the sum.

		The idea is, we can form a tree using a HashMap. The key is first two digits which marks the position of a node in the tree. The value is value of that node. Thus, we can easily find a node's left and right children using math.
		Formula: For node xy? its left child is (x+1)(y*2-1)? and right child is (x+1)(y*2)?

		Given above HashMap and formula, we can traverse the tree. Problem is solved!
	*/
	
	int sum = 0;
    Map<Integer, Integer> tree = new HashMap<>();
    
    public int pathSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        for (int num : nums) {
            int key = num / 10;
            int value = num % 10;
            tree.put(key, value);
        }
        
        traverse(nums[0] / 10, 0);
        
        return sum;
    }
    
    private void traverse(int root, int preSum) {
        int level = root / 10;
        int pos = root % 10;
        int left = (level + 1) * 10 + pos * 2 - 1;
        int right = (level + 1) * 10 + pos * 2;
        
        int curSum = preSum + tree.get(root);
        
        if (!tree.containsKey(left) && !tree.containsKey(right)) {
            sum += curSum;
            return;
        }
        
        if (tree.containsKey(left)) traverse(left, curSum);
        if (tree.containsKey(right)) traverse(right, curSum);
    }
}

/*
public int pathSum(int[] nums) {
    int[] val = new int[16];
    int level = 1, base = 1;
    for (int num : nums) {
        int D = num / 100;
        int P = num / 10 % 10;
        int V = num % 10;
        if (D > level + 1)
            break;
        
        if (D == level + 1)
            base *= 2;
        int pos = base + P - 1;
        val[pos] = val[pos / 2] + V;
        
        level = D;
    }
    int sum = 0;
    for (int i = base; i < 16; i++)
        sum += val[i];
    for (int i = 1; i < base; i++)
        if (val[i * 2] == 0 && val[i * 2 + 1] == 0)
            sum += val[i];
    return sum;
}
*/