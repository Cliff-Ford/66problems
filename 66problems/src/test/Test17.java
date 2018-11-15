package test;



import org.junit.Test;


import problem17.Solution;
import problem17.TreeNode;




public class Test17 {
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
		boolean flag = solution.HasSubtree(t1, t2);
		if(flag == true) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		
	}
}
