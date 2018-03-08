package _201_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _267_palidromePermutationII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
	
		For example:
	
			Given s = "aabb", return ["abba", "baab"].
	
			Given s = "abc", return [].
	*/
	public List<String> generatePalindromes(String s) {
		int odd = 0;
	    String mid = "";
	    List<String> res = new ArrayList<>();
	    List<Character> list = new ArrayList<>();
	    Map<Character, Integer> map = new HashMap<>();

	    // step 1. build character count map and count odds
	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
	        odd += map.get(c) % 2 != 0 ? 1 : -1;
	    }

	    // cannot form any palindromic string
	    if (odd > 1) return res;

	    // step 2. add half count of each character to list
	    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
	        char key = entry.getKey();
	        int val = entry.getValue();

	        if (val % 2 != 0) mid += key;

	        for (int i = 0; i < val / 2; i++) list.add(key);
	    }

	    // step 3. generate all the permutations
	    getPerm(list, mid, new boolean[list.size()], new StringBuilder(), res);

	    return res;
	}

	// generate all unique permutation from list
	private void getPerm(List<Character> list, String mid, boolean[] used, StringBuilder sb, List<String> res) {
		if (sb.length() == list.size()) {
	        // form the palindromic string
	        res.add(sb.toString() + mid + sb.reverse().toString());
	        sb.reverse();
	        return;
	    }

	    for (int i = 0; i < list.size(); i++) {
	        // avoid duplication
	        if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) continue;

	        if (!used[i]) {
	            used[i] = true; sb.append(list.get(i));
	            // recursion
	            getPerm(list, mid, used, sb, res);
	            // backtracking
	            used[i] = false; sb.deleteCharAt(sb.length() - 1);
	        }
	    }
	}
	
	/*
		public List<String> generatePalindromes(String s) {
	        List<String> res = new ArrayList<>();
	        if(s.length() == 0) {
	            return res;
	        }
	        int[] cnt = new int[128];
	        for(char c : s.toCharArray()) {
	            cnt[(int)c]++;
	        }
	        int odd_cnt = 0, odd_idx = -1;
	        for(int i = 0; i < cnt.length; i++) {
	            if(cnt[i] % 2 != 0) {
	                odd_cnt++;
	                odd_idx = i;
	            }
	        }
	        if(odd_cnt <= 1) {
	            StringBuilder sb = new StringBuilder();
	            if(odd_idx != -1) {
	                sb.append((char)odd_idx);
	                cnt[odd_idx]--;
	            }
	            formPalindrome(sb.toString(), s, cnt, res);
	        }
	        
	        return res;
	    }
	    
	    public void formPalindrome(String temp, String s, int[] cnt, List<String> res) {
	        if(temp.length() == s.length()) {
	            res.add(temp);
	            return;
	        }
	        for(int i = 0; i < cnt.length; i++) {
	            if(cnt[i] - 2 >= 0) {
	                cnt[i] -= 2;
	                formPalindrome((char)i + temp + (char)i, s, cnt, res);
	                cnt[i] += 2;
	            }
	        }
	    }
    */
}
