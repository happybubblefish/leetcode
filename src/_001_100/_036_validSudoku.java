package _001_100;

import java.util.HashMap;
import java.util.Map;

public class _036_validSudoku {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        if(board.length != 9 || board[0].length != 9) {
            return false;
        }

        Map<Character, Boolean> map = new HashMap<>();
        map = reset(map);

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(map.containsKey(board[i][j])) {
                    if(map.get(board[i][j])) {
                        return false;
                    }
                    map.put(board[i][j], true);
                } else {
                    return false;
                }
            }
        }

        map = reset(map);

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(map.containsKey(board[j][i])) {
                    if(map.get(board[j][i])) {
                        return false;
                    }
                    map.put(board[j][i], true);
                } else {
                    return false;
                }
            }
        }

        map = reset(map);

        for(int i = 0; i / 3 < 3; i++) {
            for(int j = 0; j / 3 < 3; j++) {
                if(map.containsKey(board[i][j])){

                }
            }
        }

        return false;
    }

    private Map<Character,Boolean> reset(Map<Character, Boolean> map) {
        map = new HashMap<Character, Boolean>(){{
            put('1', false);
            put('2', false);
            put('3', false);
            put('4', false);
            put('5', false);
            put('6', false);
            put('7', false);
            put('8', false);
            put('9', false);
        }};

        return map;
    }
}
