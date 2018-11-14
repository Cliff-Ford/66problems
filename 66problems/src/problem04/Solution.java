package problem04;



/**
 * @author Cliff_Ford
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö�������
 * ���������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 */
public class Solution {
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		
		if(pre.length == 0 || in.length == 0 || pre.length != in.length) {
			return null;
		}
		int num = pre.length;
		int root = pre[0];
		//���ڵ�����������е�����,������ֵҲ�����������Ľڵ���
		int rootIndex = findRoot(in, root);
		int leftTreeNodeNum = rootIndex;
		int rightTreeNodeNum = num - 1 - leftTreeNodeNum;
		//�������ڵ�
		TreeNode treeNode = new TreeNode(pre[0]);
		//����������
		if(rightTreeNodeNum > 0) {
			treeNode.right = reConstructBinaryTree(rightTreePre(pre, rightTreeNodeNum), rightTreeIn(in, root, rightTreeNodeNum));
		}
		//����������
		if(leftTreeNodeNum > 0) {
			treeNode.left = reConstructBinaryTree(leftTreePre(pre, leftTreeNodeNum), leftTreeIn(in, root, leftTreeNodeNum));
		}		
		return treeNode;
        
    }
	//��������ǰ���������
	public int[] leftTreePre(int [] pre,int num) {
		int result[] = new int[num];
		int j = 0;
		for(int i = 1; i <=  num; i++) {
			result[j++] = pre[i];
		}
		return result;
	}
	//�������������������
	public int[] leftTreeIn(int [] in,int root,int num) {
		int result[] = new int[num];
		int index = findRoot(in, root);
		for(int i = 0,j = 0; i < index; i++) {
			result[j++] = in[i];
		}
		return result;
	}
	//��������ǰ���������
	public int[] rightTreePre(int [] pre,int num) {
		int result[] = new int[num];
		for(int j=0,i=pre.length-num; j < num; j++,i++) {
			result[j] = pre[i];
		}
		return result;
	}
	//�������������������
	public int[] rightTreeIn(int [] in,int root,int num) {
		int result[] = new int[num];
		int index = findRoot(in, root);
		for(int i = index + 1,j = 0; j < num; i++) {
			result[j++] = in[i];
		}
		return result;
	}
	public int findRoot(int [] array,int target) {
		for(int i = 0; i < array.length; i++) {
			if(target == array[i]) {
				return i;
			}
		}
		return -1;
	}
}	