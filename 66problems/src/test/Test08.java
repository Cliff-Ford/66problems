package test;



import org.junit.Test;

import problem08.Solution;




public class Test08 {
	@Test
	public void test() {
		Solution solution = new Solution();
		for(int i = 0; i < 5; i++) {
			System.out.println(solution.JumpFloor(i));
		}
	}
}
