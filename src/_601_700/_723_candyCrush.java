package _601_700;

import java.util.HashSet;
import java.util.Set;

public class _723_candyCrush {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		This question is about implementing a basic elimination algorithm for Candy Crush.
	
		Given a 2D integer array board representing the grid of candy, different positive integers board[i][j] represent different types of candies. A value of board[i][j] = 0 represents that the cell at position (i, j) is empty. The given board represents the state of the game following the player's move. Now, you need to restore the board to a stable state by crushing candies according to the following rules:
	
		If three or more candies of the same type are adjacent vertically or horizontally, "crush" them all at the same time - these positions become empty.
		After crushing all candies simultaneously, if an empty space on the board has candies on top of itself, then these candies will drop until they hit a candy or bottom at the same time. (No new candies will drop outside the top boundary.)
		After the above steps, there may exist more candies that can be crushed. If so, you need to repeat the above steps.
		If there does not exist more candies that can be crushed (ie. the board is stable), then return the current board.
		You need to perform the above rules until the board becomes stable, then return the current board.
	
		Example 1:
		
		
		Note:
			The length of board will be in the range [3, 50].
			The length of board[i] will be in the range [3, 50].
			Each board[i][j] will initially start as an integer in the range [1, 2000].
	*/
	
	/*
		The idea is not to count how many same "candies" are in a row or column, but to check if this candy is eligible for crushing. If any candy is eligible, store the corresponding coordinates in a HashSet.
		After traversing the whole board, set the valid candies to "0" then crush (using 2-pointer method in a column).
		Here goes the code:
	*/
	
	public int[][] candyCrush(int[][] board) {
        Set<Coordinates> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int cur = board[i][j];
                if (cur == 0) continue;
                if ((i - 2 >= 0 && board[i - 1][j] == cur && board[i - 2][j] == cur) ||                                                 // check left 2 candies
                   (i + 2 <= board.length - 1 && board[i + 1][j] == cur && board[i + 2][j] == cur) ||                                   // check right 2 candies
                   (j - 2 >= 0 && board[i][j - 1] == cur && board[i][j - 2] == cur) ||                                                 // check 2 candies top
                   (j + 2 <= board[i].length - 1 && board[i][j + 1] == cur && board[i][j + 2] == cur) ||                               // check 2 candies below
                   (i - 1 >= 0 && i + 1 <= board.length - 1 && board[i - 1][j] == cur && board[i + 1][j] == cur) ||                    // check if it is a mid candy in row
                   (j - 1 >= 0 && j + 1 <= board[i].length - 1 && board[i][j - 1] == cur && board[i][j + 1] == cur)) {                // check if it is a mid candy in column
                    set.add(new Coordinates(i, j));
                }
            }
        }
        if (set.isEmpty()) return board;      //stable board
        for (Coordinates c : set) {
            int x = c.i;
            int y = c.j;
            board[x][y] = 0;      // change to "0"
        }
        drop(board);
        return candyCrush(board);
    }
    private void drop(int[][] board) {                                          // using 2-pointer to "drop"
        for (int j = 0; j < board[0].length; j++) {
            int bot = board.length - 1;
            int top = board.length - 1;
            while (top >= 0) {
                if (board[top][j] == 0) {
                    top--;
                }
                else {
                    board[bot--][j] = board[top--][j];
                }
            }
            while (bot >= 0) {
                board[bot--][j] = 0;
            }
        }
    }
}

class Coordinates {
    int i;
    int j;
    Coordinates(int x, int y) {
        i = x;
        j = y;
    }
}

/*
public int[][] candyCrush(int[][] board) {
    boolean change = true;
    while (change) {
        change = reduce(board);
    }
    return board;
}

private boolean reduce(int[][] b) {
    boolean res = false;
    int m = b.length;
    int n = b[0].length;
    boolean[][] zero = new boolean[m][n];
    for (int i = 0; i < b.length; i++) {
        int[] r = b[i];
        for (int x = 0; x + 2 < n; x++) {
            if (r[x] > 0 && r[x] == r[x + 1] && r[x + 1] == r[x + 2]) {
                zero[i][x] = zero[i][x + 1] = zero[i][x + 2] = true;
                res = true;
            }
        }
    }
    for (int i = 0; i < n; i++) {
        for (int x = 0; x + 2 < m; x++) {
            if (b[x][i] > 0 && b[x][i] == b[x + 1][i] && b[x + 1][i] == b[x + 2][i]) {
                zero[x][i] = zero[x + 1][i] = zero[x + 2][i] = true;
                res = true;
            }
        }
    }
    if (!res) {
        return false;
    }
    // drop
    for (int i = 0; i < n; i++) {
        int c = m - 1;
        for (int j = m - 1; j >= 0; j--) {
            if (!zero[j][i]) {
                b[c][i] = b[j][i];
                c--;
            }
        }
        while (c >= 0) {
            b[c][i] = 0;
            c--;
        }
    }
    return true;
}
*/