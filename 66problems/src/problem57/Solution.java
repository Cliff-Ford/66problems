package problem57;



/**
 * @author Cliff_Ford
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Solution {
	public TreeLinkNode GetNext(TreeLinkNode pNode){
		if(pNode==null) {
			return null;
		}
		//该节点有右孩子，则下一个节点是右孩子的最左节点
		if(pNode.right!=null) {
			TreeLinkNode t = pNode.right;
			while(t.left!=null) {
				t = t.left;
			}
			return t;
		}
		//该节点没有右孩子，则下一个节点是父节点,或者父节点的父节点，如果父类节点不为空的话
		TreeLinkNode cur = pNode;
		while(cur.next!=null) {
			TreeLinkNode parent = cur.next;
			if(parent.left==cur) {
				return parent;
			}
			cur = parent;
		}
		return null;
    }

}

 