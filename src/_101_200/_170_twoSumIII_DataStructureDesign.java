package _101_200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _170_twoSumIII_DataStructureDesign {

	public static void main(String[] args) {
		TwoSum ts = new _170_twoSumIII_DataStructureDesign().new TwoSum();
		ts.add(1);
		ts.add(3);
		ts.add(5);
		
		System.out.println(ts.find(4));
		System.out.println(ts.find(7));
	}

	/**
	   Design and implement a TwoSum class. It should support the following operations: add and find.
	   add - Add the number to an internal data structure.
	   find - Find if there exists any pair of numbers which sum is equal to the value.
	   
	   For example:
	   add(1); add(3); add(5);
	   find(4) -> true
       find(7) -> false
	 */
	
	/*
	 * Note: This question clearly shows that ArrayList is far more fast than HashMap's iterator
	 * 
	 * The number added can be repeated.
	 */
	
	class TwoSum {
		
		private List<Integer> list;
		private Map<Integer, Integer> map;

	    /** Initialize your data structure here. */
	    public TwoSum() {
	        this.list = new ArrayList<>();
	        this.map = new HashMap<>();
	    }
	    
	    /** Add the number to an internal data structure.. */
	    public void add(int number) {
	        if(this.map.containsKey(number)) {
	        		this.map.put(number, this.map.get(number) + 1);
	         } else {
	        	 	this.map.put(number, 1);
	        	 	this.list.add(number);
	         }
	    }
	    
	    /** Find if there exists any pair of numbers which sum is equal to the value. */
	    public boolean find(int value) {
	        int len = this.list.size();
	        
	        for(int i = 0; i < len; i++) {
	        		int num1 = this.list.get(i);
	        		int num2 = value - num1;
	        		
	        		if(num1 == num2 && this.map.get(num1) > 1 || num1 != num2 && this.map.containsKey(num2)) {
	        			return true;
	        		}
	        }
	        
	        return false;
	    }
	}

	/**
	 * Your TwoSum object will be instantiated and called as such:
	 * TwoSum obj = new TwoSum();
	 * obj.add(number);
	 * boolean param_2 = obj.find(value);
	 */
	
	
	//Fastest solution
	/**
	 * class TwoSum {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    private int min, max;
    /** Initialize your data structure here.
    public TwoSum() {
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        map = new HashMap<Integer, Integer>();
        list = new LinkedList<Integer>();
    }
    
     Add the number to an internal data structure.. 
    public void add(int number) {
        if(min > number) min = number;
        if(max < number) max = number;
        
        if(map.containsKey(number))
            map.put(number, map.get(number) + 1);
        else{
            map.put(number, 1);
            list.add(number);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. 
    public boolean find(int value) {
        if(value >> 1 < min || value >> 1 > max) return false;
        if((value & 1) == 0 && map.getOrDefault(value >> 1, 0) > 1) return true;
        int target = 0;
        for(Integer i : list){
            if(i << 1 != value && map.containsKey(value - i))
                return true;
        }
        return false;
    }
	}
	 */
}
