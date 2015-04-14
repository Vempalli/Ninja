package com.Algorithms.Ninja;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TopKHeap {
	
	private static class TopKSmallest implements Comparator<Integer> {
		public int compare (Integer one, Integer two) {
			return two - one;
		}
	}

	public static void main(String[] args) {
		int[] array = { 3, 46, 2, 56, 3, 38, 93, 45, 6, 787, 34, 76, 44, 6, 7, 86, 8, 44, 56 };
		int[] result = getTopElements(array, 5);
		for (int i : result) {
			System.out.println(i + ", ");
		}

		result = getKsmallest(array, 5);
		for (int i : result) {
			System.out.println(i + ", ");
		}
		return;
	}

	//find the largest K, by using minHeap
	private static int[] getTopElements(int[] array, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k);
		for (int i = 0; i < array.length; i++) {
			if (i < k) {
				heap.add(array[i]);
			} else {
				if (array[i] > heap.peek()) {
					heap.poll();
					heap.add(array[i]);
				}
			}
		}

		int[] result = new int[k];
		for (int i = 0; i < result.length; i++) {
			result[i] = heap.poll();
		}

		return result;
	}

	//find the smallest K, by using maxHeap
	private static int[] getKsmallest(int[] array, int k) {
		TopKSmallest comp = new TopKSmallest();
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, comp);
		for (int i = 0; i < array.length; i++) {
			if (i < k) {
				heap.add(array[i]);
			} else {
				if (array[i] < heap.peek()) {
					heap.poll();
					heap.add(array[i]);
				}
			}
		}

		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = heap.poll();
		}

		return result;
	}
}
