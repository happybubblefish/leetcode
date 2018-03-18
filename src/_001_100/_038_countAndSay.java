package _001_100;

public class _038_countAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }

    public static String countAndSay(int n) {
        if(n == 0) {
            return "";
        }

        if(n == 1) {
            return "1";
        }

        String base = "1";
        StringBuilder sb = new StringBuilder();

        int count = 1;

        while(n > 1) {
            int len = base.length();
            for(int i = 1; i < len; i++) {
                if(base.charAt(i) == base.charAt(i - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(base.charAt(i - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(base.charAt(base.length() - 1));

            base = sb.toString();
            sb = new StringBuilder();
            count = 1;
            n--;
        }

        return base;
    }
}
