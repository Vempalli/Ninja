package com.Algorithms.Ninja;

public class CreditCardsMajority {

	public static boolean isMajority(String[] creditCards) {
		if (creditCards == null)
			throw new NullPointerException("Null array!");
		if (creditCards.length == 0)
			return false;
		String majority = creditCards[0];
		int count = 1;
		for (String s : creditCards) {
			if (isSamePerson(s, majority))
				count++;
			else
				count--;
			if (count == 0) {
				majority = s;
				count = 1;
			}
		}
		count = 0;
		for (String s :creditCards) {
			if (isSamePerson(s, majority))
				count++;
		}
		return count >= creditCards.length;
	}
	//random isSamePerson method
	private static boolean isSamePerson(String num1, String num2) {
		if (num1.substring(0, 4).equals(num2.substring(0, 4)))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		String[] cards = {"12345","12345","31112","12345","12345","61111"};
		boolean ans = isMajority(cards);
		System.out.println(ans);
	}

}
