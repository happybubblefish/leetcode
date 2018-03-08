package _001_100;

public class _008_palindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(-333));
    }

    public static boolean isPalindrome(int x) {
        int reversed = reverse(x);

        return x == reversed;
    }

    private static int reverse(int x) {
        if(x == Integer.MIN_VALUE) {
            return 0;
        }

        int digit = 0;
        long sum = 0;
        int sign = x > 0 ? 1 : -1;
        x = Math.abs(x);
        int result = 0;

        while (x >= 10) {
            digit = x % 10;
            sum = (sum + digit) * 10;
            x /= 10;
        }

        sum += x;

        if(sum * sign > Integer.MAX_VALUE || sum * sign < Integer.MIN_VALUE) {
            result = 0;
        } else {
            result = (int)sum * sign;
        }

        return result;
    }
}
