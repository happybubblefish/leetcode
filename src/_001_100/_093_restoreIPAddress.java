package _001_100;

import java.util.ArrayList;
import java.util.List;

public class _093_restoreIPAddress {
    public static void main(String[] args) {
        List<String>  res = restoreIpAddresses("1111");

        for(String str : res) {
            System.out.println(str);
        }

        String s = "1";

        System.out.println(s.substring(0, 1));
    }

    public static List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        if(s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }

        helper(res, s, "", 1);

        return res;
    }

    private static void helper(List<String> res, String s, String temp, int deep) {
        if(deep == 4 && isValid(s)) {
            res.add(temp + s);
        }

        for(int i = 0; i < s.length() && i < 3; i++) {
            String str = s.substring(0, i + 1);

            if(isValid(str)) {
                helper(res, s.substring(i + 1), temp + str + ".", deep + 1);
            }
        }
    }

    private static boolean isValid(String s) {
        if(s.equals("")) {  //s.substring(i + 1) may generate ""
            return false;
        }

        if(s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }

        int num = Integer.parseInt(s);

        if(num >= 0 && num <= 255) {
            return true;
        }

        return false;
    }
}
