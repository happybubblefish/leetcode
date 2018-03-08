package _201_300;

public class _245_shortestWordDistanceIII {

	public static void main(String[] args) {
		String[] words = { "makes", "makes", "perfect", "coding" };
		
		System.out.println(shortestWordDistance(words, "coding", "makes"));
		System.out.println(shortestWordDistance(words, "makes", "makes"));
	}
	
	/*
		This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
	
		Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
	
		word1 and word2 may be the same and they represent two individual words in the list.
	
		For example,
		Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
	
		Given word1 = “makes”, word2 = “coding”, return 1.
		Given word1 = "makes", word2 = "makes", return 3.
	
		Note:
		You may assume word1 and word2 are both in the list.
	*/
	
	public static int shortestWordDistance(String[] words, String word1, String word2) {
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
					if(word1.equals(word2)) {
						sd = i == ind1 ? sd : Math.min(sd, Math.abs(i - ind1));
					}
					
					ind1 = i;
				} else {
					if(word1.equals(word2)) {
						sd = i == ind2 ? sd : Math.min(sd, Math.abs(i - ind2));
					}
					
					ind2 = i;
				}
				
				lastSd = Math.abs(ind1 - ind2);
				sd = Math.min(sd, lastSd);
			}
		}
		
		return sd;
	}
	
	/*
	public int shortestWordDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        if(word1.equals(word2)) {
            int idx = -1;
            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(word1)) {
                    if(idx != -1) min = Math.min(min, i - idx);
                    idx = i;
                }
            }
        }
        else {
            int idx1 = -1, idx2 = -1;
            for(int i = 0; i < words.length; i++) {
                if(words[i].equals(word1)) {
                    if(idx2 != -1) min = Math.min(min, i - idx2);
                    idx1 = i;
                }
                if(words[i].equals(word2)) {
                    if(idx1 != -1) min = Math.min(min, i - idx1);
                    idx2 = i;
                }
            }
        }
        return min;
    }
    */
}
