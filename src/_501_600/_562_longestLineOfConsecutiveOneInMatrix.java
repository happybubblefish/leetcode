package _501_600;

public class _562_longestLineOfConsecutiveOneInMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		Given a 01 matrix M, find the longest line of consecutive one in the matrix. The line could be horizontal, vertical, diagonal or anti-diagonal.
	
		Example:
			Input:
			[[0,1,1,0],
			 [0,1,1,0],
			 [0,0,0,1]]
			Output: 3
		Hint: The number of elements in the given matrix will not exceed 10,000.
	*/

	/*
		Java O(nm) Time DP Solution
	*/
	
	public int longestLine(int[][] M) {
	    int n = M.length, max = 0;
	    if (n == 0) return max;
	    int m = M[0].length;
	    int[][][] dp = new int[n][m][4];
	    for (int i=0;i<n;i++) 
	        for (int j=0;j<m;j++) {
	            if (M[i][j] == 0) continue;
	            for (int k=0;k<4;k++) dp[i][j][k] = 1;
	            if (j > 0) dp[i][j][0] += dp[i][j-1][0]; // horizontal line
	            if (j > 0 && i > 0) dp[i][j][1] += dp[i-1][j-1][1]; // anti-diagonal line
	            if (i > 0) dp[i][j][2] += dp[i-1][j][2]; // vertical line
	            if (j < m-1 && i > 0) dp[i][j][3] += dp[i-1][j+1][3]; // diagonal line
	            max = Math.max(max, Math.max(dp[i][j][0], dp[i][j][1]));
	            max = Math.max(max, Math.max(dp[i][j][2], dp[i][j][3]));
	        }
	    return max;
	}
}

/*
public int longestLine(int[][] m) {
    if(m.length == 0 || m[0].length == 0){
        return 0;
    }
    int max = 0;
    int[] cols = new int[m[0].length];
    int[] diags = new int[m.length + m[0].length];
    int[] aDiags = new int[m.length + m[0].length];
    
    for(int i = 0; i < m.length; i++){
        
    int rows = 0;
        for(int j = 0; j < m[0].length; j++){
            if(m[i][j] == 1){
                rows++;
                cols[j]++;
                diags[i+j]++;
                aDiags[i-j+m[0].length]++;
                max = Math.max(max, rows);
                max = Math.max(max, cols[j]);
                max = Math.max(max, diags[i+j]);
                max = Math.max(max,  aDiags[i-j+m[0].length]);
            }
            else{
                rows = 0;
                cols[j] = 0;
                diags[i+j] = 0;
                aDiags[i-j+m[0].length] = 0;
            }
        }
    }
    return max;
}
*/