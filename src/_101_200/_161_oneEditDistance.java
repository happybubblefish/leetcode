package _101_200;

public class _161_oneEditDistance {

	public static void main(String[] args) {
		String s = "abc";
		String t = "abce";
		
		System.out.println(isOneEditDistance(s, t));
	}

	public static boolean isOneEditDistance(String s, String t) {
		int len = s.length() > t.length() ? t.length() : s.length();
		
		for(int i = 0; i < len; i++) {
			if(s.charAt(i) != t.charAt(i)) {
				if(s.length() == t.length()) {
					return s.substring(i + 1).equals(t.substring(i + 1));
				} else if(s.length() < t.length()) {
					return s.substring(i).equals(t.substring(i + 1));
				} else {
					return t.substring(i).equals(s.substring(i + 1));
				}
			}
		}
		
		return Math.abs(s.length() - t.length()) == 1;
	}
}
