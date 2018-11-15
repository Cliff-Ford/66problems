package test;



import org.junit.Test;

import problem07.Solution;




public class Test07 {
	@Test
	public void test() {
		Solution solution = new Solution();
		for(int i = 0; i < 40; i++) {
			System.out.println(solution.Fibonacci(i));
		}
	}
}
