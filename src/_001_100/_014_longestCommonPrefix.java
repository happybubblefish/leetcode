package _001_100;

public class _014_longestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = { "abc", "ac", "abcde", "" };
        System.out.println(longestCommonPrefix(strs));
    }

    //O(nm), n is length of first string, m is length of strs
    //Sort strs first
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        int len = strs.length;

        if(len == 1) {
            return strs[0];
        }

        StringBuilder sb = new StringBuilder();
        String startStr = strs[0];
        int startStrLen = startStr.length();
        boolean flag = false;

        for(int i = 0; i < startStrLen; i++) {
           char ch = startStr.charAt(i);

            for(int j = 1; j < len; j++) {
                if(i >= strs[j].length() || ch != strs[j].charAt(i)){
                    return sb.toString();
                }
            }

            sb.append(ch);
        }

        return sb.toString();
    }
}
