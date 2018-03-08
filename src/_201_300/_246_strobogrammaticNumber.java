package _201_300;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _246_strobogrammaticNumber {

	public static void main(String[] args) {
		System.out.println(isStrobogrammatic("6"));
	}

	/*
	 * Google
	 * A strobogrammatic number is a number that looks the same when rotated 180
	 * degrees (looked at upside down).
	 * 
	 * Write a function to determine if a number is strobogrammatic. The number is
	 * represented as a string.
	 * 
	 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
	 */

	public static boolean isStrobogrammatic(String num) {
		if (num == null) {
			return false;
		}

		if (num.isEmpty()) {
			return true;
		}

		if (num.length() == 1) {
			return num.equals("1") || num.equals("8") || num.equals("0");
		}

		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');

		int len = num.length();
		int start = 0;
		int end = len - 1;
		Set<Character> set = map.keySet();

		while (start < end) {
			if (set.contains(num.charAt(start)) && map.get(num.charAt(start)) == num.charAt(end)) {
				start++;
				end--;

				continue;
			}

			return false;
		}

		return map.containsKey(num.charAt(start));

		/*
		char[] input = num.toCharArray();
		int len = input.length;
		int left = 0;
		int right = len - 1;
		while (left <= right) {
			int temp = input[left] - '0';
			if ((temp >= 2 && temp <= 5) || temp == 7) {
				return false;
			} else if (temp == 6) {
				if (input[right] != '9')
					return false;
			} else if (temp == 9) {
				if (input[right] != '6')
					return false;
			} else if (temp != input[right] - '0') {
				return false;
			}
			left++;
			right--;
		}

		return true;
		
		*/
	}
}
