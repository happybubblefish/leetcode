package _201_300;

import java.util.ArrayList;
import java.util.List;

public class _254_factorCombinations {

	public static void main(String[] args) {
		List<List<Integer>> res = getFactors(32);
		
		for(List<Integer> list : res) {
			for(Integer i : list) {
				System.out.print(i + " ");
			}
			
			System.out.println();
		}
	}

	public static List<List<Integer>> getFactors(int n) {
		List<List<Integer>> res = new ArrayList<>();
		
		dfs(res, new ArrayList<Integer>(), 2, n);
		
		return res;
	}

	private static void dfs(List<List<Integer>> res, List<Integer> temp, int start, int n) {
		if(n == 0 || n == 1) {
			if(temp.size() > 1) {
				res.add(new ArrayList<>(temp));
			}
		}
		
		for(int i = start; i <= n; i++) {
			if(n % i == 0) {
				temp.add(i);
				dfs(res, temp, i, n / i);
				temp.remove(temp.size() - 1);
			}
		}
	}
}
