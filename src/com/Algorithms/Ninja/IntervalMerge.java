package com.Algorithms.Ninja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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

public class IntervalMerge {
	
	public static void main(String[] args) {
		Interval i1 = new Interval(1,5);
		Interval i2 = new Interval(3,6);
		Interval i3 = new Interval(7,12);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		ArrayList<Interval> result = new ArrayList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		IntervalMerge merge = new IntervalMerge();
		result = merge.merge(intervals);
		for(int i =0; i < result.size();i++){
			System.out.println(result.get(i).start + ", "+ result.get(i).end);
		}
	}

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		 
		if (intervals == null || intervals.size() <= 1)
			return intervals;
 
		// sort intervals by using self-defined Comparator
		Collections.sort(intervals, new IntervalComparator());
 
		ArrayList<Interval> result = new ArrayList<Interval>();
 
		Interval prev = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
 
			if (prev.end >= curr.start) {
				// merged case
				Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end));
				prev = merged;
			} else {
				result.add(prev);
				prev = curr;
			}
		}
 
		result.add(prev);
 
		return result;
	}
}
class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
	
}