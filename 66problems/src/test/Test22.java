package test;





import java.util.ArrayList;

import org.junit.Test;

import problem22.TreeNode;
import problem22.Solution;





public class Test22 {
	@Test
	public void test() {
		Solution solution = new Solution();
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(3);
		TreeNode node3 = new TreeNode(2);
		TreeNode node4 = new TreeNode(5);
		TreeNode node5 = new TreeNode(4);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.left = node5;
		ArrayList<Integer> a = solution.PrintFromTopToBottom(node1);
		for(Integer t : a) {
			System.out.println(t);
		}
	}
	@Test
	public void test2() {
		Solution solution = new Solution();
		TreeNode node1 = null;
		ArrayList<Integer> a = solution.PrintFromTopToBottom(node1);
		for(Integer t : a) {
			System.out.println(t);
		}
	}
}
