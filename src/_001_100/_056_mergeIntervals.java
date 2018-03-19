package _001_100;

import java.util.ArrayList;
import java.util.List;

public class _056_mergeIntervals {
    public static void main(String[] args) {
//        [1,3],[2,6],[8,10],[15,18]
        Interval i1 = new Interval(1, 7);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(8, 10);
        Interval i4 = new Interval(15, 18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(i1);
        intervals.add(i2);
        intervals.add(i3);
        intervals.add(i4);

        List<Interval> res = merge(intervals);

        for(Interval i : res) {
            System.out.println(i.start + ", " + i.end);
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();

        intervals.sort((e1, e2) -> Integer.compare(e1.start, e2.start));

        int len = intervals.size();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(int i = 1; i < len; i++) {
            if(end >= intervals.get(i).start) {
                end = Math.max(end, intervals.get(i).end);
            } else {
                Interval newInterval = new Interval(start, end);
                res.add(newInterval);
                start = intervals.get(i).start;
                end = intervals.get(i).end;
            }
        }

        Interval newInterval = new Interval(start, end);
        res.add(newInterval);

        return res;
    }
}

class Interval {
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}
