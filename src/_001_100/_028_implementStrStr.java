package _001_100;

public class _028_implementStrStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";

        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if(needle == null || haystack == null || haystack.length() < needle.length()) {
            return -1;
        }

        if(needle.isEmpty()) {
            return 0;
        }

        int hayStackLen = haystack.length();
        int needleLen = needle.length();
        int count = 0;
        int start = 0;

        while(start + count <= hayStackLen) {
            if(count == needleLen) {
                return start;
            }

            if(start + count < hayStackLen && needle.charAt(count) != haystack.charAt(start + count)) {
                start++;
                count = 0;
                continue;
            }

            count++;
        }

        return -1;
    }
}
