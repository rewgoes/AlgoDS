package questions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class LC_465 {

//	LC_465.minTransfers(
//			new int[][] { { 1, 10, 2 }, { 2, 10, 1 }, { 3, 11, 1 }, { 4, 12, 4 }, { 4, 13, 1 }, { 5, 13, 2 } })
	
	public static int minTransfers(int[][] transactions) {
		HashMap<Integer, Integer> balances = new HashMap<>();

		for (int[] transaction : transactions) {
			int xBalance = balances.getOrDefault(transaction[0], 0);
			int yBalance = balances.getOrDefault(transaction[1], 0);
			balances.put(transaction[0], xBalance + transaction[2]);
			balances.put(transaction[1], yBalance - transaction[2]);
		}

		PriorityQueue<Integer> pos = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		PriorityQueue<Integer> neg = new PriorityQueue<>();

		for (int balance : balances.values()) {
			if (balance > 0) {
				pos.add(balance);
			} else if (balance < 0) {
				neg.add(balance);
			}
		}
		
		int minTransactions = 0;
		
		while (!pos.isEmpty()) {
			minTransactions++;
			int max = pos.poll();
			int min = neg.poll();
			
			if (max > -min) {
				pos.add(max + min);
			} else if (min < max) {
				neg.add(max + min);
			}
		}

		return minTransactions;
	}
	
}
