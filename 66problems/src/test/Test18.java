package test;



import org.junit.Test;


import problem18.Solution;
import problem18.TreeNode;




public class Test18 {
	@Test
	public void test() {
		Solution solution = new Solution();
		TreeNode t1 = new TreeNode(8);
		TreeNode t2 = new TreeNode(8);
		TreeNode t3 = new TreeNode(7);
		TreeNode t4 = new TreeNode(9);
		TreeNode t5 = new TreeNode(2);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		solution.mirror(t1);
		
	}
}
