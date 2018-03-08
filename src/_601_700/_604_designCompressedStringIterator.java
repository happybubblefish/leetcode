package _601_700;

import java.util.LinkedList;
import java.util.Queue;

public class _604_designCompressedStringIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
		Design and implement a data structure for a compressed string iterator. It should support the following operations: next and hasNext.
	
		The given compressed string will be in the form of each letter followed by a positive integer representing the number of this letter existing in the original uncompressed string.
	
		next() - if the original string still has uncompressed characters, return the next letter; Otherwise return a white space.
		hasNext() - Judge whether there is any letter needs to be uncompressed.
	
		Note:
		Please remember to RESET your class variables declared in StringIterator, as static/class variables are persisted across multiple test cases. Please see here for more details.
	
		Example:
	
		StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
	
		iterator.next(); // return 'L'
		iterator.next(); // return 'e'
		iterator.next(); // return 'e'
		iterator.next(); // return 't'
		iterator.next(); // return 'C'
		iterator.next(); // return 'o'
		iterator.next(); // return 'd'
		iterator.hasNext(); // return true
		iterator.next(); // return 'e'
		iterator.hasNext(); // return false
		iterator.next(); // return ' '
	*/
	
	Queue<int[]> queue = new LinkedList<>();
    
    public _604_designCompressedStringIterator(String s) {
        int i = 0, n = s.length();
        while (i < n) {
            int j = i+1;
            while (j < n && s.charAt(j) - 'A' < 0) j++;
            queue.add(new int[]{s.charAt(i) - 'A',  Integer.parseInt(s.substring(i+1, j))});
            i = j;
        }
    }
    
    public char next() {
        if (queue.isEmpty()) return ' ';
        int[] top = queue.peek();
        if (--top[1] == 0) queue.poll();
        return (char) ('A' + top[0]);
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

/*
private String s;
private int cur;
private int next;
private int number;

public StringIterator(String compressedString) {
    this.s = compressedString;
    this.cur = 0;
    this.next = findNext();
    this.number = Integer.parseInt(s.substring(cur + 1, next));
}

public char next() {
    if(number == 0){
        cur = next;
        next = findNext();
        number = cur == next ? 0 : Integer.parseInt(s.substring(cur + 1, next));
    }
    
    if(number != 0){
        number--;
        return s.charAt(cur);
    }else{
        return ' ';
    }
}

public boolean hasNext() {
    if(number == 0){
        cur = next;
        next = findNext();
        number = cur == next ? 0 : Integer.parseInt(s.substring(cur + 1, next));
    }else{
        return true;
    }
    
    if(number == 0){
        return false;
    }else{
        return true;
    }
}

public int findNext(){
    if(cur == s.length()){
        return s.length();
    }
    
    int i = cur + 1;
    while(i < s.length() && Character.isDigit(s.charAt(i))){
        i++;
    }
    return i;
}
*/