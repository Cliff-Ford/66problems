package problem38;




/**
 * @author Cliff_Ford
 * ����һ�ö����������������ȡ�
 * �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
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
