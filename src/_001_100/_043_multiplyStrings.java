package _001_100;

public class _043_multiplyStrings {
    public static void main(String[] args) {
        String num1 = "78";
        String num2 = "0";

        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] result = new int[len1 + len2];

        for(int i = len1 - 1; i >= 0; i--) {
            for(int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + result[p2];

                result[p1] += sum / 10;
                result[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < len1 + len2; i++) {
            if(sb.length() == 0 && result[i] == 0) {
                continue;
            }

            sb.append(result[i]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
