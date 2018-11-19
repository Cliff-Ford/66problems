package problem38;




/**
 * @author Cliff_Ford
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class Solution {
	
	public int TreeDepth(TreeNode root) {
        if(root == null) {
        	return 0;
        }
        int l = 0, r = 0;
        if(root.left != null) {
        	l = TreeDepth(root.left);
        }
        if(root.right != null) {
        	r = TreeDepth(root.right);
        }
        
		return l>=r?l+1:r+1;
    }
}

