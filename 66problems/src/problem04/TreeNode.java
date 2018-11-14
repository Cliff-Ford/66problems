package problem04;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
	public TreeNode() {	}
	//�������
	public void postOrder(TreeNode biTree){
	    TreeNode leftTree = biTree.left;
	    if (leftTree != null) {
	        postOrder(leftTree);
	    }
	    TreeNode rightTree = biTree.right;
	    if(rightTree != null){
	        postOrder(rightTree);
	    }
	    System.out.printf(biTree.val+"");
	}
}
