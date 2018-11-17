package problem22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cliff_Ford
 * �������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ��
 */
public class Solution {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> re = new ArrayList<>();
        if(root == null) {
        	return re;
        }
        TreeNode p = root;
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(p);
		while(!queue.isEmpty()) {
			if(queue.peek().left != null) {
				queue.offer(queue.peek().left);
			}
			if(queue.peek().right != null) {
				queue.offer(queue.peek().right);
			}
			re.add(queue.peek().val);
			queue.poll();
		}
        return re;
    }
	
}