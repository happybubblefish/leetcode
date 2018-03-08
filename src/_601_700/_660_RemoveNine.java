package _601_700;

public class _660_RemoveNine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		Start from integer 1, remove any integer that contains 9 such as 9, 19, 29...
	
		So now, you will have a new integer sequence: 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ...
	
		Given a positive integer n, you need to return the n-th integer after removing. Note that 1 will be the first integer.
	
		Example 1:
		Input: 9
		Output: 10
		Hint: n will not exceed 9 x 10^8.
	*/
	
	/*
		This is a radix problem.
		Just change decimal to 9-based.
	*/
	
	public int newInteger(int n) {
	    return Integer.parseInt(Integer.toString(n, 9));
	}
}

/*
Of course, you can write it yourself.

public int newInteger(int n) {
	int ans = 0;
	int base = 1;
		
	while (n > 0){
		ans += n % 9 * base;
		n /= 9;
		base *= 10;
	}
	return ans;
}
*/