package _001_100;

import java.util.HashMap;
import java.util.Map;

public class _012_integerToRoman {
    public static void main(String[] args) {
        System.out.println(intToRoman(1914));
    }

    public static String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<Integer, String>(){{
            put(1, "I");
            put(4, "IV");
            put(5, "V");
            put(9, "IX");
            put(10, "X");
            put(40, "XL");
            put(50, "L");
            put(90, "XC");
            put(100, "C");
            put(400, "CD");
            put(500, "D");
            put(900, "CM");
            put(1000, "M");
        }};

        int[] romanNumbers = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        StringBuilder sb = new StringBuilder();
        int x = num;
        int mod = num;

        for(int i = 0; i < romanNumbers.length; i++) {
            x = mod / romanNumbers[i];
            mod = mod % romanNumbers[i];

            while(x >= 1) {
                sb.append(map.get(romanNumbers[i]));
                x--;
            }
        }

//        if(mod != 0){
//            sb.append(map.get(mod));
//        }


//        mod = x % 1000;
//        x = x / 1000;
//
//        while(x >= 1) {
//            sb.append("M");
//            x--;
//        }
//
//        x = mod / 500;
//        mod = mod % 500;
//
//        while(x >= 1) {
//            sb.append("D");
//            x--;
//        }
//
//        x = mod / 100;
//        mod = mod % 100;
//
//        while(x >= 1) {
//            sb.append("C");
//            x--;
//        }
//
//        x = mod / 50;
//        mod = mod % 50;
//
//        while(x >= 1) {
//            sb.append("L");
//            x--;
//        }
//
//        x = mod / 10;
//        mod = mod % 10;
//
//        while(x >= 1) {
//            sb.append("X");
//            x--;
//        }
//
//        if(mod != 0) {
//            sb.append(map.get(mod));
//        }

        return sb.toString();
    }
}
