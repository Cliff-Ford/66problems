package test;






import org.junit.Test;


import problem52.Solution;




public class Test52 {
	@Test
	public void test() {
		Solution solution = new Solution();
		
		//System.out.println(solution.match("".toCharArray(), "".toCharArray()));
		//System.out.println(solution.match("a".toCharArray(), "a.".toCharArray()));
		System.out.println(solution.match("aa".toCharArray(), "a*a".toCharArray()));
		System.out.println(solution.match("".toCharArray(), ".*".toCharArray()));
		//System.out.println(solution.match("aaa".toCharArray(), "c*ab*ac*a".toCharArray()));
		//System.out.println(solution.match("aaa".toCharArray(), "abac*a".toCharArray()));
		//System.out.println(solution.match("aba".toCharArray(), "abac*a".toCharArray()));
		//System.out.println(solution.match("aba".toCharArray(), "abac*".toCharArray()));
		//System.out.println(solution.match("abaaaaaaa".toCharArray(), "b*aba*c*".toCharArray()));
		//System.out.println(solution.match("aaaaaaaa".toCharArray(), "b*a*".toCharArray()));
		//System.out.println(solution.match("a".toCharArray(), "a*".toCharArray()));
	}
	
	
}
