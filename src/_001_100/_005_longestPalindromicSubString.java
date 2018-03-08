package _001_100;

public class _005_longestPalindromicSubString {
    public static void main(String[] args) {
        String s = "abba";

        System.out.println(longestPalindrome(s));
    }

    /**
     * Both bb and bcb are palindrome
     */
    public static String longestPalindrome(String s) {
        if(s == null || s.length() <= 1){
            return s;
        }

        int max = 0;
        int len = s.length();
        String tempStr = "";
        String result = "";

        for(int i = 0; i < len; i++){
            tempStr = getPalindrome(s, i, i);
            if(result.length() < tempStr.length()) {
                result = tempStr;
            }

            tempStr = getPalindrome(s, i, i + 1);
            if(result.length() < tempStr.length()) {
                result = tempStr;
            }
        }

        return result;
    }

    private static String getPalindrome(String s, int start, int end) {
        int len = s.length();

        while(start >= 0 && end < len && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        return s.substring(start + 1, end);
    }
}
