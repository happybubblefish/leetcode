package _001_100;

import java.util.ArrayList;
import java.util.List;

public class _060_permutationSquences {
    public static void main(String[] args) {
        System.out.println(getPermutation(4, 10));
    }

    public static String getPermutation(int n, int k) {
        if(n <= 0 || k <= 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String[] result = new String[1];
        result[0] = "";
        boolean[] visited = new boolean[n + 1];

        helper(n, sb, k, 1, result, visited, new ArrayList<String>());

        return result[0];
    }

    private static void helper(int total, StringBuilder sb, int k, int start, String[] result, boolean[] visited, List<String> list) {
        if(sb.length() == total) {
            System.out.println("--- " +  sb.toString());
            list.add(sb.toString());

            if(list.size() == k) {
                result[0] = list.get(k - 1);
            }

            return;
        }

        for(int i = 1; i <= total; i++) {
            if(!visited[i]) {
                sb.append(i);
                visited[i] = true;
                helper(total, sb,  k, i, result, visited, list);
                visited[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

        }
    }
}
