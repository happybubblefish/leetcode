package _201_300;

public class _243_shortestWordDistance {

	public static void main(String[] args) {
		String[] words = { "practice", "makes", "perfect", "coding", "makes" };
		
		System.out.println(shortestDistance(words, "practice", "coding"));
	}
	
	/**
	   Linkedin
	   Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
	 
	   For example,
			Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

			Given word1 = “coding”, word2 = “practice”, return 3.
			Given word1 = "makes", word2 = "coding", return 1.

			Note:
			You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
	*/

	public static int shortestDistance(String[] words, String word1, String word2) {
		int len = words.length;
		
		int ind1 = Integer.MAX_VALUE;
		int ind2 = Integer.MAX_VALUE;
		int sd = Integer.MAX_VALUE;
		int lastSd = 0;
		
		for(int i = 0; i < len; i++) {
			if(!words[i].equals(word1) && !words[i].equals(word2)) {
				continue;
			} else {
				if(words[i].equals(word1)) {
					ind1 = i;
				} else if(words[i].equals(word2)) {
					ind2 = i;
				}
				
				lastSd = Math.abs(ind1 - ind2);
				sd = Math.min(sd, lastSd);
			}
		}
		
		return sd;
	}
}
