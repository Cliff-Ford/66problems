package test;






import org.junit.Test;


import problem44.Solution;




public class Test44 {
	@Test
	public void test() {
		Solution solution = new Solution();
		System.out.println(solution.ReverseSentence("student. a am I"));
		System.out.println(solution.ReverseSentence("student. a  am I"));
		System.out.println(solution.ReverseSentence("student. a am I  "));
		System.out.println(solution.ReverseSentence("student.   a am I  "));
		System.out.println(solution.ReverseSentence(""));
		System.out.println(solution.ReverseSentence("   student. a am I  "));
	}
	
	
}
