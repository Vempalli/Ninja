package com.Algorithms.Ninja;

import java.util.Scanner;

// Not correct.. have to test yet
public class TopN {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		System.out.println("Enter elements in array");
		String input = x.nextLine();
		String parse[] = input.split(" ");
		int[] output = new int[parse.length];
		System.out.println("Enter value of n");
		int n = x.nextInt();
		output = findResult(parse,n);
		System.out.println();
		for(int ind = 0; ind < output.length; ind++){
			System.out.print(output[ind]);
			System.out.print(" ");
		}
	}

	private static int[] findResult(String[] parse, int n) {
		int output[] = new int[n];
		int minInd = 0;
		int min = Integer.parseInt(parse[0]);
		for(int i = 0; i < n; i++){
			int val = Integer.parseInt(parse[i]);
			if(min > val){
				min = val;
				minInd = i;
			}
			output[i] = val;
		}
		for(int i = n; i < parse.length; i++){
			int val1 = Integer.parseInt(parse[i]);
			if(val1 > min){
				output[minInd] = val1;
				min = findMin(output);
			}
		}
		return output;
	}

	private static int findMin(int[] output) {
		int min = output[0];
		for(int i = 1; i < output.length; i++){
			if(output[i] < min){
				min = output[i];
			}
		}
		return min;
	}

}
