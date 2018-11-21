package problem59;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;



/**
 * @author Cliff_Ford
 * ��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ��
 * �ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
 */
public class Solution {
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
		ArrayList<Integer> floor = new ArrayList<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		if(pRoot==null) {
			return result;
		}
		
		Queue<TreeNode> queue = new LinkedList<>();
		TreeNode p = pRoot;		
		queue.offer(p);
		int numOfNodeInThisFloor = 1;
		int numOfNodeInNextFloor = 0;
		
		boolean flag = false;
		while(!queue.isEmpty()) {
			numOfNodeInNextFloor = 0;
			while(numOfNodeInThisFloor!=0) {
				
				TreeNode t = queue.poll();
				numOfNodeInThisFloor--;
				floor.add(t.val);
			
				if(t.left!=null) {
					queue.offer(t.left);
					numOfNodeInNextFloor++;
				}
				if(t.right!=null) {
					queue.offer(t.right);
					numOfNodeInNextFloor++;
				}
				
			}
			
			numOfNodeInThisFloor = numOfNodeInNextFloor;
			if(flag==false) {  //����
				result.add(new ArrayList<>(floor));
			}else {            //�ҵ���
				floor = reverse(floor);
				result.add(new ArrayList<>(floor));
			}
			flag = !flag;
			floor.removeAll(floor);
		}
		return result;
    }
	public ArrayList<Integer> reverse(ArrayList<Integer> a){
		ArrayList<Integer> b = new ArrayList<>();
		for(int i = a.size()-1; i >= 0; i--) {
			b.add(a.get(i));
		}
		return b;
	}
}

 