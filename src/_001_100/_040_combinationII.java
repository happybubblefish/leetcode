package _001_100;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _040_combinationII {
    public static void main(String[] args) {
        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };

        List<List<Integer>> res = combinationSum2(candidates, 8);

        for(List<Integer> list : res) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
        }

        for(int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            temp.add(candidates[i]);
            helper(res, candidates, temp, left - candidates[i], i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
