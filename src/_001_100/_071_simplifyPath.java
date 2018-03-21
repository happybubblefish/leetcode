package _001_100;

import java.util.Stack;

public class _071_simplifyPath {
    public static void main(String[] args) {
        String path = "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///";

        System.out.println(simplifyPath(path));
    }

    public static String simplifyPath(String path) {
        if(path == null || path.isEmpty()) {
            return path;
        }

        String[] strs = path.split("/");
        int len = strs.length;
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < len; i++) {
            if(strs[i].equals("") || strs[i].equals(".")) {
                continue;
            } else if(strs[i].equals("..")) {
                if(!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(strs[i]);
            }
        }

        StringBuilder sb = new StringBuilder();

        if(stack.empty()) {
            return "/";
        } else {
            while(!stack.empty()) {
                String top = stack.pop();
                sb.insert(0, top);
                sb.insert(0, "/");
            }
        }

        return sb.toString();
    }
}
