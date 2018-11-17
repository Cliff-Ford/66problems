package test;



import java.util.ArrayList;

import org.junit.Test;


import problem19.Solution;





public class Test19 {
	@Test
	public void test() {
		Solution solution = new Solution();
		int array[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		ArrayList<Integer> arrayList = solution.printMatrix(array);
		for(int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}
	}
}
