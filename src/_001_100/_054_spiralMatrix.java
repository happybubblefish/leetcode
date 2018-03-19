package _001_100;

import java.util.ArrayList;
import java.util.List;

public class _054_spiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                { 6, 9, 7 }
        };

        List<Integer> res = spiralOrder(matrix);

        for(Integer i : res) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if(matrix == null || matrix.length == 0) {
            return res;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int rowBegin = 0;
        int rowEnd = rows - 1;
        int colBegin = 0;
        int colEnd = cols - 1;
        int index = 0;

        while(rowBegin <= rowEnd && colBegin <= colEnd) {
            while(index <= colEnd) {
                res.add(matrix[rowBegin][index++]);
            }
            rowBegin++;

            index = rowBegin;
            while(index <= rowEnd) {
                res.add(matrix[index++][colEnd]);
            }
            colEnd--;

            index = colEnd;
            if(rowBegin <= rowEnd) {
                while (index >= colBegin) {
                    res.add(matrix[rowEnd][index--]);
                }
            }

            rowEnd--;
            index = rowEnd;

            if(colBegin <= colEnd) {
                while (index >= rowBegin) {
                    res.add(matrix[index--][colBegin]);
                }
            }

            colBegin++;
            index = colBegin;
        }

        return res;
    }
}
