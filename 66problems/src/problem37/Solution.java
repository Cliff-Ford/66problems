package problem37;




/**
 * @author Cliff_Ford
 * ͳ��һ�����������������г��ֵĴ�����
 */
public class Solution {
	
	//���ַ����Ҹ����ֳ��ֵ�λ�ã�������ͳ�ƴ���
	public int GetNumberOfK(int [] array , int k) {
	       if(array == null || array.length == 0) {
	    	   return 0;
	       }
	       int index = getIndexOfK(array, 0, array.length-1, k);
	       if(index == -1) {
	    	   return 0;
	       }
	       int count = 0;
	       for(int i = index; i < array.length; i++) {
	    	   if(array[i]==k) {
	    		   count++;
	    		   continue;
	    	   }else {
	    		   break;
	    	   }
	       }
	       return count;
    }
	//end���������һ��Ԫ�ص��±�
	public int getIndexOfK(int [] array,int start,int end,int k) {
		if(start==end) {
			if(array[start] == k) {
				return start;
			}else {
				return -1;
			}
		}
		int mid = (start+end) / 2;
		
		if(k<=array[mid]) {
			int n = getIndexOfK(array, 0, mid, k);
			if(n != -1)
				return n;
		}
		
		return getIndexOfK(array, mid+1, end, k);
	}
}
