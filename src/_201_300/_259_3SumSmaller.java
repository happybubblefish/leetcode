package _201_300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _259_3SumSmaller {

	public static void main(String[] args) {
		int[] nums = { -2, 0, 1, 3 };

		System.out.println(threeSumSmaller(nums, 4));
	}

	/*
	 * Given an array of n integers nums and a target, find the number of index
	 * triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] +
	 * nums[j] + nums[k] < target.
	 * 
	 * For example, given nums = [-2, 0, 1, 3], and target = 2.
	 * 
	 * Return 2. Because there are two triplets which sums are less than 2:
	 * 
	 * [-2, 0, 1] [-2, 0, 3] Follow up: Could you solve it in O(n2) runtime?
	 */

	public static int threeSumSmaller(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int len = nums.length;
		int count = 0;
		Arrays.sort(nums);

		for (int i = 0; i < len - 2; i++) {
			//no need to do this, as long as the indices are different
//			if (i > 0 && nums[i] == nums[i - 1]) {
//				continue;
//			}

			int tempSum = target - nums[i];

			int start = i + 1;
			int end = len - 1;

			while (start < end) {
				if (nums[start] + nums[end] < tempSum) {
					count += end - start;
					start++;
				} else {
					end--;
				}
			}
		}

		return count;
	}
}
