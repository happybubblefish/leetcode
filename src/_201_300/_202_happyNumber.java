package _201_300;

import java.util.HashSet;
import java.util.Set;

public class _202_happyNumber {

	public static void main(String[] args) {
		System.out.println(isHappy(19));
	}

	public static boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		
		while(n != 1) {
			if(set.contains(n)) {
				return false;
			}
			
			set.add(n);
			n = getNextNumber(n);
		}
		
		return true;
	}

	private static int getNextNumber(int n) {
		int squareSum = 0;
		
		while(n / 10 != 0) {
			squareSum += (n % 10) * (n % 10);
			
			n = n / 10;
		}
		
		squareSum += (n % 10) * (n % 10);
		
		return squareSum;
	}
}
