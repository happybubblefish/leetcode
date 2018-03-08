package _201_300;

import java.util.ArrayList;
import java.util.List;

public class _271_encodeAndDecodeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/* Google
	 * Design an algorithm to encode a list of strings to a string. The encoded
	 * string is then sent over the network and is decoded back to the original list
	 * of strings.
	 * 
	 * Machine 1 (sender) has the function:
	 * 
	 * string encode(vector<string> strs) { // ... your code return encoded_string;
	 * } Machine 2 (receiver) has the function: vector<string> decode(string s) {
	 * //... your code return strs; } So Machine 1 does:
	 * 
	 * string encoded_string = encode(strs); and Machine 2 does:
	 * 
	 * vector<string> strs2 = decode(encoded_string); strs2 in Machine 2 should be
	 * the same as strs in Machine 1.
	 * 
	 * Implement the encode and decode methods.
	 * 
	 * Note: The string may contain any possible characters out of 256 valid ascii
	 * characters. Your algorithm should be generalized enough to work on any
	 * possible characters. Do not use class member/global/static variables to store
	 * states. Your encode and decode algorithms should be stateless. Do not rely on
	 * any library method such as eval or serialize methods. You should implement
	 * your own encode/decode algorithm.
	 */

	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
		StringBuilder sb = new StringBuilder();
		for (String s : strs) {
			sb.append(s.length()).append('/').append(s);
		}
		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> ret = new ArrayList<String>();
        int i = 0;
        while(i < s.length()) {
            int slash = s.indexOf('/', i);
            int size = Integer.valueOf(s.substring(i, slash));
            ret.add(s.substring(slash + 1, slash + size + 1));
            i = slash + size + 1;
        }
        return ret;
	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.decode(codec.encode(strs));
}

/*
	String elements = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	int counter = 0;
	HashMap<Integer, List<String>> stol = new HashMap<>();
	
	// Encodes a list of strings to a single string.
	public String encode(List<String> strs) {
	    String shorturl = base10tobase62(counter);
	    stol.put(counter, strs);
	    counter++;
	    return "http://tiny.url/" + shorturl;
	}
	
	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
	    s = s.substring("http://tiny.url/".length());
	    int n = base62ToBase10(s);
	    return stol.get(n);
	}
	
	public int base62ToBase10(String s) {
	    int n = 0;
	    for (int i = 0; i < s.length(); i++) {
	        n = n * 62 + convert(s.charAt(i));
	    }
	    return n;
	    
	}
	public int convert(char c) {
	    if (c >= '0' && c <= '9')
	        return c - '0';
	    if (c >= 'a' && c <= 'z') {
	        return c - 'a' + 10;
	    }
	    if (c >= 'A' && c <= 'Z') {
	        return c - 'A' + 36;
	    }
	    return -1;
	}
	
	private String base10tobase62(int n) {
	    StringBuilder sb = new StringBuilder();
	    while (n != 0) {
	        sb.insert(0, elements.charAt(n%62));
	        n /= 62;
	    }
	    while (sb.length() != 6) {
	        sb.insert(0, '0');
	    }
	    return sb.toString();
	}
*/