package com.Algorithms.Ninja;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * Greatest integer less than n with same digits
 * Input - 3618
 * Output - 3186
 */
public class NextPermutation {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		System.out.println("Enter Number");
		String input = x.nextLine();
		String output = findNextPermutation(input);
		System.out.println(output);
	}

	private static String findNextPermutation(String input) {
		StringBuffer output = new StringBuffer();
		//find digit which is less than the next digit
		char[] chars = input.toCharArray();
		int n = input.length();
		int i = 0;
		for(i = n-1; i > 0; i--){
			if(chars[i] < chars[i-1]){
				break;
			}
		}
		if(i<=0){
			output.append("no answer");
			return output.toString();
		}
		int digitIndex = i-1;
		int smallIndex = i;
		int j = 0;
		for(j= smallIndex+1; j<n; j++){
			if(chars[j] < chars[digitIndex] && chars[j] < chars[smallIndex]){
				smallIndex = j;
			}
		}
		//swap
		char temp = chars[smallIndex];
		chars[smallIndex] = chars[digitIndex];
		chars[digitIndex] = temp;
		
		//Arrays.sort(chars, digitIndex+1, n);
		//Added code
		Character[] temp1 = new Character[n];
		for(int ind = 0;ind < n; ind++){
			temp1[ind] = chars[ind];
		}
		Arrays.sort(temp1,digitIndex+1,n, Collections.reverseOrder());
		//return output.append(chars).toString();
		for(int k = 0; k < n ; k++){
			output.append(temp1[k]);
		}
		//return output.append(temp1).toString();
		return output.toString();
	}

}
