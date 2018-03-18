package _001_100;

public class _50_pow {
    public static void main(String[] args) {
        System.out.println(myPow(2, -3));
    }

    public static double myPow(double x, int n) {
        if(n == 0) {
            return 1.0;
        }

        if(n == Integer.MIN_VALUE) {
            x *= x;
            n /= 2;
        }

        if(n < 0) {
            x = 1 / x;
            n = -n;
        }

        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
