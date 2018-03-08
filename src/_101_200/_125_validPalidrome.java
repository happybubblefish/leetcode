package _101_200;

public class _125_validPalidrome {

	public static void main(String[] args) {
		String s = "a, bc... c ba";
		
		System.out.println(isPalindrome(s));
	}

	public static boolean isPalindrome(String s) {
		if(s == null) {
			return false;
		}
		
		if(s.length() == 0) {
			return true;
		}
		
		s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		int len = s.length();
		int start = 0;
		int end = len - 1;
		
		while(start < end) {
			if(s.charAt(start) != s.charAt(end)) {
				return false;
			}
			
			start++;
			end--;
		}
		
		return true;
	}
}
