package _001_100;

import java.util.ArrayList;
import java.util.List;

public class _089_grayCode {
    public static void main(String[] args) {
        List<Integer> res = grayCode(2);

        for(Integer i : res) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> grayCode(int n) {
        int count = (int)Math.pow(2, n);
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            list.add(i ^ (i >> 1));
        }

        return list;
    }
}
