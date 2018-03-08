package _201_300;

import java.util.HashMap;
import java.util.Map;

public class _294_flipGameII {

	public static void main(String[] args) {
		System.out.println(canWin("++-++"));
	}

	/*
	 * You are playing the following Flip Game with your friend: Given a string that
	 * contains only these two characters: + and -, you and your friend take turns
	 * to flip two consecutive "++" into "--". The game ends when a person can no
	 * longer make a move and therefore the other person will be the winner.
	 * 
	 * Write a function to determine if the starting player can guarantee a win.
	 * 
	 * For example, given s = "++++", return true. The starting player can guarantee
	 * a win by flipping the middle "++" to become "+--+".
	 * 
	 * Follow up: Derive your algorithm's runtime complexity.
	 */

//	public boolean canWin(String s) {
//		s = s.replace('-', ' ');
//	    int G = 0;
//	    List<Integer> g = new ArrayList<>();
//	    for (String t : s.split("[ ]+")) {
//	        int p = t.length();
//	        if (p == 0) continue;
//	        while (g.size() <= p) {
//	            char[] x = t.toCharArray();
//	            int i = 0, j = g.size() - 2;
//	            while (i <= j)
//	                x[g.get(i++) ^ g.get(j--)] = '-';
//	            g.add(new String(x).indexOf('+'));
//	        }
//	        G ^= g.get(p);
//	    }
//	    return G != 0;
//	}
	
