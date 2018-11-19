package test;




import org.junit.Test;


import problem39.Solution;
import problem39.TreeNode;



public class Test39 {
	@Test
	public void test() {
		Solution solution = new Solution();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		System.out.println(solution.IsBalanced_Solution(t1));
		TreeNode t4 = new TreeNode(4);
		t3.left = t4;
		System.out.println(solution.IsBalanced_Solution(t1));
		TreeNode t5 = new TreeNode(5);
		t4.right = t5;
		System.out.println(solution.IsBalanced_Solution(t1));
	}
	@Test
	public void testII() {
		Solution solution = new Solution();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		t1.left = t2;
		t1.right = t3;
		//System.out.println(solution.IsBalanced_Solution(t1));
		TreeNode t4 = new TreeNode(4);
		t3.left = t4;
		//System.out.println(solution.IsBalanced_Solution(t1));
		TreeNode t5 = new TreeNode(5);
		t4.right = t5;
		System.out.println(solution.IsBalanced_Solution(t1));
	}
	
}