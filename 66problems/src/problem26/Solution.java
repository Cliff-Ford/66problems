package problem26;





/**
 * @author Cliff_Ford
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
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
	//二叉搜索树转换为双向链表,tail的初始值为null
	//tail的意义为已经构造好的双向链表的最后一个节点
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
			//cur.left 本来就连着 tail
			//cur.left = tail;
		}
		//也就是tail == null, 但只会执行一次，tail为空
		tail = cur;
		
		
		if(cur.right != null) {
			tail = BSTtoDVL(cur.right, tail);
		}
		return tail;
	}
}