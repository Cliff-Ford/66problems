package test;



import org.junit.Test;

import problem06.Solution;




public class Test06 {
	@Test
	public void test() {
		Solution solution = new Solution();
		int input[] = {3,4,5,1,2};
		int re = solution.minNumberInRotateArray(input);
		System.out.println(re);
		int a[] = {2,2};
		System.out.println(solution.minNumberInRotateArray(a));
	}
}
