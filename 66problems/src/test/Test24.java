package test;

import java.util.ArrayList;

import org.junit.Test;


import problem24.Solution;
import problem24.TreeNode;

public class Test24 {
	@Test
	public void test() {
		Solution solution = new Solution();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(7);
		TreeNode t5 = new TreeNode(1);
		TreeNode t6 = new TreeNode(3);
		TreeNode t7 = new TreeNode(2);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.right = t6;
		t5.left = t7;
		ArrayList<ArrayList<Integer>> a = solution.FindPath(t1, 3);
		System.out.println(a);
	}
	
}
