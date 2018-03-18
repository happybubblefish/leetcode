package _001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _046_permutations {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };

        List<List<Integer>> res = permute(nums);

        for(List<Integer> list : res) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] visited = new boolean[nums.length];
        helper(res, nums, new ArrayList<Integer>(), visited);

        return res;
    }

    private static void helper(List<List<Integer>> res, int[] nums, List<Integer> temp, boolean[] visited) {
        if(temp.size() == nums.length) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                helper(res, nums, temp, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
