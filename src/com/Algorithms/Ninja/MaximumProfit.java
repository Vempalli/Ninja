package com.Algorithms.Ninja;


public class MaximumProfit {

	public static void main(String[] args) {
		int a[] = {20,40,52,15,30,50,10,25};
		int profit = computeMaxProfitSingleBuy(a);
		int multi_profit = computeMaxProfitMultiBuy(a);
		System.out.println(profit);
		System.out.println(multi_profit);
	}

	private static int computeMaxProfitMultiBuy(int[] a) {
		int profit = 0;
		int previous = a[0];
		for(int i = 1; i < a.length; i++){
			profit = profit + Math.max(0, a[i]-previous);
			previous = a[i];
		}
		return profit;
	}

	private static int computeMaxProfitSingleBuy(int[] a) {
		int profit = 0;
		int currentMin = a[0];
		for(int i = 1; i < a.length; i++){
			profit = Math.max(profit,a[i]-currentMin);
			currentMin = Math.min(a[i], currentMin);
		}
		return profit;
	}

}
