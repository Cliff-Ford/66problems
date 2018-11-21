package problem42;

import java.util.ArrayList;

/**
 * @author Cliff_Ford
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 
 * 对应每个测试案例，输出两个数，小的先输出。
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
        		//防止数组越界
        		if(i+1<len) {
        			int bIndex = getIndexOfK(array, i+1, len-1, b);
            		if(bIndex!=-1) {
            			result.add(a);
            			result.add(b);
            			return result;
            		}    
        		}else {
        			//此时的i是数组的最后一个下标
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
	
	//更好的做法
	 /*数列满足递增，设两个头尾两个指针i和j，
	 若ai + aj == sum，就是答案（相差越远乘积越小）
	 若ai + aj > sum，aj肯定不是答案之一（前面已得出 i 前面的数已是不可能），j -= 1
	 若ai + aj < sum，ai肯定不是答案之一（前面已得出 j 后面的数已是不可能），i += 1
	 O(n) */
}

