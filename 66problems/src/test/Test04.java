package test;



import org.junit.Test;

import problem04.Solution;
import problem04.TreeNode;




public class Test04 {
	@Test
	public void test() {
		int pre[] = {1,2,4,7,3,5,6,8};
		int in[] = {4,7,2,1,5,3,8,6};
		Solution solution = new Solution();
		TreeNode treeNode = solution.reConstructBinaryTree(pre, in);
		treeNode.postOrder(treeNode);
	}
}
