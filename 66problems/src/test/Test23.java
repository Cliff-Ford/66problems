package test;






import org.junit.Test;


import problem23.Solution;





public class Test23 {
	@Test
	public void test() {
		Solution solution = new Solution();
		int array1[] = {};
		int array2[] = {1};
		int array3[] = {1,3,5,4,2};
		int array4[] = {1,3,5,2,4};
		int array5[] = {4,6,7,5};
		int array6[] = {4,8,7,5};
		System.out.println(solution.VerifySquenceOfBST(array1));
		System.out.println(solution.VerifySquenceOfBST(array2));
		System.out.println(solution.VerifySquenceOfBST(array3));
		System.out.println(solution.VerifySquenceOfBST(array4));
		System.out.println(solution.VerifySquenceOfBST(array5));
		System.out.println(solution.VerifySquenceOfBST(array6));
	}
	
}