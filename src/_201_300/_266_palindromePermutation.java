package _201_300;

public class _266_palindromePermutation {

	public static void main(String[] args) {
		System.out.println(canPermutePalindrome("code"));
	}

	/*
		Given a string, determine if a permutation of the string could form a palindrome.
	
		For example,
		"code" -> False, "aab" -> True, "carerac" -> True.
	*/
	
	public static boolean canPermutePalindrome(String s) {
		if(s == null || s.length() <= 0) {
			return true;
		}
		
		int count = 0;
		
		int len = s.length();
		int[] temp = new int[256];
		
		for(int i = 0; i < len; i++) {
			temp[s.charAt(i)]++;
		}
		
		for(int i = 0; i < 256; i++) {
			if(temp[i] % 2 == 1) {
				count++;
			}
		}
		
		return count <= 1;
	}
}
