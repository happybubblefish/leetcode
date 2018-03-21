package _001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _078_subsets {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };

        List<List<Integer>> res = subsets(nums);

        for(List<Integer> list : res) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }

            System.out.println();
        }

    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums == null || nums.length == 0) {
            return res;
        }

        Arrays.sort(nums);

        for(int i = 1; i <= nums.length; i++) {
            helper(res, nums, new ArrayList<>(), i, 0);
        }

        res.add(new ArrayList<>());

        return res;
    }

    private static void helper(List<List<Integer>> res, int[] nums, List<Integer> temp, int total, int start) {
        if(temp.size() == total) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(res, nums, temp, total, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
