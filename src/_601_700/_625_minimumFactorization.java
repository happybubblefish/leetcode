package _601_700;

import java.util.ArrayList;
import java.util.List;

public class _625_minimumFactorization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		Given a positive integer a, find the smallest positive integer b whose multiplication of each digit equals to a.
	
		If there is no answer or the answer is not fit in 32-bit signed integer, then return 0.
	
		Example 1
		Input:
	
		48 
		Output:
		68
		Example 2
		Input:
	
		15
		Output:
		35
	*/
	
	public int smallestFactorization(int n) {
        // Case 1: If number is smaller than 10
        if (n < 10) return n;
        
        // Case 2: Start with 9 and try every possible digit
        List<Integer> res = new ArrayList<>();
        for (int i = 9; i > 1; i--) {
            // If current digit divides n, then store all
            // occurrences of current digit in res
            while (n % i == 0) {
                n = n / i;
                res.add(i);
            }
        }

        // If n could not be broken in form of digits
        if (n != 1) return 0;

        // Get the result from the array in reverse order
        long result = 0;
        for (int i = res.size() - 1; i >= 0; i--) {
            result = result * 10 + res.get(i);
            if (result > Integer.MAX_VALUE) return 0;
        }
        
        return (int)result;
    }
}

/*
public int smallestFactorization(int a) {
    if(a <= 2) {
        return a;
    }
    long k = 1;
    long sum = 0;
    for (int i = 9; i >1;i--) {
        while (a % i == 0) {
            sum = sum+i*k;
            a =a/i;
            k=k*10;
        }
    }
    return a<2 && sum < Integer.MAX_VALUE? (int)sum: 0;
}
*/