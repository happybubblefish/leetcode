package _001_100;

public class _007_reverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(2147483647));
    }

    //corner case: Integer.MAX_VALUE, Integer.MIN_VALUE, 10, 20
    public static int reverse(int x) {
        if(x == Integer.MIN_VALUE) {
            return 0;
        }

        long sum = 0;
        int digit = 0;
        int sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        int result;

        while(x >= 10) {
            digit = x % 10;
            sum = (sum + digit) * 10;
            x /= 10;
        }

        sum += x % 10;

        if(sum * sign > (long)Integer.MAX_VALUE || sum * sign < (long)Integer.MIN_VALUE) {
            result = 0;
        } else {
            result = (int)sum * sign;
        }

        return result;
    }
}
