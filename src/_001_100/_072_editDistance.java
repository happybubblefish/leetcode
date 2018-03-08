package _001_100;

public class _072_editDistance {

	public static void main(String[] args) {
		String word1 = "acd";
		String word2 = "abd";
		
		System.out.println(minDistance(word1, word2));
	}

	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		
		if(word1.length() == 0) {
			return word2.length();
		}
		
		if(word2.length() == 0) {
			return word1.length();
		}
		
		int[][] d = new int[len1 + 1][len2 + 1];
		
		for(int i = 0; i <= len1; i++) {
			d[i][0] = i; 
		}
		
		for(int j = 0; j <= len2; j++) {
			d[0][j] = j;
		}
		
		for(int i = 1; i <= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
					d[i][j] = d[i - 1][j - 1];
				} else {
					int min = Math.min(d[i - 1][j - 1], d[i][j - 1]);
					d[i][j] = 1 + Math.min(min, d[i - 1][j]);
				}
			}
		}
		
		return d[len1][len2];
	}
}
