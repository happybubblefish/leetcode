package _001_100;

import java.util.*;

public class _049_groupAnagrams {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

        List<List<String>> res = groupAnagrams(strs);

        for(List<String> list : res) {
            for(String str : list) {
                System.out.print(str + " ");
            }

            System.out.println();
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            char[] tempCharArr = strs[i].toCharArray();

            Arrays.sort(tempCharArr);

            String sorted = new String(tempCharArr);

            if(map.containsKey(sorted)) {
                List<String> list = map.get(sorted);
                list.add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(sorted, list);
            }
        }

        return new ArrayList<>(map.values());
    }
}
