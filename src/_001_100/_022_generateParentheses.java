package _001_100;

import java.util.ArrayList;
import java.util.List;

public class _022_generateParentheses {
    public static void main(String[] args) {
        List<String> res = generateParenthesis(3);

        for(String str : res) {
            System.out.println(str);
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        helper(res, n, n, "");

        return res;
    }

    private static void helper(List<String> res, int left, int right, String temp) {
        if(left == 0 && right == 0) {
            res.add(temp);
        }

        if(right < left || left < 0 || right < 0) {
            return;
        }

        helper(res, left - 1, right, temp + "(");

        helper(res, left, right - 1, temp + ")");
    }
}
