package test;



import org.junit.Test;

import problem09.Solution;




public class Test09 {
	@Test
	public void test() {
		Solution solution = new Solution();
		for(int i = 0; i < 9; i++) {
			System.out.println(solution.JumpFloorII(i));
		}
	}
}
