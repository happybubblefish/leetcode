package _201_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _244_shortestWordDistanceII {

	public static void main(String[] args) {
		String[] words = { "practice", "makes", "perfect", "coding", "makes" };
		_244_shortestWordDistanceII wd = new _244_shortestWordDistanceII(words);

		System.out.println(wd.shortest("makes", "coding"));
	}

	/*
	 * This is a follow up of Shortest Word Distance. The only difference is now you
	 * are given the list of words and your method will be called repeatedly many
	 * times with different parameters. How would you optimize it?
	 * 
	 * Design a class which receives a list of words in the constructor, and
	 * implements a method that takes two words word1 and word2 and return the
	 * shortest distance between these two words in the list.
	 * 
	 * For example, Assume that words = ["practice", "makes", "perfect", "coding",
	 * "makes"].
	 * 
	 * Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes",
	 * word2 = "coding", return 1.
	 * 
	 * Note: You may assume that word1 does not equal to word2, and word1 and word2
	 * are both in the list.
	 */

	// Using Map.Entry will cause TLE
	private Map<String, List<Integer>> map;

	public _244_shortestWordDistanceII(String[] words) {
		this.map = new HashMap<>();

		int len = words.length;

		for (int i = 0; i < len; i++) {
			String w = words[i];
			if (this.map.containsKey(words[i])) {
				this.map.get(w).add(i);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				this.map.put(w, list);
			}
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> l1 = this.map.get(word1);
		List<Integer> l2 = this.map.get(word2);

		int len1 = l1.size();
		int len2 = l2.size();
		int sd = Integer.MAX_VALUE;

		for (int i = 0, j = 0; i < len1 && j < len2;) {
			int ind1 = l1.get(i);
			int ind2 = l2.get(j);

			// Note the increment sequence here.
			if (ind1 > ind2) {
				sd = Math.min(sd, ind1 - ind2);
				j++;
			} else {
				sd = Math.min(sd, ind2 - ind1);
				i++;
			}
		}

		return sd;
	}

	/**
	 * Your WordDistance object will be instantiated and called as such:
	 * WordDistance obj = new WordDistance(words); int param_1 =
	 * obj.shortest(word1,word2);
	 */

	/*
	Map<String, List<Integer>> map;

	public WordDistance(String[] words) {
        map = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            
            List<Integer> list = map.get(str);
            if (list == null) {
                list = new ArrayList<>();
                map.put(str, list);
            }
            list.add(i);
        }       
    }

	public int shortest(String word1, String word2) {
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);

		int i = 0;
		int j = 0;
		int min = Integer.MAX_VALUE;
		while (i < list1.size() && j < list2.size()) {
			int index1 = list1.get(i);
			int index2 = list2.get(j);

			if (index1 < index2) {
				min = Math.min(min, index2 - index1);
				i++;
			} else {
				min = Math.min(min, index1 - index2);
				j++;
			}
		}

		return min;
	}
	*/
}
