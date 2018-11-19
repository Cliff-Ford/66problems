package test;




import org.junit.Test;


import problem34.Solution;



public class Test34 {
	@Test
	public void test() {
		Solution solution = new Solution();
		System.out.println(solution.FirstNotRepeatingChar("googlllq"));
		System.out.println(solution.FirstNotRepeatingChar("a"));
		System.out.println(solution.FirstNotRepeatingChar("aa"));
		System.out.println(solution.FirstNotRepeatingChar("ab"));
		System.out.println(solution.FirstNotRepeatingChar("aba"));
		
	}
	
}
