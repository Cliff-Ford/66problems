package test;



import org.junit.Test;

import problem12.Solution;




public class Test12 {
	@Test
	public void test() {
		Solution solution = new Solution();
		long t1 = System.currentTimeMillis();
		for(int i = 0; i < 20; i++) {
			System.out.println(solution.Power(80, i));		
		}
		long t2 = System.currentTimeMillis();
		System.out.println("方法一"  + (t2 - t1));
		
		long t3 = System.currentTimeMillis();
		for(int i = 0; i < 20; i++) {			
			System.out.println(solution.Power(80, i));
		}
		long t4 = System.currentTimeMillis();
		System.out.println("方法二" + (t4 - t3));
	}
}
