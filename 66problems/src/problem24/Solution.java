package problem24;

import java.util.ArrayList;




/**
 * @author Cliff_Ford
 * ����һ�Ŷ������ĸ��ڵ��һ��������
 * ��ӡ���������н��ֵ�ĺ�Ϊ��������������·����
 * ·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 * (ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
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
        //target��ֵ���ݣ��������target�Ǳ仯�˵�
        FindPath(root.left, target);
        FindPath(root.right, target);
        path.remove(path.size()-1);
        return allPath;
    }
	
	
	//����������Դ�һ���ڵ㿪ʼ�����ң��ҵ�һ����Ŀ��ֵ��ȵ�����·��
	//���������·�������һ���ڵ�Ķ��岻һ������Ŀ����˵��Ҷ�ӽڵ㣬�������������˺ܾ�
	
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