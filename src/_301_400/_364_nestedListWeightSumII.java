package _301_400;

import java.util.List;

public class _364_nestedListWeightSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * // This is the interface that allows for creating nested lists.
	 * // You should not implement it, or speculate about its implementation
	 * public interface NestedInteger {
	 *     // Constructor initializes an empty nested list.
	 *     public NestedInteger();
	 *
	 *     // Constructor initializes a single integer.
	 *     public NestedInteger(int value);
	 *
	 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
	 *     public boolean isInteger();
	 *
	 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
	 *     // Return null if this NestedInteger holds a nested list
	 *     public Integer getInteger();
	 *
	 *     // Set this NestedInteger to hold a single integer.
	 *     public void setInteger(int value);
	 *
	 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
	 *     public void add(NestedInteger ni);
	 *
	 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
	 *     // Return null if this NestedInteger holds a single integer
	 *     public List<NestedInteger> getList();
	 * }
	 */
	
	/*
		Instead of multiplying by depth, add integers multiple times (by going level by level and adding the unweighted sum to the weighted sum after each level).
	*/
	
	public int depthSumInverse(List<_364_nestedListWeightSumII> nestedList) {
		int unweighted = 0, weighted = 0;
//	    while (!nestedList.isEmpty()) {
//	        List<NestedInteger> nextLevel = new ArrayList<>();
//	        for (NestedInteger ni : nestedList) {
//	            if (ni.isInteger())
//	                unweighted += ni.getInteger();
//	            else
//	                nextLevel.addAll(ni.getList());
//	        }
//	        weighted += unweighted;
//	        nestedList = nextLevel;
//	    }
	    return weighted;
    }
}

/*
	public int depthSumInverse(List<NestedInteger> nestedList) {
	    if (nestedList == null) return 0;
	    Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
	    int prev = 0;
	    int total = 0;
	    for (NestedInteger next: nestedList) {
	        queue.offer(next);
	    }
	    
	    while (!queue.isEmpty()) {
	        int size = queue.size();
	        int levelSum = 0;
	        for (int i = 0; i < size; i++) {
	            NestedInteger current = queue.poll();
	            if (current.isInteger()) levelSum += current.getInteger();
	            List<NestedInteger> nextList = current.getList();
	            if (nextList != null) {
	                for (NestedInteger next: nextList) {
	                    queue.offer(next);
	                }
	            }
	        }
	        prev += levelSum;
	        total += prev;
	    }
	    return total;
	}
*/
