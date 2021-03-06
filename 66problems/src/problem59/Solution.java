package problem59;

import java.util.ArrayList;

import java.util.LinkedList;
import java.util.Queue;



/**
 * @author Cliff_Ford
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
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
			if(flag==false) {  //左到右
				result.add(new ArrayList<>(floor));
			}else {            //右到左
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

 