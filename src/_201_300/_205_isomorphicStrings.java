package _201_300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _205_isomorphicStrings {

	public static void main(String[] args) {
		System.out.println(isIsomorphic("ab", "aa"));
	}

	public static boolean isIsomorphic(String s, String t) {
		if(s == null) {
			return t == null;
		}
		
		if(t == null) {
			return s == null;
		}
		
		if(s.length() != t.length()) {
			return false;
		}
		
		int len = s.length();
		Map<Character, Character> map = new HashMap<>();
		Set<Character> set = new HashSet<>();
		
		for(int i = 0; i < len; i++) {
			Character ch = s.charAt(i);
			if(map.containsKey(s.charAt(i))) {
				Character tch = map.get(ch);
				if(tch != t.charAt(i)) {
					return false;
				}
			} else {
				map.put(ch, t.charAt(i));
				if(set.contains(t.charAt(i))) {
					return false;
				}
				set.add(t.charAt(i));
			}
		}
		
		return true;
		
//		public:
//		    bool isIsomorphic(string s, string t) {
//		        int m1[256] = {0}, m2[256] = {0}, n = s.size();
//		        for (int i = 0; i < n; ++i) {
//		            if (m1[s[i]] != m2[t[i]]) return false;
//		            m1[s[i]] = i + 1;
//		            m2[t[i]] = i + 1;
//		        }
//		        return true;
//		    }
	}
}
