package _601_700;

public class _727_minimumWindowSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		Given strings S and T, find the minimum (contiguous) substring W of S, so that T is a subsequence of W.
	
		If there is no such window in S that covers all characters in T, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.
	
		Example 1:
		Input: 
		S = "abcdebdde", T = "bde"
		Output: "bcde"
		Explanation: 
		"bcde" is the answer because it occurs before "bdde" which has the same length.
		"deb" is not a smaller window because the elements of T in the window must occur in order.
		Note:
	
		All the strings in the input will only contain lowercase letters.
		The length of S will be in the range [1, 20000].
		The length of T will be in the range [1, 100].
	*/
	
	public String minWindow(String S, String T) {
        String output = "";
        int minLen = 20001;
        for (int i = 0; i <= S.length() - T.length(); i++) {
        	while (i < S.length() && S.charAt(i) != T.charAt(0)) {
        		i++;
        	}
        	int l = find(S.substring(i, Math.min(i + minLen, S.length())), T);
        	if (l != -1 && l < minLen) {
        		minLen = l;
        		output = S.substring(i, i + l);
        	}
        }
        return output;
    }
	
	private int find(String S, String T) {
		for (int i = 0, j = 0; i < S.length() && j < T.length();) {
			if (S.charAt(i) == T.charAt(j)) {
				i++;
				j++;
				if (j == T.length()) {
					return i;
				}
			} else {
				i++;
			}
		}
		return -1;
	}
}
/*
	TC is (n - m) * n
*/

/*
public String minWindow(String S, String T) {
    int m = S.length(), n = T.length();
    int l = 0, r = m;
    
    int[] p = new int[n];
    Arrays.fill(p, -1);
    
    for (int i = 0; i < m; i = p[0] + 1) {
        for (int j = 0, k = i; j < n && k > p[j]; j++, k++) {
            while (k < m && S.charAt(k) != T.charAt(j)) k++;
            if (k == m) return (r == m ? "" : S.substring(l, r + 1));
            p[j] = k;
        }
        
        if (p[n - 1] - p[0] < r - l) {
            l = p[0]; r = p[n - 1];
        }
    }
    
    return S.substring(l, r + 1);
}
*/