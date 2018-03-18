package _001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _039_combinationSum {
    public static void main(String[] args) {
        int[] candidates = { 2, 3, 6, 7 };

        List<List<Integer>> res = combinationSum(candidates, 7);

        for(List<Integer> list : res) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(candidates);

        helper(res, candidates, new ArrayList<Integer>(), target, 0);

        return res;
    }

    private static void helper(List<List<Integer>> res, int[] candidates, List<Integer> temp, int left, int start) {
        if(left < 0) {
            return;
        }

        if(left == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }

        for(int i = start; i < candidates.length; i++) {
            temp.add(candidates[i]);
            helper(res, candidates, temp, left - candidates[i], i);
            temp.remove(temp.size() - 1);
        }
    }
}
