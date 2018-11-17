package test;




import org.junit.Test;


import problem29.Solution;



public class Test29 {
	@Test
	public void test() {
		Solution solution = new Solution();
		int array[] = {};
		int array1[] = {1,2,5,8,3,3,8};
		int array2[] = {4,5,1,6,2,7,3,8};
		System.out.println(solution.GetLeastNumbers_Solution(array, 1));
		System.out.println(solution.GetLeastNumbers_Solution(array1, 0));
		System.out.println(solution.GetLeastNumbers_Solution(array1, 4));
		System.out.println(solution.GetLeastNumbers_Solution(array2, 4));
	}
	@Test
	public void test1() {
		Solution solution = new Solution();
		
		int array[] = {1,2,5,8,3,3,8};
		
		solution.HeapSort(array);
		
		
	}
}
