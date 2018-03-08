package _201_300;

import java.util.Arrays;

public class _261_graphValidTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*	Google, Facebook, Zenefits
		Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
	
		For example:
	
		Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
	
		Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
	
		Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
	*/

	//Union find
	public boolean validTree(int n, int[][] edges) {
		// initialize n isolated islands
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            
            // union
            nums[x] = y;
        }
        
        return edges.length == n - 1;
	}
	
	
	int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
}

/*
 * DFS
	public boolean validTree(int n, int[][] edges) {
	    // initialize adjacency list
	    List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);
	    
	    // initialize vertices
	    for (int i = 0; i < n; i++)
	        adjList.add(i, new ArrayList<Integer>());
	    
	    // add edges    
	    for (int i = 0; i < edges.length; i++) {
	        int u = edges[i][0], v = edges[i][1];
	        adjList.get(u).add(v);
	        adjList.get(v).add(u);
	    }
	    
	    boolean[] visited = new boolean[n];
	    
	    // make sure there's no cycle
	    if (hasCycle(adjList, 0, visited, -1))
	        return false;
	    
	    // make sure all vertices are connected
	    for (int i = 0; i < n; i++) {
	        if (!visited[i]) 
	            return false;
	    }
	    
	    return true;
	}
	
	// check if an undirected graph has cycle started from vertex u
	boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
	    visited[u] = true;
	    
	    for (int i = 0; i < adjList.get(u).size(); i++) {
	        int v = adjList.get(u).get(i);
	        
	        if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList, v, visited, u)))
	            return true;
	    }
	    
	    return false;
	}
*/

/* BFS
	public boolean validTree(int n, int[][] edges) {
	    int[] visited = new int[n];
	    List<List<Integer>> adjList = new ArrayList<>();
	    for (int i=0; i<n; ++i) { adjList.add(new ArrayList<Integer>()); }
	    for (int[] edge: edges) {
	        adjList.get(edge[0]).add(edge[1]);
	        adjList.get(edge[1]).add(edge[0]);
	    }
	    Deque<Integer> q = new ArrayDeque<>();
	    q.addLast(0); visited[0] = 1;  // vertex 0 is in the queue, being visited
	    while (!q.isEmpty()) {
	        Integer cur = q.removeFirst();
	        for (Integer succ: adjList.get(cur)) {
	            if (visited[succ] == 1) { return false; }  // loop detected
	            if (visited[succ] == 0) { q.addLast(succ); visited[succ] = 1; }
	        }
	        visited[cur] = 2;  // visit completed
	    }
	    for (int v: visited) { if (v == 0) { return false; } }  // # of connected components is not 1
	    return true;
	}
*/
