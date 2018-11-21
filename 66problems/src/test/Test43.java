package test;






import org.junit.Test;


import problem43.Solution;




public class Test43 {
	@Test
	public void test() {
		Solution solution = new Solution();
		String S = "abcXYZdef";
		System.out.println(solution.LeftRotateString(null, 3));
		System.out.println(solution.LeftRotateString(S, 0));
		System.out.println(solution.LeftRotateString(S, 3));
		System.out.println(solution.LeftRotateString(S, 9));
		System.out.println(solution.LeftRotateString(S, 10));
	}
	
	
}
