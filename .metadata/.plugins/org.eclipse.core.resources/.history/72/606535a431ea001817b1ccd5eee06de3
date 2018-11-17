package problem28;





/**
 * @author Cliff_Ford
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution {
	//估计会超时
	public int MoreThanHalfNum_SolutionII(int [] array) {
		int result = 0;
        if(array.length == 0) {
        	return result;
        }
        int len = array.length;
        int half = len / 2;
        int count = 0;
        for(int i = 0; i < len; i++) {
        	count = 0;
        	result = array[i];
        	for(int j = i; j < len; j++) {
        		if(array[j] == result) {
        			count++;
        			if(count > half) {
        				return result;
        			}
        		}
        	}
        }
        return count>half?result:0;
    }
	
	//最好的解法
	int MoreThanHalfNum_SolutionIII(int [] array) {
        int n = array.length;
        if (n == 0) return 0;
         
        int num = array[0], count = 1;
        for (int i = 1; i < n; i++) {
            if (array[i] == num) count++;
            else count--;
            if (count == 0) {
                num = array[i];
                count = 1;
            }
        }
        // Verifying
        count = 0;
        for (int i = 0; i < n; i++) {
            if (array[i] == num) count++;
        }
        if (count * 2 > n) return num;
        return 0;
    }
	
	public int MoreThanHalfNum_Solution(int [] array) {
		int result = 0;
        if(array.length == 0) {
        	return result;
        }
        int len = array.length;
        int half = len / 2;
        quick_sort(array, 0, len-1);
        result = array[0];
        int count = 0;
        for(int i = 0; i < len; i++) {
        	if(result == array[i]) {
        		count++;
        		if(count > half) {
    				return result;
    			}
        	}else {
        		count = 1;
        		result = array[i];
        	}
        }
        
        return count>half?result:0;
    }
	
	//输入一个数组，将该数组排好序
	public void quick_sort(int [] array,int start,int end) {
		
		int low = start;
		int high = end;
		int key = array[start];
		while(low<high) {
			while(low<high && array[high]>=key) {
				high--;
			}
			if(low<high) {
				int t = array[high];
				array[high] = array[low];
				array[low] = t;
				low++;
			}
			while(low<high && array[low]<=key) {
				low++;
			}
			if(low<high) {
				int t = array[high];
				array[high] = array[low];
				array[low] = t;
				high--;
			}
		}
		if(low>start) {
			quick_sort(array, start, low-1);
		}
		if(high<end) {
			quick_sort(array, high+1, end);
		}
	}
	
}