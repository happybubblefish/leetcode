package _101_200;

import java.util.ArrayList;
import java.util.List;

public class _163_missingRanges {

	public static void main(String[] args) {
		int[] nums = { 2147483647 };
		
		List<String> res = findMissingRanges(nums, 0, 2147483647);
		
		for(String str : res) {
			System.out.print(str + " ");
		}
	}

	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
		
		if(nums == null) {
			return res;
		}
		
		int len = nums.length;
		
		for(int i = 0; i <= len; i++) {
			int lt = 0;
			int gt = 0;
			
			if(i == 0) {
				lt = lower;
			} else if(nums[i - 1] == Integer.MAX_VALUE){
				break;
			} else {
				lt =  nums[i - 1] + 1;
			}
			
			if(i == len) {
				gt = upper;
			} else if(nums[i] == Integer.MIN_VALUE) {
				continue;
			} else {
				gt = nums[i] - 1;
			}
			
			addToList(res, lt, gt);
		}
		
		return res;
	}

	private static void addToList(List<String> res, int lt, int gt) {
		if(lt > gt) {
			return;
		} else if(lt == gt) {
			res.add(String.valueOf(lt));
		} else {
			res.add(lt + "->" + gt);
		}
	}
}
