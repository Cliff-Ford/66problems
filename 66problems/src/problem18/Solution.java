package problem18;


/**
 * @author Cliff_Ford
 * ���������Ķ�����������任ΪԴ�������ľ���
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