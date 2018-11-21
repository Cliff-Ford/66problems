package test;






import java.util.ArrayList;

import org.junit.Test;


import problem60.Solution;
import problem60.TreeNode;




public class Test60 {
	@Test
	public void test() {
		Solution solution = new Solution();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		ArrayList<ArrayList<Integer>> result = solution.Print(t1);
		for(ArrayList<Integer> r : result) {
			System.out.println(r);
		}
	}
	
	
	
}