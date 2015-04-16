package com.Algorithms.Ninja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// Improved by using priority queue: https://github.com/daisyonly/algorithm-discussion-class/blob/0b84efef41a48b0cdf9febe4606140cb60c34ab9/src/leetcode_others/MergeIntervals.java
// Actual: Should use treemap or binary search tree


/*class Interval {
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
}*/

public class IntervalRange {
	
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		boolean hasInterval = true;
		ArrayList<Interval> initial = new ArrayList<Interval>();
		while(hasInterval){
			System.out.println("Enter Intervals");
			int start = x.nextInt();
			int end = x.nextInt();
			Interval i = new Interval(start,end);
			initial.add(i);
			initial = merge(initial);
			int count = 0;
			for(Interval inter: initial){
				count += inter.end-inter.start + 1;
			}
			System.out.println(count);
			System.out.println("Have more intervals?");
			String choice = x.next();
			if(choice.equalsIgnoreCase("no")||choice.equalsIgnoreCase("n")){
				hasInterval = false;
			}
		}
		
	}

	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		 
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
/*class IntervalComparator implements Comparator<Interval> {
	public int compare(Interval i1, Interval i2) {
		return i1.start - i2.start;
	}
	
}*/