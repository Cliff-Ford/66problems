package test;





import org.junit.Test;


import problem21.Solution;





public class Test21 {
	@Test
	public void test() {
		Solution solution = new Solution();
		int pushA[] = {1,2,3,4,5};
		int popA[] = {4,5,3,2,1};
		int popB[] = {4,3,5,1,2};
		boolean a = solution.IsPopOrder(pushA, popA);
		boolean b = solution.IsPopOrder(pushA, popB);
		System.out.println(a);
		System.out.println(b);
	}
}
