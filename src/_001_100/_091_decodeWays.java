package _001_100;

public class _091_decodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings("1"));
    }

    public static int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int[] dp = new int[len + 1];

        //initialize
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i < len + 1; i++) {
            int first = Integer.parseInt(s.substring(i - 1, i));
            int second = Integer.parseInt(s.substring(i - 2, i));

            //if one digit is valid, then number should be same to without adding this digit
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i - 1];
            }

            //if two digits combination is valid, then number should be same to without adding this two digits
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[len];
    }
}
