package _201_300;

public class _276_paintFence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Google There is a fence with n posts, each post can be painted with one of
	 * the k colors.
	 * 
	 * You have to paint all the posts such that no more than two adjacent fence
	 * posts have the same color.
	 * 
	 * Return the total number of ways you can paint the fence.
	 * 
	 * Note: n and k are non-negative integers.
	 */
	
	/*
		We divided it into two cases.
	
		the last two posts have the same color, the number of ways to paint in this case is sameColorCounts.
	
		the last two posts have different colors, and the number of ways in this case is diffColorCounts.
	
		The reason why we have these two cases is that we can easily compute both of them, and that is all I do. When adding a new post, we can use the same color as the last one (if allowed) or different color. If we use different color, there're k-1 options, and the outcomes shoule belong to the diffColorCounts category. If we use same color, there's only one option, and we can only do this when the last two have different colors (which is the diffColorCounts). There we have our induction step.
	
		Here is an example, let's say we have 3 posts and 3 colors. The first two posts we have 9 ways to do them, (1,1), (1,2), (1,3), (2,1), (2,2), (2,3), (3,1), (3,2), (3,3). Now we know that
	
		diffColorCounts = 6;
		And
	
		sameColorCounts = 3;
		Now for the third post, we can compute these two variables like this:
	
		If we use different colors than the last one (the second one), these ways can be added into diffColorCounts, so if the last one is 3, we can use 1 or 2, if it's 1, we can use 2 or 3, etc. Apparently there are (diffColorCounts + sameColorCounts) * (k-1) possible ways.
	
		If we use the same color as the last one, we would trigger a violation in these three cases (1,1,1), (2,2,2) and (3,3,3). This is because they already used the same color for the last two posts. So is there a count that rules out these kind of cases? YES, the diffColorCounts. So in cases within diffColorCounts, we can use the same color as the last one without worrying about triggering the violation. And now as we append a same-color post to them, the former diffColorCounts becomes the current sameColorCounts.
	
		Then we can keep going until we reach the n. And finally just sum up these two variables as result.
	
		Hope this would be clearer.
	*/
	
	public int numWays(int n, int k) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return k;
		int diffColorCounts = k * (k - 1);
		int sameColorCounts = k;
		for (int i = 2; i < n; i++) {
			int temp = diffColorCounts;
			diffColorCounts = (diffColorCounts + sameColorCounts) * (k - 1);
			sameColorCounts = temp;
		}
		return diffColorCounts + sameColorCounts;
	}
}


/*
	if (n == 0 || k == 0) return 0;
	if (n == 1) return k;
	// same[i] means the ith post has the same color with the (i-1)th post.
	int[] same = new int[n];
	// diff[i] means the ith post has a different color with the (i-1)th post.
	int[] diff = new int[n];
	same[0] = same[1] = k;
	diff[0] = k;
	diff[1] = k * (k - 1);
	for (int i = 2; i < n; ++i) {
	    same[i] = diff[i-1];
	    diff[i] = (k - 1) * same[i-1] + (k - 1) * diff[i-1];
	}
	return same[n-1] + diff[n-1];
*/

/* ========================*/

/*	Java O(n) runtime, O(1) space
	w(n) number of ways to paint n posts
	
	p(n) color of the nth post
	
	w(n) consists of two cases:
	
	1.p(n) == p(n - 1)
	
	2.p(n) != p(n - 1)
	
	case 2 is easy. for every way of painting all previous (n - 1) posts, you have (k - 1) ways to paint p(n)
	because you can choose k - 1 different color rather than the same color as p(n - 1)
	
	so w(n - 1) * (k - 1)
	
	notice that for p(n) == p(n - 1), p(n - 1) must be not equal to p(n - 2), this is equalvalent to replace n by n - 1
	for the formular above, essentially the same as case2 but for a smaller n.
	so w(n - 1 - 1) * (k - 1)
	
	so w(n) = (k - 1) * (w(n - 1) + w(n - 2))
*/
/*
	public int numWays(int n, int k) {
	    if ((n == 0 || k == 0) || (k == 1 && n >= 3))
	        return 0;
	    int w1 = k;
	    int w2 = k * k;
	    int w3; 
	    if (n == 1)
	        return w1;
	    if (n == 2)
	        return w2;
	    for (int i = 0; i <= n - 3; i++) {
	        w3 = (k - 1) * (w2 + w1);
	        w1 = w2;
	        w2 = w3;
	    }
	    return w2; // wrong if you return w3, w3 may not be initialized.
	}
*/