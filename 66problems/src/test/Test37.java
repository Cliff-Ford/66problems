package test;




import org.junit.Test;


import problem37.Solution;



public class Test37 {
	@Test
	public void test() {
		Solution solution = new Solution();
		int array[] = {1,1,2,2,2,2,2,2,3,8,10};
		System.out.println(solution.GetNumberOfK(array, 2));
		System.out.println(solution.GetNumberOfK(array, 11));
		System.out.println(solution.GetNumberOfK(null, 2));
	}
	
}