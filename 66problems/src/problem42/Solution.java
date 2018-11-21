package problem42;

import java.util.ArrayList;

/**
 * @author Cliff_Ford
 * ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S��
 * ����ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
 * 
 * ��Ӧÿ�����԰����������������С���������
 */
public class Solution {
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> result = new ArrayList<>();
        if(array == null || array.length <= 1 || array[0] >= sum) {
        	return result;
        }
        int len = array.length;
        for(int i = 0; i < len; i++) {
        	int a = array[i];
        	int b = sum - a;
        	if(b>0) {
        		//��ֹ����Խ��
        		if(i+1<len) {
        			int bIndex = getIndexOfK(array, i+1, len-1, b);
            		if(bIndex!=-1) {
            			result.add(a);
            			result.add(b);
            			return result;
            		}    
        		}else {
        			//��ʱ��i����������һ���±�
        			if(array[i]==b) {
        				result.add(a);
            			result.add(b);
            			return result;
        			}
        		}        				
        	}        	
        } 
        return result;
    }
	public int getIndexOfK(int [] array,int start,int end,int k) {
		if(start==end) {
			if(array[start]==k) {
				return start;
			}else {
				return -1;
			}
		}
		int mid = (start+end)/2;
		if(k<=array[mid]) {
			int n = getIndexOfK(array, start, mid, k);
			if(n!=-1) {
				return n;
			}
		}
		return getIndexOfK(array, mid+1, end, k);
	}
	
	//���õ�����
	 /*�������������������ͷβ����ָ��i��j��
	 ��ai + aj == sum�����Ǵ𰸣����ԽԶ�˻�ԽС��
	 ��ai + aj > sum��aj�϶����Ǵ�֮һ��ǰ���ѵó� i ǰ��������ǲ����ܣ���j -= 1
	 ��ai + aj < sum��ai�϶����Ǵ�֮һ��ǰ���ѵó� j ����������ǲ����ܣ���i += 1
	 O(n) */
}

