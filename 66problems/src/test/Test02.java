package test;

import org.junit.Test;

import problem02.Solution;

public class Test02 {
	@Test
	public void test() {
		StringBuffer stringBuffer = new StringBuffer("We Are Happy.");
		Solution solution = new Solution();
		String result = solution.replaceSpace(stringBuffer);
		System.out.println(result);		
	}
}