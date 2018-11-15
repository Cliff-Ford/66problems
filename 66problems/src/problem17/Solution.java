package problem17;


/**
 * @author Cliff_Ford
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ����ps������Լ��������������һ�������ӽṹ��
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
	
	//�ж��Ƿ��Ǵ�����ϵ
	public boolean isSubTree(TreeNode tree1, TreeNode tree2) {
		//�����ȱ������ˣ�������
		if(tree2 == null) {
			return true;
		}
		//�����ȱ����꣬����false
		if(tree1 == null) {
			return false;
		}
		if(tree1.val == tree2.val) {
			return isSubTree(tree1.left, tree2.left) && isSubTree(tree1.right, tree2.right);
		}
		return false;
	}
}