package _201_300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _247_strobogrammaticNumberII {

	public static void main(String[] args) {
		List<String> res = findStrobogrammatic2(3);

		for (String str : res) {
			System.out.println(str + " ");
		}
	}

	/*
	 * Google
	 * A strobogrammatic number is a number that looks the same when rotated 180
	 * degrees (looked at upside down).
	 * 
	 * Find all strobogrammatic numbers that are of length = n.
	 * 
	 * For example, Given n = 2, return ["11","69","88","96"].
	 */

	public static List<String> findStrobogrammatic(int n) {
		return helper(n, n);
	}

	private static List<String> helper(int n, int m) {
		if (n == 0) {
			return new ArrayList<String>(Arrays.asList(""));
		}

		if (n == 1) {
			return new ArrayList<String>(Arrays.asList("0", "1", "8"));
		}

		List<String> list = helper(n - 2, m);

		List<String> res = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);

			if (n != m) {
				res.add("0" + s + "0");
			}

			res.add("1" + s + "1");
			res.add("6" + s + "9");
			res.add("8" + s + "8");
			res.add("9" + s + "6");
		}

		return res;
	}

	/*
	public List<String> findStrobogrammatic(int n) {
		List<String> res = new ArrayList<>();
		if (n <= 0)
			return res;
		char[][] digits = new char[][] { { '0', '0' }, { '1', '1' }, { '8', '8' }, { '6', '9' }, { '9', '6' } };
		char[] candidate = new char[n];
		dfsHelper(digits, candidate, res, 0, n);
		return res;
	}

	private void dfsHelper(char[][] digits, char[] candidate, List<String> res, int idx, int n) {
		if (idx == (n + 1) / 2) {
			String number = new String(candidate);
			res.add(number);
			return;
		}

		for (int i = 0; i < digits.length; i++) {
			if (digits[i][0] == '0' && idx == 0 && n > 1) {
				continue;
			}
			if (idx == n - idx - 1 && (digits[i][0] == '6' || digits[i][0] == '9'))
				continue;
			candidate[idx] = digits[i][0];
			candidate[n - idx - 1] = digits[i][1];
			dfsHelper(digits, candidate, res, idx + 1, n);
		}
	}
	*/
	
	//Iterative
		public static List<String> findStrobogrammatic2(int n) {
	        List<String> cur, ans;
	        ans = new ArrayList<String>((n & 1) == 0 ? Arrays.asList("") : Arrays.asList("0", "1", "8"));
	        if (n < 2) return ans;
	        
	        for (;n > 1; n -= 2) {
	            cur = ans;
	            ans = new ArrayList<String>();
	            for (String i : cur) {
	                if (n > 3) ans.add('0' + i + '0');
	                ans.add('1' + i + '1');
	                ans.add('8' + i + '8');
	                ans.add('6' + i + '9');
	                ans.add('9' + i + '6');
	            }
	        }
	        
	        return ans;
	    }
	
}
