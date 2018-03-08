package _201_300;

import java.util.LinkedList;
import java.util.Queue;

public class _286_wallsAndGates {

	public static void main(String[] args) {
		int[][] rooms = { 
				{ 0,0,0,0,2147483647,2147483647 },
				{ -1,0,-1,2147483647,0,-1 },
				{ -1,-1,0,0,2147483647,0 }, 
				{ -1,-1,2147483647,2147483647,2147483647,-1 },
				{ 2147483647,2147483647,-1,2147483647,-1,2147483647 },
				{ 2147483647,2147483647,0,-1,-1,0 },
				{ 0,0,0,2147483647,-1,0 },
				{ 0,-1,0,-1,0,0 },
				{ 2147483647,0,-1,-1,2147483647,2147483647 },
				{ 0,0,-1,-1,-1,2147483647 }
		};

		wallsAndGates(rooms);

		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				System.out.print(rooms[i][j] + "\t");
			}

			System.out.println();
		}
	}

	/*
	 * You are given a m x n 2D grid initialized with these three possible values.
	 * 
	 * -1 - A wall or an obstacle. 0 - A gate. INF - Infinity means an empty room.
	 * We use the value 231 - 1 = 2147483647 to represent INF as you may assume that
	 * the distance to a gate is less than 2147483647. Fill each empty room with the
	 * distance to its nearest gate. If it is impossible to reach a gate, it should
	 * be filled with INF.
	 * 
	 * For example, given the 2D grid: INF -1 0 INF INF INF INF -1 INF -1 INF -1 0
	 * -1 INF INF After running your function, the 2D grid should be: 3 -1 0 1 2 2 1
	 * -1 1 -1 2 -1 0 -1 3 4
	 * 
	 */

	/*
	 * Push all gates into queue first. Then for each gate update its neighbor cells
	 * and push them to the queue.
	 * 
	 * Repeating above steps until there is nothing left in the queue.
	 */
	public static void wallsAndGates(int[][] rooms) {
		if (rooms == null || rooms.length == 0) {
			return;
		}

		Queue<Integer[]> queue = new LinkedList<>();
		int rows = rooms.length;
		int cols = rooms[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (rooms[i][j] == 0) {
					Integer[] gate = { i, j };
					queue.offer(gate);
				}
			}
		}

		while (!queue.isEmpty()) {
			Integer[] square = queue.poll();
			int row = square[0];
			int col = square[1];

			if (isValid(row - 1, col, rooms)) {
				helper(row, col, row - 1, col, rooms, queue);
			}

			if (isValid(row, col - 1, rooms)) {
				helper(row, col, row, col - 1, rooms, queue);
			}

			if (isValid(row + 1, col, rooms)) {
				helper(row, col, row + 1, col, rooms, queue);
			}

			if (isValid(row, col + 1, rooms)) {
				helper(row, col, row, col + 1, rooms, queue);
			}
		}
	}

	private static boolean isValid(Integer row, Integer col, int[][] rooms) {
		if (row < 0 || row >= rooms.length) {
			return false;
		}

		if (col < 0 || col >= rooms[0].length) {
			return false;
		}

		return true;
	}

	// no need to check Math.min, since if the value is less than Integer.MAX_VALUE, then it has been visited from other gate, which is early than from current gate
	private static void helper(int row, int col, int newRow, int newCol, int[][] rooms, Queue<Integer[]> queue) {
		if (rooms[newRow][newCol] == Integer.MAX_VALUE) {
			rooms[newRow][newCol] = rooms[row][col] + 1;
			System.out.println(newRow + " --- " + newCol + ": " + rooms[newRow][newCol]);
			queue.offer(new Integer[] { newRow, newCol });
		}
	}
}
