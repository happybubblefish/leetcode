package _001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _090_subsetsII {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2 };

        List<List<Integer>> res = subsetsWithDup(nums);

        for(List<Integer> list : res) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);
        int len = nums.length;

        for(int i = 1; i <= len; i++) {
            helper(res, nums, new ArrayList<>(), i, 0);
        }

        res.add(new ArrayList<>());

        return res;
    }

    private static void helper(List<List<Integer>> res, int[] nums, List<Integer> temp, int total, int start) {
        if(temp.size() == total) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i = start; i < nums.length; i++) {
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            temp.add(nums[i]);
            helper(res, nums, temp, total, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
