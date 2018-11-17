package test;




import org.junit.Test;


import problem30.Solution;



public class Test30 {
	@Test
	public void test() {
		Solution solution = new Solution();
		int a[] = {6,-3,-2,7,-15,1,2,2};//8
		System.out.println(solution.FindGreatestSumOfSubArray(a));
		int b[] = {-3,-2};//-2
		System.out.println(solution.FindGreatestSumOfSubArray(b));
		int c[] = {1,-2,3,10,-4,7,2,-5};//18
		System.out.println(solution.FindGreatestSumOfSubArray(c));
	}
	
}
