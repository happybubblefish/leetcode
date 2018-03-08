package _301_400;

public class _323_numberOfConnectedComponentsInAnUndirectedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*	Google, Twitter
		Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
	
		Example 1:
		     0          3
		     |          |
		     1 --- 2    4
		Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
	
		Example 2:
		     0           4
		     |           |
		     1 --- 2 --- 3
		Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
	
		Note:
		You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
	*/
	
	/*
		This is 1D version of Number of Islands II. For more explanations, check out this 2D Solution.
	
		n points = n islands = n trees = n roots.
		With each edge added, check which island is e[0] or e[1] belonging to.
		If e[0] and e[1] are in same islands, do nothing.
		Otherwise, union two islands, and reduce islands count by 1.
		Bonus: path compression can reduce time by 50%.
	*/
	
//	The complexity for M quick union + path compression on N objects should be N + MlgN, I think in this problem, M = 2E, N = V, so O(V + 2ElgV)
	public int countComponents(int n, int[][] edges) {
	    int[] roots = new int[n];
	    for(int i = 0; i < n; i++) roots[i] = i; 

	    for(int[] e : edges) {
	        int root1 = find(roots, e[0]);
	        int root2 = find(roots, e[1]);
	        if(root1 != root2) {      
	            roots[root1] = root2;  // union
	            n--;
	        }
	    }
	    return n;
	}

	public int find(int[] roots, int id) {
	    while(roots[id] != id) {
	        roots[id] = roots[roots[id]];  // optional: path compression
	        id = roots[id];
	    }
	    return id;
	}
}
