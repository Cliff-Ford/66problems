package test;



import org.junit.Test;

import problem13.Solution;




public class Test13 {
	@Test
	public void test() {
		Solution solution = new Solution();
		int array[] = {1,2,5,4,6,3,3,9,10};
		solution.reOrderArray(array);
		for(int t : array) {
			System.out.println(t);
		}
	}
}
