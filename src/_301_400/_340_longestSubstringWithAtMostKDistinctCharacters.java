package _301_400;

public class _340_longestSubstringWithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstringKDistinct("abaccc", 2));
	}

	/*	Google, AppDynamics, Coupang
		Given a string, find the length of the longest substring T that contains at most k distinct characters.
	
		For example, Given s = “eceba” and k = 2,
	
		T is "ece" which its length is 3.
	*/
	
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
		int[] temp = new int[256];
		int i = 0;
		int res = 0;
		int num = 0;
		int len = s.length();
		
		for(int j = 0; j < len; j++) {
//			if(temp[s.charAt(j)] == 0) { //different with the following
//				num++;
//			}
//			
//			temp[s.charAt(j)]++;
			
			if(temp[s.charAt(j)]++ == 0) {
				num++;
			}
			//when num = k + 1, i will move forward, so that between i and j, there are at most k distinct letter.
			//however, the actual length should be tracked at the beginning. res = Math.max(res, j - i + 1);
			while(num > k && i < len) {
				temp[s.charAt(i)]--;
				
				if(temp[s.charAt(i)] == 0) {
					num--;
				}
				
				i++;
			}
			
			res = Math.max(res, j - i + 1);
		}
		
		return res;
	}
}

/*
public int lengthOfLongestSubstringKDistinct(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    int left = 0;
    int best = 0;
    for(int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        map.put(c, map.getOrDefault(c, 0) + 1);
        while (map.size() > k) {
            char leftChar = s.charAt(left);
            if (map.containsKey(leftChar)) {
                map.put(leftChar, map.get(leftChar) - 1);                     
                if (map.get(leftChar) == 0) { 
                    map.remove(leftChar);
                }
            }
            left++;
        }
        best = Math.max(best, i - left + 1);
    }
    return best;
} 
*/