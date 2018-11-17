package problem23;


import java.util.Arrays;

/**
 * @author Cliff_Ford
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ����
 * ����������Yes,�������No���������������������������ֶ�������ͬ��
 * 
 * �������������ص������и��ڵ�һ���������Ӵ󣬱��Һ���С
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
        //�ҳ����бȸ��ڵ�С��
        while(sequence[i] < root) {
        	i++;
        }
        int j = i;
        //�ҳ����бȸ��ڵ���
        while(sequence[j] > root) {
        	j++;
        }
        //������©˵�����Ƕ����������ĺ����������
        if(j != sequence.length-1) {
        	return false;
        }
        boolean l = false, r = false;
        
        if(i >= 1) {
        	//���ڵ����������һ���ڵ�
        	l = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }else {
        	//������Ϊ��
        	l = true;
        }
        if(i <= sequence.length-2) {
        	//���ڵ��ұ�������һ���ڵ�
        	r = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length-1));
        }else {
        	//������Ϊ��
        	r = true;
        }
        
        return l && r;
        
        
    }
}