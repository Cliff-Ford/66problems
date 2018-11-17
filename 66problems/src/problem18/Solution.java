package problem18;


/**
 * @author Cliff_Ford
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class Solution {
	public void Mirror(TreeNode root) {
        TreeNode r = mirror(root);
        root = r;
    }
	public TreeNode mirror(TreeNode root) {
		if(root == null) {
			return root;
		}
		TreeNode leftMirror = mirror(root.left);
		TreeNode rightMirror = mirror(root.right);
		root.left = rightMirror;
		root.right = leftMirror;
		return root;
	}
}