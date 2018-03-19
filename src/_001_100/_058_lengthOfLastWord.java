package _001_100;

public class _058_lengthOfLastWord {
    public static void main(String[] args) {
        String s = "12 3";

//        System.out.println(s.charAt(s.length() - 1) == ' ');

        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int len = s.length();
        int count = 0;
        boolean flag = false;

        for(int i = len - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if(ch != ' ') {
                count++;
            } else if(count != 0) {
                break;
            }
        }

        return count;
    }
}
