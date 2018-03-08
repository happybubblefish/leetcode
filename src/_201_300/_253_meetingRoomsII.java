package _201_300;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _253_meetingRoomsII {

	public static void main(String[] args) {
		Interval i1 = new Interval(1, 5);
		Interval i2 = new Interval(2, 7);
		Interval i3 = new Interval(8, 9);
		
		Interval[] intervals = new Interval[3];
		intervals[0] = i1;
		intervals[1] = i2;
		intervals[2] = i3;
		
		System.out.println(minMeetingRooms(intervals));
	}

	/*
		Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
	
		For example,
		Given [[0, 30],[5, 10],[15, 20]],
		return 2.
	*/
	
	public static int minMeetingRooms(Interval[] intervals) {
		if(intervals == null || intervals.length == 0) {
			return 0;
		}
		
		Collections.sort(Arrays.asList(intervals), (a, b) -> a.start - b.start);
		PriorityQueue<Interval> queue = new PriorityQueue<>(intervals.length, (a, b) -> a.end - b.end);
		int max = 0;
		
		for(int i = 0; i < intervals.length; i++) {
			while(!queue.isEmpty() && intervals[i].start > queue.peek().end) {
				queue.poll();
			}
			
			queue.offer(intervals[i]);
			max = Math.max(max, queue.size());
		}
		
		return max;
		
		/*
			if(intervals == null || intervals.length == 0) return 0;
	        int[] startTimes = new int[intervals.length];
	        int[] endTimes = new int[intervals.length];
	        for(int i = 0; i < intervals.length; i++) {
	            startTimes[i] = intervals[i].start;
	            endTimes[i] = intervals[i].end;
	        }
	        Arrays.sort(startTimes);
	        Arrays.sort(endTimes);
	        int count = 0;
	        for(int i = 0, j = 0; i < intervals.length; i++) {
	            if(startTimes[i] < endTimes[j]) {
	                count ++;
	            } else {
	                j++;
	            }
	        }
	        return count;
        */
	}
}
