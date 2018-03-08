package _201_300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _249_groupShiftedStrings {

	public static void main(String[] args) {
		String[] strs = { "abc", "bcd", "acef", "xyz", "az", "ba", "a", "z" };

		List<List<String>> res = groupStrings(strs);

		for (List<String> l : res) {
			for (String str : l) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}

	/*
	 * Given a string, we can "shift" each of its letter to its successive letter,
	 * for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:
	 * 
	 * "abc" -> "bcd" -> ... -> "xyz" Given a list of strings which contains only
	 * lowercase alphabets, group all strings that belong to the same shifting
	 * sequence.
	 * 
	 * For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], A
	 * solution is:
	 * 
	 * [ ["abc","bcd","xyz"], ["az","ba"], ["acef"], ["a","z"] ]
	 */

	public static List<List<String>> groupStrings(String[] strings) {
		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strings) {
			int len = str.length();
			int offset = str.charAt(0) - 'a';
			String key = "";

			for (int i = 0; i < len; i++) {
				char c = (char) (str.charAt(i) - offset);
				if (c < 'a') {
					c += 26;
				}
				key += c;
			}

			if (!map.containsKey(key)) {
				List<String> l = new ArrayList<>();
				map.put(key, l);
			}

			map.get(key).add(str);
		}

		for (List<String> valueList : map.values()) {
			Collections.sort(valueList);
			res.add(valueList);
		}

		return res;
	}

	/*
	public List<List<String>> groupStrings(String[] strings) {
		HashMap<String, List<String>> map = new HashMap<>();
		for (String s : strings) {
			String seq = getSeq(s);
			if (!map.containsKey(seq))
				map.put(seq, new ArrayList<>());
			map.get(seq).add(s);
		}
		return new LinkedList<>(map.values());
	}

	private String getSeq(String s) {
		if (s.length() == 0)
			return "";
		char[] cs = s.toCharArray();
		char offset = cs[0];
		for (int i = 0; i < cs.length; i++)
			cs[i] = (char) ((cs[i] - offset + 26) % 26);
		return new String(cs);
	}
	*/
}
