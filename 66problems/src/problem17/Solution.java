package problem17;


/**
 * @author Cliff_Ford
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Solution {
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null || root1 == null) {
        	return false;
        }
        boolean flag = false;
        if(root1.val == root2.val) {
        	flag = isSubTree(root1, root2);
        }
        
        if(!flag) {
        	flag = HasSubtree(root1.left, root2);
        }
        if(!flag) {
        	flag = HasSubtree(root1.right,root2);
        }
        return flag;
    }
	
	//判断是否是从属关系
	public boolean isSubTree(TreeNode tree1, TreeNode tree2) {
		//子树先遍历完了，返回真
		if(tree2 == null) {
			return true;
		}
		//主树先遍历完，返回false
		if(tree1 == null) {
			return false;
		}
		if(tree1.val == tree2.val) {
			return isSubTree(tree1.left, tree2.left) && isSubTree(tree1.right, tree2.right);
		}
		return false;
	}
}