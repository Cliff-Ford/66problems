package test;


import org.junit.Test;


import problem26.Solution;
import problem26.TreeNode;


public class Test26 {
	@Test
	public void test() {
		Solution solution = new Solution();
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		TreeNode t = solution.Convert(t1);
		while(t != null) {
			System.out.println(t.val);
			t = t.right;
		}
	}
	@Test
	public void test2() {
		Solution solution = new Solution();
		TreeNode t1 = null;
		TreeNode t = solution.Convert(t1);
		while(t != null) {
			System.out.println(t.val);
			t = t.right;
		}
	}
}
