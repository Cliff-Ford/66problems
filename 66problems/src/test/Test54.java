package test;






import org.junit.Test;


import problem54.Solution;




public class Test54 {
	@Test
	public void test() {
		Solution solution = new Solution();
		solution.Insert('g');
		System.out.println(solution.FirstAppearingOnce());
		solution.Insert('o');
		System.out.println(solution.FirstAppearingOnce());
		solution.Insert('o');
		System.out.println(solution.FirstAppearingOnce());
		solution.Insert('g');
		System.out.println(solution.FirstAppearingOnce());
		solution.Insert('l');
		System.out.println(solution.FirstAppearingOnce());
	}
	
	
}
