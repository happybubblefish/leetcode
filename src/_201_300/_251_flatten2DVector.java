package _201_300;

import java.util.Iterator;
import java.util.List;

public class _251_flatten2DVector implements Iterator<Integer> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Implement an iterator to flatten a 2d vector.
	 * 
	 * For example, Given 2d vector =
	 * 
	 * [ [1,2], [3], [4,5,6] ] By calling next repeatedly until hasNext returns
	 * false, the order of elements returned by next should be: [1,2,3,4,5,6].
	 * 
	 * Follow up: As an added challenge, try to code it using only iterators in C++
	 * or iterators in Java.
	 */

	private Iterator<List<Integer>> i;
	private Iterator<Integer> j;
	public _251_flatten2DVector(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

	@Override
	public Integer next() {
		hasNext();
		
		return j.next();
	}

	@Override
	public boolean hasNext() {
		while(i.hasNext() && (j == null || !j.hasNext())) {
			j = i.next().iterator();
		}
		
		return (j != null) && (j.hasNext());
	}
	
	/**
	 * Your Vector2D object will be instantiated and called as such:
	 * Vector2D i = new Vector2D(vec2d);
	 * while (i.hasNext()) v[f()] = i.next();
	 */
	
	/*
		int indexList,indexEle;
	    List<List<Integer>> list;
	    
	    public Vector2D(List<List<Integer>> vec2d) {
	      list=vec2d;
	      indexList=0;
	      indexEle=0;
	    }
	
	    @Override
	    public Integer next() {
	     return list.get(indexList).get(indexEle++);   
	    
	    }
	
	    @Override
	    public boolean hasNext() {
	        while(indexList<list.size()){
	            if(indexEle<list.get(indexList).size()){
	                return true;
	            }else{
	                indexList++;
	                indexEle=0;
	            }   
	       }
	        return false;     
	    }
    */
}
