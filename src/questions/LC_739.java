package questions;

import java.util.Stack;

public class LC_739 {

	//https://leetcode.com/contest/weekly-contest-61/problems/daily-temperatures
	//int[] temps = LC_739.dailyTemperatures(new int[] { 73, 74, 75, 71, 69, 72, 76, 73 });
	
	public static int[] dailyTemperatures(int[] temperatures) {
		if (temperatures.length == 0) return temperatures;
		Stack<Integer> warmerTemp = new Stack<>();
		warmerTemp.push(0);
		
		int index;
		for (int i = 1; i < temperatures.length; i++) {
			while (!warmerTemp.isEmpty() && temperatures[i] > temperatures[warmerTemp.peek()]) {
				index = warmerTemp.pop();
				temperatures[index] = i - index;
			}
			warmerTemp.push(i);
		}
		
		while(!warmerTemp.isEmpty()) {
			temperatures[warmerTemp.pop()] = 0;
		}
		
		return temperatures;
	}

}
