package _201_300;

public class _204_countPrimes {

	public static void main(String[] args) {
		System.out.println(countPrimes(4));
	}

	public static int countPrimes(int n) {
		boolean[] noPrimes = new boolean[n];
		int count = 0;
		
		for(int i = 2; i < n; i++) {
			if(!noPrimes[i]) {
				count++;
				
				for(int j = i; j < n; j += i) {
					noPrimes[j] = true;
				}
			}
		}
		
		return count;
	}
}
