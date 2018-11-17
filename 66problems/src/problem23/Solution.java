package problem23;


import java.util.Arrays;

/**
 * @author Cliff_Ford
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * 
 * 二叉搜索树的特点是所有根节点一定都比左孩子大，比右孩子小
 */
public class Solution {
	public boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence.length == 0) {
			return false;
		}
        if(sequence.length == 1) {
        	return true;
        }
        int root = sequence[sequence.length-1];
        int i = 0;
        //找出所有比根节点小的
        while(sequence[i] < root) {
        	i++;
        }
        int j = i;
        //找出所有比根节点大的
        while(sequence[j] > root) {
        	j++;
        }
        //还有遗漏说明不是二叉搜索树的后序遍历序列
        if(j != sequence.length-1) {
        	return false;
        }
        boolean l = false, r = false;
        
        if(i >= 1) {
        	//根节点左边至少有一个节点
        	l = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }else {
        	//左子树为空
        	l = true;
        }
        if(i <= sequence.length-2) {
        	//根节点右边至少有一个节点
        	r = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length-1));
        }else {
        	//右子树为空
        	r = true;
        }
        
        return l && r;
        
        
    }
}