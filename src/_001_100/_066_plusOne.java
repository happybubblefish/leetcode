package _001_100;

public class _066_plusOne {
    public static void main(String[] args) {
        int[] digits = { 9, 9, 9 };

        int[] res = plusOne(digits);

        for(int i : res) {
            System.out.print(i + " ");
        }
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        int carry = 1;

        for(int i = len - 1; i >= 0; i--) {
            int sum = digits[i] + carry;
            carry = sum / 10;
            digits[i] = sum % 10;
        }

        if(carry == 1) {
            int[] temp = new int[len + 1];
            temp[0] = 1;
            int index = 1;

            for(int i = 0; i < len; i++) {
                temp[index++] = digits[i];
            }

            digits = temp;
        }

        return digits;
    }
}
