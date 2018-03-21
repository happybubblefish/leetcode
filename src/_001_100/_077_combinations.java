package _001_100;

import java.util.ArrayList;
import java.util.List;

public class _077_combinations {
    public static void main(String[] args) {
        List<List<Integer>> res = combine(4, 2);

        for(List<Integer> list : res) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        if(n <= 0 || n < k || k <= 0) {
            return res;
        }

        helper(n, k, res, new ArrayList<>(), 1);

        return res;
    }

    private static void helper(int n, int k, List<List<Integer>> res, List<Integer> temp, int start) {
        if(temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = start; i <= n; i++) {
            temp.add(i);
            helper(n, k, res, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
