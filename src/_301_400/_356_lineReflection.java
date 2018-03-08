package _301_400;

import java.util.HashSet;

public class _356_lineReflection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
	
		Example 1:
		Given points = [[1,1],[-1,1]], return true.
	
		Example 2:
		Given points = [[1,1],[-1,-1]], return false.
	
		Follow up:
		Could you do better than O(n2)?
	
		Credits:
		Special thanks to @memoryless for adding this problem and creating all test cases.
	*/
	
	public boolean isReflected(int[][] points) {
		int max = Integer.MIN_VALUE;
	    int min = Integer.MAX_VALUE;
	    HashSet<String> set = new HashSet<>();
	    for(int[] p:points){
	        max = Math.max(max,p[0]);
	        min = Math.min(min,p[0]);
	        String str = p[0] + "a" + p[1];
	        set.add(str);
	    }
	    int sum = max+min;
	    for(int[] p:points){
	        //int[] arr = {sum-p[0],p[1]};
	        String str = (sum-p[0]) + "a" + p[1];
	        if( !set.contains(str))
	            return false;
	        
	    }
	    return true;
	}
}

/*
	class Solution {
	    public boolean isReflected(int[][] points) {
	        if (points == null || points.length == 0) {
	            return true;
	        }
	        int max = Integer.MIN_VALUE;
	        int min = Integer.MAX_VALUE;
	        for (int[] p : points) {
	            max = Math.max(max, p[0]);
	            min = Math.min(min, p[0]);
	        }
	        double mid = (max + min) * 0.5;
	        
	        Arrays.sort(points, new Comparator<int[]>() {
	            public int compare(int[] a, int[] b) {
	                if (a[0] != b[0]) {
	                    return a[0] - b[0];
	                }
	                if (a[0] * 1.0 > mid) {
	                    return a[1] - b[1];
	                } else if (a[0] * 1.0 < mid) {
	                    return b[1] - a[1];
	                } else {
	                    return 0;
	                }
	            }
	        });
	
	        // System.out.println(mid);
	        
	        int start = 0;
	        int end = points.length - 1;
	        
	        while (start < end) {
	            int[] p1 = points[start];
	            int[] p2 = points[end];
	            if ((points[start][0] * 1.0 == mid) || start != 0 && compare(points[start], points[start - 1])) {
	                start++;
	                continue;
	            }
	            if ((points[end][0] * 1.0 == mid) || end != points.length - 1 && compare(points[end], points[end + 1])) {
	                end--;
	                continue;
	            }
	            if ((p1[0] + p2[0]) * 1.0 == 2 * mid && p1[1] == p2[1]) {
	                start++;
	                end--;
	                continue;
	            } else {
	                return false;
	            }
	        }
	        
	        
	        if (start == end) {
	            for (int k = 0; k < points.length; k++) {
	                if (k == start) {continue;}
	                if (compare(points[k], points[start])) {return true;}
	            }
	            return points[start][0] == mid;
	        }
	        
	        return true;
	    }
	    public boolean compare(int[] p1, int[] p2) {
	        if (p1[0] == p2[0] && p1[1] == p2[1]) {
	            return true;
	        }
	        return false;
	    }
	}
*/