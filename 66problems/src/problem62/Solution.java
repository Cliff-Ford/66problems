package problem62;

import java.util.ArrayList;

/**
 * @author Cliff_Ford
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class Solution {
	//中序遍历，输出
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

 