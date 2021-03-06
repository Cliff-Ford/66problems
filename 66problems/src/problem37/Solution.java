package problem37;




/**
 * @author Cliff_Ford
 * 统计一个数字在排序数组中出现的次数。
 */
public class Solution {
	
	//二分法查找该数字出现的位置，再往后统计次数
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
	//end是数组最后一个元素的下标
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

