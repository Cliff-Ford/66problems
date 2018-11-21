package problem62;

import java.util.ArrayList;

/**
 * @author Cliff_Ford
 * ����һ�ö��������������ҳ����еĵ�kС�Ľ�㡣
 * ���磬 ��5��3��7��2��4��6��8��    �У��������ֵ��С˳�����С����ֵΪ4��
 */
public class Solution {
	//������������
	private ArrayList<Integer> result = new ArrayList<>();
	public TreeNode KthNode(TreeNode pRoot, int k){
		if(pRoot==null) {
			return null;
		}
		if(k<=0) {
			return null;
		}
        inorder(pRoot);
        if(k>result.size()) {
        	return null;
        }
        
        int i = result.get(k-1);
        
        TreeNode p = pRoot;
        while(p.val!=i) {
        	if(p.val>i) {
        		p = p.left;
        	}else {
        		p = p.right;
        	}
        }
        return p;
    }
	public void inorder(TreeNode pRoot) {
		if(pRoot!=null) {
			
			inorder(pRoot.left);
			result.add(pRoot.val);
			inorder(pRoot.right);
		}
	}
}

 