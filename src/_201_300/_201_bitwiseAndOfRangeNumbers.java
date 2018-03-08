package _201_300;

public class _201_bitwiseAndOfRangeNumbers {

	public static void main(String[] args) {
		System.out.println(rangeBitwiseAnd(5, 9));
	}

	public static int rangeBitwiseAnd(int m, int n) {
		if(m == 0) {
			return 0;
		}
		
		int result = 1;
		
		while(m != n) {
			m >>= 1;
			n >>= 1;
			
			result <<= 1;
		}
		
		return m * result;
	}
}
