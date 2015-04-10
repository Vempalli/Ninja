package com.Algorithms.Ninja;

import java.util.Scanner;

public class HistogramWithWater {

	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		System.out.println("Enter histograms height");
		String in = x.nextLine();
		String[] input = in.split(",");
		int result = computeVolume(input);
		System.out.println(result);
	}

	private static int computeVolume(String[] input) {
		int volume = 0;
		int max_left[] = new int[input.length];
		int max_right[] = new int[input.length];
		for(int i =0; i < max_left.length;i++){
			if(i == 0){
				max_left[i] = Integer.parseInt(input[i]);
			}
			else{
				max_left[i] = Math.max(Integer.parseInt(input[i]), max_left[i-1]);
			}
		}
		for(int i = max_right.length - 1; i >= 0;i--){
			if(i == max_right.length - 1){
				max_right[i] = Integer.parseInt(input[i]);
			}
			else{
				max_right[i] = Math.max(Integer.parseInt(input[i]), max_right[i+1]);
			}
		}
		
		for(int i = 0; i < input.length; i++){
			volume += Math.min(max_left[i], max_right[i]) - Integer.parseInt(input[i]);
		}
		
		return volume;
	}

}
