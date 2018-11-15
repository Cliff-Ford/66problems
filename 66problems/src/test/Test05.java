package test;



import org.junit.Test;

import problem05.Solution;




public class Test05 {
	@Test
	public void test() {
		Solution solution = new Solution();
		solution.push(1);
		solution.push(2);
		solution.push(3);
		solution.push(4);
		System.out.println(solution.pop());
		System.out.println(solution.pop());
		System.out.println(solution.pop());
		System.out.println(solution.pop());
		System.out.println(solution.pop());
	}
}
