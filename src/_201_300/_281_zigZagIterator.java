package _201_300;

import java.util.Iterator;
import java.util.List;

public class _281_zigZagIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	Given two 1d vectors, implement an iterator to return their elements alternately.

			For example, given two 1d vectors:

			v1 = [1, 2]
			v2 = [3, 4, 5, 6]
			By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].

			Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

			Clarification for the follow up question - Update (2015-09-18):
			The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example, given the following input:

			[1,2,3]
			[4,5,6,7]
			[8,9]
			It should return [1,4,8,2,5,9,3,6,7].
	*/
	private Iterator<Integer> i, j, tmp;
	
	public _281_zigZagIterator(List<Integer> v1, List<Integer> v2) {
		this.i = v1.iterator();
		this.j = v2.iterator();
	}

	public int next() {
		if(i.hasNext()) {
			tmp = i;
			i = j;
			j = tmp;
		}
		
		return j.next();
	}

	public boolean hasNext() {
		return this.i.hasNext() || this.j.hasNext();
	}
}

/*  Uses a linkedlist to store the iterators in different vectors. Every time we call next(), we pop an element from the list, and re-add it to the end to cycle through the lists.

	LinkedList<Iterator> list;
	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
	    list = new LinkedList<Iterator>();
	    if(!v1.isEmpty()) list.add(v1.iterator());
	    if(!v2.isEmpty()) list.add(v2.iterator());
	}
	
	public int next() {
	    Iterator poll = list.remove();
	    int result = (Integer)poll.next();
	    if(poll.hasNext()) list.add(poll);
	    return result;
	}
	
	public boolean hasNext() {
	    return !list.isEmpty();
	}
*/