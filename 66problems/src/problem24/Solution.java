package problem24;

import java.util.ArrayList;




/**
 * @author Cliff_Ford
 * 输入一颗二叉树的跟节点和一个整数，
 * 打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * (注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution {
	private ArrayList<Integer> path = new ArrayList<>();
	private ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();
	public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) {
        	return allPath;
        }
        path.add(root.val);
        target = target - root.val;
        if(target == 0 && root.left == null && root.right == null) {
        	allPath.add(new ArrayList<>(path));
        }
        //target是值传递，所以这个target是变化了的
        FindPath(root.left, target);
        FindPath(root.right, target);
        path.remove(path.size()-1);
        return allPath;
    }
	
	
	//这个方法可以从一个节点开始往下找，找到一条和目标值相等的最左路径
	//但是这里的路径的最后一个节点的定义不一定是题目中所说的叶子节点，所以在这里饶了很久
	
	public ArrayList<Integer> findPath(TreeNode root, int t) {
		ArrayList<Integer> path = new ArrayList<>();
		if(root == null || t == 0 || root.val > t) {
			return path;
		}
		if(root.val == t) {
			path.add(root.val);
			return path;
		}
		//root.val < t
		if(root.left != null && root.left.val <= t-root.val) {
			ArrayList<Integer> lp = findPath(root.left, t-root.val);
			path.add(root.val);
			path.addAll(lp);
			return path;
		}
		if(root.right != null && root.right.val <= t-root.val) {
			ArrayList<Integer> rp = findPath(root.right, t-root.val);
			path.add(root.val);
			path.addAll(rp);
			return path;
		}
		return path;
	}
}