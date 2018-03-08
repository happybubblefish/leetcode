package _201_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _288_uniqueWordAbbreviation {

	public static void main(String[] args) {
		String[] dictionary = { "deer", "door", "cake", "card", "it", "i" };
		
		_288_uniqueWordAbbreviation uwa = new _288_uniqueWordAbbreviation(dictionary);
		
		System.out.println(uwa.isUnique("door"));
	}

	/*
	 * The description (A word's abbreviation is unique if no other word from the
	 * dictionary has the same abbreviation) is clear however a bit twisting. It
	 * took me a few "Wrong Answer"s to finally understand what it's asking for. We
	 * are trying to search for a word in a dictionary. If this word (also this
	 * word’s abbreviation) is not in the dictionary OR this word and only it’s
	 * abbreviation in the dictionary. We call a word’s abbreviation unique. EX:
	 * 
	 * 1) [“dog”]; isUnique(“dig”); //False, because “dig” has the same abbreviation
	 * with “dog" and “dog” is already in the dictionary. It’s not unique.
	 * 
	 * 2) [“dog”, “dog"]; isUnique(“dog”); //True, because “dog” is the only word
	 * that has “d1g” abbreviation.
	 * 
	 * 3) [“dog”, “dig”]; isUnique(“dog”); //False, because if we have more than one
	 * word match to the same abbreviation, this abbreviation will never be unique.
	 */

	private Map<String, List<String>> map;
	
	public _288_uniqueWordAbbreviation(String[] dictionary) {
		map = new HashMap<>();
		
		int len = dictionary.length;
		String key = "";
		
		for(int i = 0; i < len; i++) {
			String str = dictionary[i];
			
			
			if(str.length() > 2) {
				key = "" + str.charAt(0) + (str.length() - 2) + str.charAt(str.length() - 1);
				if(map.containsKey(key)) {
					map.get(key).add(str);
				} else {
					List<String> l = new ArrayList<String>();
					l.add(str);
					map.put(key, l);
				}
			} else {
				key = str;
				if(!map.containsKey(key)) {
					List<String> l = new ArrayList<String>();
					l.add(str);
					map.put(key, l);
				}
			}
		}
    }

	public boolean isUnique(String word) {
		String key = "";
		
		if(word.length() > 2) {
			key = "" + word.charAt(0) + (word.length() - 2) + word.charAt(word.length() - 1);
		} else {
			key = word;
		}
		
		if(map.containsKey(key)) {
			return map.get(key).size() == 1 && map.get(key).contains(word);
		} else {
			return true;
		}
	}
}

/*
private Map<String, String> map;
public ValidWordAbbr(String[] dictionary) {
    map = new HashMap<>();
    for (String s : dictionary) {
        String key = getKey(s);
        String cur = map.get(key);
        if (cur == null) {
            map.put(key, s);
        } else {
            if (!cur.equals(s)) {
                map.put(key, "");
            }
        }
    }
}

private String getKey(String word) {
    if (word.length() <= 2) {
        return word;
    }
    return word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
}

public boolean isUnique(String word) {
    String cur = map.get(getKey(word));
    if (cur == null) {
        return true;
    } 
    return cur.equals(word);
}
*/