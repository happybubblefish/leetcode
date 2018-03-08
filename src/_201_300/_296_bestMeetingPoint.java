package _201_300;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _296_bestMeetingPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

		For example, given three people living at (0,0), (0,4), and (2,2):

		1 - 0 - 0 - 0 - 1
		|   |   |   |   |
		0 - 0 - 0 - 0 - 0
		|   |   |   |   |
		0 - 0 - 1 - 0 - 0
		The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
	*/
	
//	1 traverse + 2 sorts + 2 traverses = 3mn + 2mn log(mn)
	public int minTotalDistance(int[][] grid) {
	    int m = grid.length;
	    int n = grid[0].length;
	    
	    List<Integer> I = new ArrayList<>(m);
	    List<Integer> J = new ArrayList<>(n);
	    
	    for(int i = 0; i < m; i++){
	        for(int j = 0; j < n; j++){
	            if(grid[i][j] == 1){
	                I.add(i);
	                J.add(j);
	            }
	        }
	    }
	    
	    return getMin(I) + getMin(J);
	}

	private int getMin(List<Integer> list){
	    int ret = 0;
	    
	    Collections.sort(list);
	    
	    int i = 0;
	    int j = list.size() - 1;
	    while(i < j){
	        ret += list.get(j--) - list.get(i++);
	    }
	    
	    return ret;
	}
}

/*
 //2 traverses + 2 traverses = 4mn
  
public int minTotalDistance(int[][] grid) {
    int m = grid.length, n = grid[0].length;

    List<Integer> I = new ArrayList<Integer>();
    List<Integer> J = new ArrayList<Integer>();
    
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (grid[i][j] == 1) {
                I.add(i);
            }
        }
    }
    for (int j = 0; j < n; j++) {
        for (int i = 0; i < m; i ++) {
            if (grid[i][j] == 1) {  
                J.add(j);
            }
        }
    }
    return minTotalDistance(I) + minTotalDistance(J);
}

public int minTotalDistance(List<Integer> grid) {
    int i = 0, j = grid.size() - 1, sum = 0;
    while (i < j) {
        sum += grid.get(j--) - grid.get(i++);
    }
    return sum;
}
*/

/*
	As long as you have different numbers of people on your left and on your right, moving a little to the side with more people decreases the sum of distances. So to minimize it, you must have equally many people on your left and on your right.
	*/

/*
public int minTotalDistance(int[][] grid) {
    int[] row = new int[grid.length];
    int[] col = new int[grid[0].length];
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[i][j] > 0) {
                row[i]++;
                col[j]++;
            }
        }
    }
    return getDistance(row) + getDistance(col);
}

private int getDistance(int[] nums) {
    int dis = 0;
    int left = nums[0];
    int right = nums[nums.length - 1];
    int i = 0;
    int j = nums.length - 1;
    while (i < j) {
        if (left < right) {
            dis += left;
            i++;
            left += nums[i];
        } else {
            dis += right;
            j--;
            right += nums[j];
        }
    }
    return dis;
}
*/