package _301_400;

import java.util.ArrayList;
import java.util.List;

public class _320_generalizedAbbreviation {

	public static void main(String[] args) {
		List<String> res = generateAbbreviations("do");
		
		for(String str : res) {
			System.out.print(str + " ");
		}
	}

	/*
		Write a function to generate the generalized abbreviations of a word.
	
		Example:
		Given word = "word", return the following list (order does not matter):
		["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
	*/
	
	/*
		The idea is: for every character, we can keep it or abbreviate it. To keep it, we add it to the current solution and carry on backtracking. To abbreviate it, we omit it in the current solution, but increment the count, which indicates how many characters have we abbreviated. When we reach the end or need to put a character in the current solution, and count is bigger than zero, we add the number into the solution.
	*/
	
	public static List<String> generateAbbreviations(String word) {
		List<String> res = new ArrayList<>();
		
		if(word == null || word.length() == 0) {
			return res;
		}
		
		helper(res, word, 0, "", 0);
		
		return res;
	}

	private static void helper(List<String> ret, String word, int pos, String cur, int count) {
		if(pos==word.length()){
            if(count > 0) cur += count;
            ret.add(cur);
        }
        else{
	        	helper(ret, word, pos + 1, cur, count + 1);
	        	helper(ret, word, pos + 1, cur + (count > 0 ? count : "") + word.charAt(pos), 0);
        }
	}
	
//	O(2^n)
}
