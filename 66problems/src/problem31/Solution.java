package problem31;


/**
 * @author Cliff_Ford
 * ���1~13��������1���ֵĴ���,�����100~1300��������1���ֵĴ�����
 * Ϊ�����ر�����һ��1~13�а���1��������1��10��11��12��13��˹�����6��
 * ���Ƕ��ں�����������û���ˡ�ACMerϣ�����ǰ����,������������ձ黯,
 * ���Ժܿ���������Ǹ�����������1���ֵĴ�������1 �� n ��1���ֵĴ�������
 */
public class Solution {
	//�����ⷨ
	//��ѧ���ɽⷨ���ⲻ��
	public int NumberOf1Between1AndN_Solution(int n) {
	    if(n == 0) {
	    	return 0;
	    }
	    if(n == 1) {
	    	return 1;
	    }
	    int count = 1;
	    for(int i = 10; i <= n; i++) {
	    	int val = i;
	    	while(val>0) {
	    		if(val%10==1) {
		    		count++;
		    	}
	    		val = val / 10;
	    	}	
	    }
	    return count;
    }
	
}
