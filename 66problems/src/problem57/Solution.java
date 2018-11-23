package problem57;



/**
 * @author Cliff_Ford
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
 * ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
 */
public class Solution {
	public TreeLinkNode GetNext(TreeLinkNode pNode){
		if(pNode==null) {
			return null;
		}
		//�ýڵ����Һ��ӣ�����һ���ڵ����Һ��ӵ�����ڵ�
		if(pNode.right!=null) {
			TreeLinkNode t = pNode.right;
			while(t.left!=null) {
				t = t.left;
			}
			return t;
		}
		//�ýڵ�û���Һ��ӣ�����һ���ڵ��Ǹ��ڵ�,���߸��ڵ�ĸ��ڵ㣬�������ڵ㲻Ϊ�յĻ�
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

 