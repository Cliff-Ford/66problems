package problem39;



/**
 * @author Cliff_Ford
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class Solution {
	
	public boolean IsBalanced_Solution(TreeNode root) {
		if(root == null) {
			return true;
		}
		int l = TreeDepth(root.left);
		int r = TreeDepth(root.right);
		int d = Math.abs(l-r);
		
		return d<=1?true:false;
        
    }
	
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

