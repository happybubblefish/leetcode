package _101_200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _127_wordLadder {

	public static void main(String[] args) {
		List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
		
		System.out.println(ladderLength("hit", "cog", wordList));
	}

	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<>();
		
		for(String w : wordList) {
			dict.add(w);
		}
		
		if(beginWord.equals(endWord)) {
			return 1;
		}
		
		Set<String> visited = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		
		visited.add(beginWord);
		queue.offer(beginWord);
		int len = 1;
		
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			
			len++;
			for(int i = 0; i < queueSize; i++) {
				String word = queue.poll();
				
				List<String> nextWords = getNextWordList(dict, word);
				
				for(String w : nextWords) {
					if(visited.contains(w)) {
						continue;
					}
					
					if(w.equals(endWord)) {
						return len;
					}
					
					visited.add(w);
					queue.offer(w);
				}
			}
		}
		
		return 0;
	}

	private static List<String> getNextWordList(Set<String> dict, String word) {
		List<String> res = new ArrayList<>();
		int len = word.length();
		char[] chs = word.toCharArray();
		
		for(char i = 'a'; i <= 'z'; i++) {
			for(int j = 0; j < len; j++) {
				if(i == chs[j]) continue;
				
				chs[j] = i;
				
				String nextWord = new String(chs);
				chs = word.toCharArray();;
				if(dict.contains(nextWord)) {
					res.add(nextWord);
				}
			}
		}
		
		return res;
	}
}
