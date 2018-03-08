package _501_600;

import java.util.PriorityQueue;

public class _505_theMazeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

	Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.

	The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
	
	Example 1: 
	
	Example 2:
	
	Note:
		There is only one ball and one destination in the maze.
		Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
		The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
		The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
	*/

	/*
	We need to use PriorityQueue instead of standard queue, and record the minimal length of each point.
	*/
	
	/*
	Modified 2017/3/27:
		Why using PriorityQueue?

		We can consider this question as a shortest-route graph problem, that is, each stoppable point is a vertical, where every possible path between two nodes is an edge.
		In this way, we can using Dijkstra algorithm to solve this problem, and that's why we use PriorityQueue.
	*/
	
	class Point {
        int x,y,l;
        public Point(int _x, int _y, int _l) {x=_x;y=_y;l=_l;}
    }
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int m=maze.length, n=maze[0].length;
        int[][] length=new int[m][n]; // record length
        for (int i=0;i<m*n;i++) length[i/n][i%n]=Integer.MAX_VALUE;
        int[][] dir=new int[][] {{-1,0},{0,1},{1,0},{0,-1}};
        PriorityQueue<Point> list=new PriorityQueue<>((o1,o2)->o1.l-o2.l); // using priority queue
        list.offer(new Point(start[0], start[1], 0));
        while (!list.isEmpty()) {
            Point p=list.poll();
            if (length[p.x][p.y]<=p.l) continue; // if we have already found a route shorter
            length[p.x][p.y]=p.l;
            for (int i=0;i<4;i++) {
                int xx=p.x, yy=p.y, l=p.l;
                while (xx>=0 && xx<m && yy>=0 && yy<n && maze[xx][yy]==0) {
                    xx+=dir[i][0];
                    yy+=dir[i][1];
                    l++;
                }
                xx-=dir[i][0];
                yy-=dir[i][1];
                l--;
                list.offer(new Point(xx, yy, l));
            }
        }
        return length[destination[0]][destination[1]]==Integer.MAX_VALUE?-1:length[destination[0]][destination[1]];
    }

}
