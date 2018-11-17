package problem30;


/**
 * @author Cliff_Ford
 * HZż������Щרҵ������������Щ�Ǽ����רҵ��ͬѧ��
 * ��������鿪����,���ַ�����:�ڹ��ϵ�һάģʽʶ����,������Ҫ��������������������,
 * ������ȫΪ������ʱ��,����ܺý����
 * ����,��������а�������,�Ƿ�Ӧ�ð���ĳ������,�������Աߵ��������ֲ����أ�
 * ����:{6,-3,-2,7,-15,1,2,2},����������������Ϊ8(�ӵ�0����ʼ,����3��Ϊֹ)��
 * ��һ�����飬��������������������еĺͣ���᲻�ᱻ������ס��(�������ĳ���������1)
 */
public class Solution {
	
	public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        if(len == 1) {
        	return array[0];
        }
        int curSum = array[0];
        int maxSum = array[0];
        for(int i = 1; i < len; i++) {
        	curSum = curSum + array[i];
        	
        	//�����ǰֵ�ȵ�ǰ�ʹ󣬴ӵ�ǰֵ��ʼͳ���������
    		if(array[i] >= curSum) {
    			curSum = array[i];
    		}
        	
        	if(curSum >= maxSum) {
        		//��ǰ�ͱ����ʹ�
        		
        		
        		maxSum = curSum;
        	}
        	
        }
        return maxSum;
    }
	
}
