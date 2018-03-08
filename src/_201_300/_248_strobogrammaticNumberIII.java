package _201_300;

public class _248_strobogrammaticNumberIII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * A strobogrammatic number is a number that looks the same when rotated 180
	 * degrees (looked at upside down).
	 * 
	 * Write a function to count the total strobogrammatic numbers that exist in the
	 * range of low <= num <= high.
	 * 
	 * For example, Given low = "50", high = "100", return 3. Because 69, 88, and 96
	 * are three strobogrammatic numbers.
	 * 
	 * Note: Because the range might be a large number, the low and high numbers are
	 * represented as string.
	 */
	private static final char[][] pairs = { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };

	public int strobogrammaticInRange(String low, String high) {
		int[] count = { 0 };
		for (int len = low.length(); len <= high.length(); len++) {
			char[] c = new char[len];
			dfs(low, high, c, 0, len - 1, count);
		}
		return count[0];
	}

	public void dfs(String low, String high, char[] c, int left, int right, int[] count) {
		if (left > right) {
			String s = new String(c);
			if ((s.length() == low.length() && s.compareTo(low) < 0)
					|| (s.length() == high.length() && s.compareTo(high) > 0)) {
				return;
			}
			count[0]++;
			return;
		}
		for (char[] p : pairs) {
			c[left] = p[0];
			c[right] = p[1];
			if (c.length != 1 && c[0] == '0') {
				continue;
			}
			if (left == right && p[0] != p[1]) {
				continue;
			}
			dfs(low, high, c, left + 1, right - 1, count);
		}
	}

	/*
	private static char[][] pairs = new char[][] { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' },
			{ '9', '6' } };

	public int strobogrammaticInRange(String low, String high) {
		if (low.length() > high.length() || low.length() == high.length() && high.compareTo(low) < 0)
			return 0;
		return strobogrammaticInRangeFrom0(high, true) - strobogrammaticInRangeFrom0(low, false);
	}

	private int strobogrammaticInRangeFrom0(String num, boolean inclusive) {
		int len = num.length();
		if (len == 1) {
			if (num.charAt(0) == '0')
				return inclusive ? 1 : 0; // 0?
			else if (num.charAt(0) == '1')
				return inclusive ? 2 : 1; // 0,1?
			else if (num.charAt(0) < '8')
				return 2; // 0,1
			else if (num.charAt(0) == '8')
				return inclusive ? 3 : 2; // 0,1,8?
			else
				return 3; // 0,1,8
		}
		int sum = 0;
		for (int i = 1; i < len; i++)
			sum += strobogrammaticDigit(i, true);
		sum += strobogrammaticInRangeSameDigits(new char[len], 0, len - 1, num.toCharArray(), inclusive);
		return sum;
	}

	private int strobogrammaticInRangeSameDigits(char[] chs, int i, int j, char[] upper, boolean inclusive) {
		int sum = 0;
		if (i > j) {
			if (inclusive && compareCharArray(upper, chs, chs.length - 1) >= 0
					|| !inclusive && compareCharArray(upper, chs, chs.length - 1) > 0)
				return 1;
			else
				return 0;
		}
		for (char[] pair : pairs) {
			if (i == 0 && pair[0] == '0' || i == j && (pair[0] == '6' || pair[0] == '9'))
				continue;
			chs[i] = pair[0];
			chs[j] = pair[1];
			if (compareCharArray(chs, upper, i) > 0)
				break;
			sum += strobogrammaticInRangeSameDigits(chs, i + 1, j - 1, upper, inclusive);
		}
		return sum;
	}

	private int strobogrammaticDigit(int digit, boolean outside) {
		if (digit == 0)
			return 1;
		if (digit == 1)
			return 3;
		return outside ? strobogrammaticDigit(digit - 2, false) * 4 : strobogrammaticDigit(digit - 2, false) * 5;
	}

	private int compareCharArray(char[] arr1, char[] arr2, int idx) {
		for (int i = 0; i <= idx; i++)
			if (arr1[i] == arr2[i])
				continue;
			else if (arr1[i] > arr2[i])
				return 1;
			else
				return -1;
		return 0;
	}
	*/
}
