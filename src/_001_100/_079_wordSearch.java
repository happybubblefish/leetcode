package _001_100;

public class _079_wordSearch {
    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        System.out.println(exist(board, "SEE"));
    }

    public static boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(helper(board, i, j, word, 0, visited)){
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean helper(char[][] board, int i, int j, String word, int start, boolean[][] visited) {
        if(start == word.length()) {
            return true;
        }

        if(i < 0 || i >= board.length) {
            return false;
        }

        if(j < 0 || j >= board[0].length) {
            return false;
        }

        if(word.charAt(start) != board[i][j]) {
            return false;
        }

        if(visited[i][j]) {
            return false;
        }

        visited[i][j] = true;

        boolean result = helper(board, i + 1, j, word, start + 1, visited) ||
                helper(board, i - 1, j, word, start + 1, visited) ||
                helper(board, i, j + 1, word, start + 1, visited) ||
                helper(board, i, j - 1, word, start + 1, visited);

        visited[i][j] = false;

        return result;
     }
}
