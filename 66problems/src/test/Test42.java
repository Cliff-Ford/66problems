package test;






import org.junit.Test;


import problem42.Solution;




public class Test42 {
	@Test
	public void test() {
		Solution solution = new Solution();
		int a1[] = null;
		int a2[] = {};
		int a3[] = {1};
		int a4[] = {1,2};
		int a5[] = {1,2,3,4};
		int a6[] = {1,2,3,3,4};
		int a7[] = {1,4};
		System.out.println(solution.FindNumbersWithSum(a1, 6));//[]
		System.out.println(solution.FindNumbersWithSum(a2, 6));//[]
		System.out.println(solution.FindNumbersWithSum(a3, 6));//[]
		System.out.println(solution.FindNumbersWithSum(a4, 2));//[1,2]
		System.out.println(solution.FindNumbersWithSum(a5, 6));//[2,4]
		System.out.println(solution.FindNumbersWithSum(a6, 6));//[2,4]
		System.out.println(solution.FindNumbersWithSum(a7, 6));//[]
	}
	
	
}