package test;







import org.junit.Test;


import problem65.Solution;





public class Test65 {
	@Test
	public void test() {
		Solution solution = new Solution();
		char matrix[] = "abcesfcsadee".toCharArray();
		System.out.println(solution.hasPath(matrix, 3, 4, "fa".toCharArray()));
		System.out.println(solution.hasPath(matrix, 3, 4, "bc".toCharArray()));
		System.out.println(solution.hasPath(matrix, 3, 4, "bcced".toCharArray()));
		System.out.println(solution.hasPath(matrix, 3, 4, "abcb".toCharArray()));
		char matrix1[] = "a".toCharArray();
		System.out.println(solution.hasPath(matrix1, 1, 1, "a".toCharArray()));
	}
	
	
	
}