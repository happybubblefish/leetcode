package _001_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _017_letterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        String digits = "234";

        List<String> res = letterCombinations(digits);

        for(String str : res) {
            System.out.print(str + " ");
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if(digits == null || digits.isEmpty()) {
            return res;
        }

        Map<Character, String> map = new HashMap<Character, String>(){{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};

        int len = digits.length();

        helper(res, digits, map, new StringBuilder(), 0);

        return res;
    }

    private static void helper(List<String> res, String digits, Map<Character, String> map, StringBuilder sb, int start) {
        if(sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String temp = map.get(digits.charAt(start));

        for(int i = 0; i < temp.length(); i++) {
            sb.append(temp.charAt(i));
            helper(res, digits, map, sb, start + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
