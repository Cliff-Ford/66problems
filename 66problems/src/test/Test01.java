package test;

import org.junit.Test;

import problem01.Solution;

public class Test01 {
	@Test
	public void test() {
		//int [][] array = new int[5][5];
		//ע�� a < b && a < c ������ȷ�� b >?<?= c �Ĺ�ϵ
		/*int [][] array = {
							{1,2,8,9},
							{2,4,9,12},
							{4,7,10,13},
							{6,8,11,15}
						 };*/
		//int [][] array = {};
		int [][] array = {{}};
		int target = 20;
		//int target = 7;
		Solution solution = new Solution();
		if(solution.Find(target, array) == true) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
	}
}
