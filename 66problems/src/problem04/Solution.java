package problem04;



/**
 * @author Cliff_Ford
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution {
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		
		if(pre.length == 0 || in.length == 0 || pre.length != in.length) {
			return null;
		}
		int num = pre.length;
		int root = pre[0];
		//根节点在中序遍历中的索引,该索引值也代表左子树的节点数
		int rootIndex = findRoot(in, root);
		int leftTreeNodeNum = rootIndex;
		int rightTreeNodeNum = num - 1 - leftTreeNodeNum;
		//建立根节点
		TreeNode treeNode = new TreeNode(pre[0]);
		//构造右子树
		if(rightTreeNodeNum > 0) {
			treeNode.right = reConstructBinaryTree(rightTreePre(pre, rightTreeNodeNum), rightTreeIn(in, root, rightTreeNodeNum));
		}
		//构造左子树
		if(leftTreeNodeNum > 0) {
			treeNode.left = reConstructBinaryTree(leftTreePre(pre, leftTreeNodeNum), leftTreeIn(in, root, leftTreeNodeNum));
		}		
		return treeNode;
        
    }
	//左子树的前序遍历数组
	public int[] leftTreePre(int [] pre,int num) {
		int result[] = new int[num];
		int j = 0;
		for(int i = 1; i <=  num; i++) {
			result[j++] = pre[i];
		}
		return result;
	}
	//左子树的中序遍历数组
	public int[] leftTreeIn(int [] in,int root,int num) {
		int result[] = new int[num];
		int index = findRoot(in, root);
		for(int i = 0,j = 0; i < index; i++) {
			result[j++] = in[i];
		}
		return result;
	}
	//右子树的前序遍历数组
	public int[] rightTreePre(int [] pre,int num) {
		int result[] = new int[num];
		for(int j=0,i=pre.length-num; j < num; j++,i++) {
			result[j] = pre[i];
		}
		return result;
	}
	//右子树的中序遍历数组
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