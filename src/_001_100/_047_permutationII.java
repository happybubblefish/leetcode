package _001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _047_permutationII {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2 };

        List<List<Integer>> res = permuteUnique(nums);

        for(List<Integer> list : res) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);

        helper(res, nums, new ArrayList<Integer>(), visited);

        return res;
    }

    private static void helper(List<List<Integer>> res, int[] nums, List<Integer> temp, boolean[] visited) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }

            if(!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                helper(res, nums, temp, visited);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}
