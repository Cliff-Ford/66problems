package test;



import org.junit.Test;

import problem11.Solution;




public class Test11 {
	@Test
	public void test() {
		Solution solution = new Solution();
		int array[] = {-8,-8,-2147483648};
		for(int i = 0; i < array.length; i++) {
			System.out.println(solution.NumberOf1(array[i]));
		}
		//Ҳ����ͨ���⺯����������
		System.out.println(Integer.toBinaryString(-8));
	}
}