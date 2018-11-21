package problem58;



/**
 * @author Cliff_Ford
 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�
 * ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
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

 