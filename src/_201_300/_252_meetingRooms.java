package _201_300;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class _252_meetingRooms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * Given an array of meeting time intervals consisting of start and end times
	 * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all
	 * meetings.
	 * 
	 * For example, Given [[0, 30],[5, 10],[15, 20]], return false.
	 */

	public boolean canAttendMeetings(Interval[] intervals) {
		if(intervals == null) {
			return false;
		}
		
		Collections.sort(Arrays.asList(intervals), new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
			
		});
		
		int len = intervals.length;
		
		for(int i = 0; i < len - 1; i++) {
			if(intervals[i].end > intervals[i + 1].start) {
				return false;
			}
		}
		
		return true;
	}

	/*
		if(intervals.length<1)return true;
	
		int[] s = new int[intervals.length];
		int[] e = new int[intervals.length];for(
		int i = 0;i<intervals.length;i++)
		{
			s[i] = intervals[i].start;
			e[i] = intervals[i].end;
		}Arrays.sort(s);Arrays.sort(e);for(
		int i = 1;i<intervals.length;i++)
		{
			if (s[i] < e[i - 1]) {
				return false;
			}
		}
		return true;
	*/
}

class Interval {
	public int start;
	public int end;
	
	public Interval() {
		this.start = 0;
		this.end = 0;
	}
	
	public Interval(int s, int e) {
		this.start = s;
		this.end = e;
	}
}
