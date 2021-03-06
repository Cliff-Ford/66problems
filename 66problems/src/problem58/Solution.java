package problem58;



/**
 * @author Cliff_Ford
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class Solution {
	public boolean isSymmetrical(TreeNode pRoot){
		
		return isSymmetrical(pRoot, pRoot);
        
    }
	public boolean isSymmetrical(TreeNode pLeft,TreeNode pRight) {
		if(pLeft==null && pRight==null) {
			return true;
		}
		if(pLeft==null && pRight!=null){
			return false;
		}
		if(pRight==null && pLeft!=null) {
			return false;
		}
		if(pLeft.val!=pRight.val) {
			return false;
		}
		return isSymmetrical(pLeft.right,pRight.left) && isSymmetrical(pLeft.left, pRight.right);
	}
}

 