package problem26;





/**
 * @author Cliff_Ford
 * ����һ�ö��������������ö���������ת����һ�������˫��������
 * Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 */
public class Solution {
	public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree == null) {
			return null;
		}
        TreeNode tail = null;
        tail = BSTtoDVL(pRootOfTree, tail);
        TreeNode head = tail;
        while(head.left!=null) {
        	head = head.left;
        }
        return head;
    }
	//����������ת��Ϊ˫������,tail�ĳ�ʼֵΪnull
	//tail������Ϊ�Ѿ�����õ�˫�����������һ���ڵ�
	private TreeNode BSTtoDVL(TreeNode root,TreeNode tail) {
		if(root == null) {
			return tail;
		}
		TreeNode cur = root;
		if(cur.left != null) {
			tail = BSTtoDVL(cur.left, tail);
		}
		cur.left = tail; 
		if(tail != null) {
			tail.right = cur;
			//tail = cur;
			//cur.left ���������� tail
			//cur.left = tail;
		}
		//Ҳ����tail == null, ��ֻ��ִ��һ�Σ�tailΪ��
		tail = cur;
		
		
		if(cur.right != null) {
			tail = BSTtoDVL(cur.right, tail);
		}
		return tail;
	}
}