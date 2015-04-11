package com.Algorithms.Ninja;

public class PancakeSorting {

	public static void main(String[] args) {
		int[] input = {23, 10, 20, 11, 12, 6, 7};
		pancakeSort(input);
		for(int i = 0; i < input.length; i++){
			System.out.print(input[i]+"    ");
		}
	}

	private static void pancakeSort(int[] input) {
		//continue above excluding the last element
		for(int index = input.length-1; index>1; index--){
			//Get index of max element
			int maxInd = getMax(input, index);
			if(maxInd!=index){
				//Move it to the top
				flip(input, maxInd);
				//flip the data
				flip(input, index);
			}
			
		}
		
	}
	
	//Reverse the array from 0 to index
	private static void flip(int[] input, int index){
		int temp = 0;
		int begin = 0;
		while(begin < index){
			temp = input[begin];
			input[begin] = input[index];
			input[index] = temp;
			begin++;
			index--;
		}
		
	}
	
	private static int getMax(int[] input,int index){
		int maxInd =0;
		for(int i = 0; i <= index;i++){
			if(input[i] > input[maxInd]){
				maxInd = i;
			}
		}
		return maxInd;
	}
}
