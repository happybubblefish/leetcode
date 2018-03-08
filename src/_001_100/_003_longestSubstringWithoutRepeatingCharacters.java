package _001_100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _003_longestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "bbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * Should be very careful that if repeating character has been found, starting point can go back.
     *
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s == null) {
            return 0;
        }

        if(s.length() <= 1) {
            return s.length();
        }

        int len = s.length();
        Set<Character> set = new HashSet<>();
        int max = 0;
        int tempCount = 0;
        int start = 0;

        while(start + tempCount < len) {
            if(set.contains(s.charAt(start + tempCount))){
                max = max < tempCount ? tempCount : max;
                tempCount = 0;
                start++;
                set = new HashSet<>();
            } else{
                set.add(s.charAt(start + tempCount));
                tempCount++;
            }
        }

        max = max < tempCount ? tempCount : max;

        return max;
    }
}
