package _001_100;

import java.util.HashMap;
import java.util.Map;

public class _013_romanToInteger {
    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXIV"));
    }

    /**
     * Integers are written according to these two rules: If a letter is immediately followed by one of equal or lesser
     * value, the two values are added; thus, XX equals 20, XV equals 15, VI equals 6. If a letter is immediately followed
     * by one of greater value, the first is subtracted from the second; thus, IV equals 4, XL equals 40, CM equals 900.
     * Examples: XLVII(=47), CXVI(=116), MCXX(=1120), MCMXIV(=1914).
     */

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>(){{
            put("I", 1);
            put("IV", 4);
            put("V", 5);
            put("IX", 9);
            put("X", 10);
            put("XL", 40);
            put("L", 50);
            put("XC", 90);
            put("C", 100);
            put("CD", 400);
            put("D", 500);
            put("CM", 900);
            put("M", 1000);
        }};

        int len = s.length();
        int sum = 0;
        String temp = "";
        boolean flag = false;

        for(int i = 0; i < len - 1; i++) {
            temp = s.substring(i, i + 2);
            if(map.containsKey(temp)) {
                sum += map.get(temp);
                if(i == len - 2){
                    flag = true;
                }

                i++;
            } else {
                sum += map.get(s.charAt(i) + "");
            }
        }

        if(!flag) {
            sum += map.get(s.charAt(len - 1) + "");
        }

        return sum;
    }

    //If first > second, add first, else add second - first then jump 2 steps
    public static int romanToInt2(String input) {
        HashMap<Character, Integer> translate = new HashMap<>();
        translate.put('M', 1000);
        translate.put('D', 500);
        translate.put('C', 100);
        translate.put('L', 50);
        translate.put('X', 10);
        translate.put('V', 5);
        translate.put('I', 1);
        int output = 0;

        for (int i = 0; i < input.length(); i++) {
            if (i < input.length() - 1 && translate.get(input.charAt(i)) < translate.get(input.charAt(i+1))) {
                output += translate.get(input.charAt(i+1)) - translate.get(input.charAt(i));
                i++;
            } else {
                output += translate.get(input.charAt(i));
            }
        }

        return output;
    }
}
