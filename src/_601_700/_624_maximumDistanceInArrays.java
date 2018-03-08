package _601_700;

import java.util.List;

public class _624_maximumDistanceInArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.

	Example 1:
		Input: 
		[[1,2,3],
		 [4,5],
		 [1,2,3]]
		Output: 4
		Explanation: 
		One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
	
	Note:
		Each given array will have at least 1 number. There will be at least two non-empty arrays.
		The total number of the integers in all the m arrays will be in the range of [2, 10000].
		The integers in the m arrays will be in the range of [-10000, 10000].
	*/
	
	public int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int min = arrays.get(0).get(0);
        
        for (int i = 1; i < arrays.size(); i++) {
            result = Math.max(result, Math.abs(arrays.get(i).get(0) - max));
            result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));
            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));
            min = Math.min(min, arrays.get(i).get(0));
        }
        
        return result;
    }
}

/*
public int maxDistance(List<List<Integer>> arrays) {
    int min1 = Integer.MAX_VALUE;
    int min2 = Integer.MAX_VALUE;
    int max1 = Integer.MIN_VALUE;
    int max2 = Integer.MIN_VALUE;
    int idxMin1 = 0;
    int idxMin2 = 0;
    int idxMax1 = 0;
    int idxMax2 = 0;
    
    for (int i = 0; i < arrays.size(); i++) {
        List<Integer> list = arrays.get(i);
        int min = list.get(0);
        int max = list.get(list.size() - 1);
        if (min < min1) {
            min2 = min1;
            idxMin2 = idxMin1;
            min1 = min;
            idxMin1 = i;
        } else if (min < min2) {
            min2 = min;
            idxMin2 = i;
        }
        
        if (max > max1) {
            max2 = max1;
            idxMax2 = idxMax1;
            max1 = max;
            idxMax1 = i;
        } else if (max > max2) {
            max2 = max;
            idxMax2 = i;
        }
    }
    
    if (idxMin1 != idxMax1) return max1 - min1;
    else return Math.max(max1 - min2, max2 - min1);
}
*/