	private static boolean helper(String s, Map<String, Boolean> map) {
        if(map.containsKey(s)) {
            return map.get(s);
        }
        for(int i=0; i<s.length()-1; i++) {
            if(s.startsWith("++", i)) {
                if(!helper(s.substring(0, i) + "--" + s.substring(i+2), map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
    
    public static boolean canWin(String s) {
        Map<String, Boolean> map = new HashMap<>();
        return helper(s, map);
    }
}

/*
At first glance, backtracking seems to be the only feasible solution to this problem. We can basically try every possible move for the first player (Let's call him 1P from now on), and recursively check if the second player 2P has any chance to win. If 2P is guaranteed to lose, then we know the current move 1P takes must be the winning move. The naive implementation is actually very simple:

int len;
string ss;
bool canWin(string s) {
    len = s.size();
    ss = s;
    return canWin();
}
bool canWin() {
    for (int is = 0; is <= len-2; ++is) {
        if (ss[is] == '+' && ss[is+1] == '+') {
            ss[is] = '-'; ss[is+1] = '-';
            bool wins = !canWin(); 
            ss[is] = '+'; ss[is+1] = '+';
            if (wins) return true;
        }
    }
    return false;
} 
Now let's check the time complexity: Suppose originally the board of size N contains only '+' signs, then roughly we have:

T(N) = (N-2) * T(N-2) = (N-2) * (N-4) * T(N-4) ... = (N-2) * (N-4) * (N-6) * ... ~ O(N!!)
This algorithm can be optimized with memoization. For instance:
https://discuss.leetcode.com/topic/27291/memoization-3150ms-130ms-44ms-python

Can we even do better than that? Sure! Below I'll show the time complexity can be reduced to O(N^2) using Dynamic Programming, but the improved method requires some non-trivial understanding of the game theory, and therefore is not expected in a real interview. If you are not interested, please simply skip the rest of the article:

Concept 1 (Impartial Game): Given a particular arrangement of the game
board, if either player have exactly the same set of moves should he
move first, and both players have exactly the same winning condition,
then this game is called impartial game. For example, chess is not
impartial because the players can control only their own pieces, and
the +- flip game, on the other hand, is impartial.
--

Concept 2 (Normal Play vs Misere Play): If the winning condition of
the game is that the opponent has no valid moves, then this game is
said to follow the normal play convention; if, alternatively, the
winning condition is that the player himself has no valid moves, then
the game is a Misere game. Our +- flip has apprently normal play.
Now we understand the the flip game is an impartial game under normal play. Luckily, this type of game has been extensively studied. Note that our following discussion only applies to normal impartial games.

In order to simplify the solution, we still need to understand one more concept:

Concept 3 (Sprague-Grundy Function): Suppose x represents a particular
arrangement of board, and x_0, x_1, x_2, ... ,x_k represent the board
after a valid move, then we define the Sprague-Grundy function as:
 g(x) = FirstMissingNumber(g(x_0), g(x_1), g(x_2), ... , g(x_k)). 
where FirstMissingNumber(y) stands for the smallest positive number
that is not in set y. For instance, if g(x_0) = 0, g(x_1) = 0, g(x_k) =
2, then g(x) = FMV({0, 0, 2}) = 1.
Why do we need this bizarre looking S-G function? Because we can instantly decide whether 1P has a winning move simply by looking at its value. I don't want to write a book out of it, so for now, please simply take the following theorem for granted:

Theorem 1: If g(x) != 0, then 1P must have a guaranteed winning move
from board state x. Otherwise, no matter how 1P moves, 2P must then
have a winning move.
So our task now is to calculate g(board). But how to do that? Let's first of all find a way to numerically describe the board. Since we can only flip ++ to --, then apparently, we only need to write down the lengths of consecutive ++'s of length >= 2 to define a board. For instance, ++--+-++++-+----- can be represented as (2, 4).

(2, 4) has two separate '+' subsequences. Any operation made on one subsequence does not interfere with the state of the other. Therefore, we say (2, 4) consists of two subgames: (2) and (4).

Okay now we are only one more theorem away from the solution. This is the last theorem. I promise:

Theorem 2 (Sprague-Grundy Theorem): The S-G function of game x = (s1,
s2, ..., sk) equals the XOR of all its subgames s1, s2, ..., sk. e.g.
g((s1, s2, s3)) = g(s1) XOR g(s2) XOR g(s3).
With the S-G theorem, we can now compute any arbitrary g(x). If x contains only one number N (there is only one '+' subsequence), then

g(x) = FMV(g(0, N-2), g(1, N-3), g(2, N-4), ... , g(N/2-1, N-N/2-2));
     = FMV(g(0)^g(N-2), g(1)^g(N-3), g(2)^g(N-4)), ... g(N/2-1, N-N/2-2));
Now we have the whole algorithm:

Convert the board to numerical representation: x = (s1, s2, ..., sk)
Calculate g(0) to g(max(si)) using DP.
if g(s1)^g(s2)^...^g(sk) != 0 return true, otherwise return false.
Calculating g(N) takes O(N) time (N/2 XOR operations plus the O(N) First Missing Number algorithm). And we must calculate from g(1) all the way to g(N). So overall, the algorithm has an O(N^2) time complexity.

Naturally, the code is bit more complicated than the backtracking version. But it reduces the running time from ~128ms to less than 1ms.
*/

/*
class Solution {
    
    这道题其实不用考虑奇偶层，
    直接利用下一层的recursion。
    如果下一层recursion必输，则代表当前情况本轮操作者有必赢策略
    如果找不到必赢策略，则代表本轮操作者必输
    这样的time
    
    private boolean helper(String s, Map<String, Boolean> map) {
        if(map.containsKey(s)) {
            return map.get(s);
        }
        for(int i=0; i<s.length()-1; i++) {
            if(s.startsWith("++", i)) {
                if(!helper(s.substring(0, i) + "--" + s.substring(i+2), map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
    
    public boolean canWin(String s) {
        Map<String, Boolean> map = new HashMap<>();
        return helper(s, map);
    }
}

*/

/*
class Solution {
    Map<String, Boolean> map;
    
    public boolean canWin(String s) {
        map = new HashMap<>();
        return helper(s);
    }
    
    private boolean helper(String s) {
        if (s == null || s.length() == 0) return false;
        
        if (map.containsKey(s)) return map.get(s);
        for (int i = 0; i < s.length()-1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i+1) == '+') {
                String ns = s.substring(0, i) + "--" + s.substring(i+2);
                if (!helper(ns)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}
*/