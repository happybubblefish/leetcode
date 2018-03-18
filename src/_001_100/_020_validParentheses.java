package _001_100;

import java.util.LinkedList;
import java.util.Stack;

public class _020_validParentheses {
    public static void main(String[] args) {
        String s = "";

        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        if(s == null) {
            return false;
        }

        if(s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        int len = s.length();

        for(int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if(stack.empty()) {
                stack.push(ch);
            } else {
                char top = stack.peek();

                if(ch == ')' && top == '(' || ch == ']' && top == '[' || ch == '}' && top == '{') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        return stack.empty();
    }
}
