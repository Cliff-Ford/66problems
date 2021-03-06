package problem60;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cliff_Ford
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class Solution {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
	    ArrayList<Integer> floor = new ArrayList<>();
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	    if(pRoot==null) {
	    	return result;
	    }
	    TreeNode p = pRoot;
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(p);
	    int numOfThisFloor = 1;
	    int numOfNextFloor = 0;
	    while(!queue.isEmpty()) {
	    	numOfNextFloor = 0;
	    	while(numOfThisFloor!=0) {
	    		TreeNode t = queue.poll();
	    		floor.add(t.val);
	    		numOfThisFloor--;
	    		if(t.left!=null) {
	    			queue.offer(t.left);
	    			numOfNextFloor++;
	    		}
	    		if(t.right!=null) {
	    			queue.offer(t.right);
	    			numOfNextFloor++;
	    		}	    		
	    	}
	    	result.add(new ArrayList<>(floor));
	    	floor.removeAll(floor);
	    	numOfThisFloor = numOfNextFloor;
	    }
	    return result;
    }
}

 