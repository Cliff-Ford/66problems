package test;




import org.junit.Test;


import problem28.Solution;



public class Test28 {
	@Test
	public void test() {
		Solution solution = new Solution();
		int array[] = {1,2,3,2,2,2,5,4,2};
		//int array1[] = {2,2,3,1};
		//int array2[] = {2,2,3,3,3};
		System.out.println(solution.MoreThanHalfNum_Solution(array));
		//System.out.println(solution.MoreThanHalfNum_Solution(array1));
		//System.out.println(solution.MoreThanHalfNum_Solution(array2));
		
		System.out.println(solution.MoreThanHalfNum_SolutionII(array));
		//System.out.println(solution.MoreThanHalfNum_SolutionII(array1));
		//System.out.println(solution.MoreThanHalfNum_SolutionII(array2));
	}
}