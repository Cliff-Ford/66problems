package test;




import java.util.ArrayList;

import org.junit.Test;


import problem41.Solution;




public class Test41 {
	@Test
	public void test() {
		Solution solution = new Solution();
		ArrayList<ArrayList<Integer>> arrayList = solution.FindContinuousSequence(100);
		for(ArrayList<Integer> a : arrayList) {
			System.out.println(a);
		}
	}
	
	
}