package com.Algorithms.Ninja;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Active_Time_Single_User {
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
