package com.Algorithms.Ninja;

import java.util.Arrays;

public class SumOfTwoElementsToTarget {

	public static void main(String[] args) {
		int a[] = {2,5,1,66,7};
		int sum = 12;
		Arrays.sort(a);
		int lIndex = 0;
		int rIndex = a.length-1;
		while(lIndex<rIndex){
			if(a[lIndex]+a[rIndex] == sum){
				System.out.println("Exists "+ a[lIndex]+" and "+a[rIndex]);
				break;
			}
			else if(a[lIndex]+a[rIndex] < sum){
				lIndex++;
			}
			else{
				rIndex--;
			}
		}
	}

}
