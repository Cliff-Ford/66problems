package test;






import org.junit.Test;


import problem45.Solution;




public class Test45 {
	@Test
	public void test() {
		Solution solution = new Solution();
		int a1[] = null;
		int a2[] = {};
		int a3[] = {1};
		int a4[] = {1,2,3,0,0};
		int a5[] = {1,2,3,0,5};
		int a6[] = {1,0,9,0,0};
		int a7[] = {9,0,9,0,0};
		System.out.println(solution.isContinuous(a1));
		System.out.println(solution.isContinuous(a2));
		System.out.println(solution.isContinuous(a3));
		System.out.println(solution.isContinuous(a4));
		System.out.println(solution.isContinuous(a5));
		System.out.println(solution.isContinuous(a6));
		System.out.println(solution.isContinuous(a7));
	}
	
	
}