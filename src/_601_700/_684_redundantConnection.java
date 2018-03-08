package _601_700;

public class _684_redundantConnection {

	public static void main(String[] args) {
		int[][] edges = {
//				[[1,2], [2,3], [3,4], [1,4], [1,5]]
//			{1, 2}, {1, 3}, {2, 3}
			{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}
		};
		
		int[] res = findRedundantConnection(edges);
		
		for(int r : res) {
			System.out.print(r + " ");
		}
	}

	public static int[] findRedundantConnection(int[][] edges) {
		int[] root = new int[2001];
		for(int i = 0; i < root.length; i++) {
			root[i] = i;
		}
		
		for(int[] edge : edges) {
			int x = find(root, edge[0]);
			int y = find(root, edge[1]);
			
			if(x == y) {
				return edge;
			} else {
				root[find(root, x)] = find(root, y);
			}
		}
		
		return new int[2];
	}

	private static int find(int[] root, int i) {
		while(root[i] != i) {
			i = root[i];
		}
		
		return i;
	}
}
