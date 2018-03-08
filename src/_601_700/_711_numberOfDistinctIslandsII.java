package _601_700;

public class _711_numberOfDistinctIslandsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
	
		Count the number of distinct islands. An island is considered to be the same as another if they have the same shape, or have the same shape after rotation (90, 180, or 270 degrees only) or reflection (left/right direction or up/down direction).
	
		Example 1:
		11000
		10000
		00001
		00011
		Given the above grid map, return 1. 
	
		Notice that:
		11
		1
		and
		 1
		11
		are considered same island shapes. Because if we make a 180 degrees clockwise rotation on the first island, then two islands will have the same shapes.
		Example 2:
		11100
		10001
		01001
		01110
		Given the above grid map, return 2.
	
		Here are the two distinct islands:
		111
		1
		and
		1
		1
	
		Notice that:
		111
		1
		and
		1
		111
		are considered same island shapes. Because if we flip the first array in the up/down direction, then they have the same shapes.
		Note: The length of each dimension in the given grid does not exceed 50.
	*/
	
	/*
		Consise C++ solution, using DFS +sorting to find canonical representation for each island
		After we get coordinates for an island, compute all possible rotations/reflections (https://en.wikipedia.org/wiki/Dihedral_group) of it and then sort them using the default comparison. The first representation in this order is then the canonical one.
	
		class Solution {
		public:
		    map<int, vector<pair<int,int>>> mp;
		    
		    void dfs(int r, int c, vector<vector<int>> &g, int cnt) {
		        if ( r < 0 || c < 0 || r >= g.size() || c >= g[0].size()) return;
		        if (g[r][c] != 1) return;
		        g[r][c] = cnt;
		        mp[cnt].push_back({r,c});
		        dfs(r+1,c,g,cnt);
		        dfs(r-1,c,g,cnt);
		        dfs(r,c+1,g,cnt);
		        dfs(r,c-1,g,cnt);
		    }
		    
		    vector<pair<int,int>> norm(vector<pair<int,int>> v) {
		        vector<vector<pair<int,int>>> s(8);
		        // compute rotations/reflections.
		        for (auto p:v) {
		            int x = p.first, y = p.second;
		            s[0].push_back({x,y});
		            s[1].push_back({x,-y});
		            s[2].push_back({-x,y});
		            s[3].push_back({-x,-y});
		            s[4].push_back({y,-x});
		            s[5].push_back({-y,x});
		            s[6].push_back({-y,-x});
		            s[7].push_back({y,x});
		        }
		        for (auto &l:s) sort(l.begin(),l.end());
		        for (auto &l:s) {
		            for (int i = 1; i < v.size(); ++i) 
		                l[i] = {l[i].first-l[0].first, l[i].second - l[0].second};
		            l[0] = {0,0};
		        }
		        sort(s.begin(),s.end());
		        return s[0];
		    }
		    
		    int numDistinctIslands2(vector<vector<int>>& g) {
		        int cnt = 1;
		        set<vector<pair<int,int>>> s;
		        for (int i = 0; i < g.size(); ++i) for (int j = 0; j < g[i].size(); ++j) if (g[i][j] == 1) {
		            dfs(i,j,g, ++cnt);
		            s.insert(norm(mp[cnt]));
		        }
		        
		        return s.size();
		    }
		};
	*/
}