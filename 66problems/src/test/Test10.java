package test;



import org.junit.Test;

import problem10.Solution;




public class Test10 {
	@Test
	public void test() {
		Solution solution = new Solution();
		for(int i = 0; i < 6; i++) {
			System.out.println(solution.RectCover(i));
		}
	}
}
