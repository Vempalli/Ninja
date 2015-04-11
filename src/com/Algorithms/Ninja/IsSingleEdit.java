package com.Algorithms.Ninja;

import java.util.Scanner;

public class IsSingleEdit {

	public static void main(String[] args) {
		boolean isAtOneEditDistance = false;
		Scanner x = new Scanner(System.in);
		System.out.println("Enter String 1");
		String input1 = x.nextLine();
		System.out.println("Enter String 2");
		String input2 = x.nextLine();
		isAtOneEditDistance = isOneEditDistance(input1,input2);
		System.out.println(isAtOneEditDistance);
	}

	private static boolean isOneEditDistance(String input1, String input2) {
		boolean isOneEdit = false;
		int len1 = input1.length();
		int len2 = input2.length();
		if(len2 < len1){
			return isOneEditDistance(input2, input1);
		}
		//length more than 1
		if(len1+1 < len2){
			return false;
		}
		int temp = 0;
		while(temp<len1){
			if(input1.charAt(temp)!=input2.charAt(temp)){
				if(len1==len2){
					return input1.substring(temp+1).equals(input2.substring(temp+1));
				}
				else{
					return input1.substring(temp).equals(input2.substring(temp+1));
				}
			}
			temp++;
		}
		
		return len1!=len2;
	}

}
