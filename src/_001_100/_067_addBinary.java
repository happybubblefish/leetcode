package _001_100;

public class _067_addBinary {
    public static void main(String[] args) {
        String a = "11";
        String b = "11";

        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        if(a == null || a.isEmpty()) {
            return b;
        }

        if(b == null || b.isEmpty()) {
            return a;
        }

        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(indexA >= 0 && indexB >= 0) {
            int digitA = a.charAt(indexA) - '0';
            int digitB = b.charAt(indexB) - '0';

            int sum = digitA + digitB + carry;
            carry = sum / 2;
            sb.insert(0,sum % 2);

            indexA--;
            indexB--;
        }

        while(indexA >= 0) {
            int digit = a.charAt(indexA) - '0';
            int sum = digit + carry;

            carry = sum / 2;
            sb.insert(0, sum % 2);

            indexA--;
        }

        while(indexB >= 0) {
            int digit = b.charAt(indexB) - '0';
            int sum = digit + carry;

            carry = sum / 2;
            sb.insert(0, sum % 2);

            indexB--;
        }

        if(carry == 1) {
            sb.insert(0, 1);
        }

        return sb.toString();
    }
}
