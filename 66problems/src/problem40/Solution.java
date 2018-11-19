package problem40;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Cliff_Ford
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。
 * 请写程序找出这两个只出现一次的数字。
 * 
 * num1,num2分别为长度为1的数组。传出参数
  *  将num1[0],num2[0]设置为返回结果
 */
public class Solution {
	
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        //空间换时间
		if(array == null || array.length == 0) {
			num1[0] = 0;
			num2[0] = 0;
			return;
		}
		if(array.length == 1) {
			num1[0] = array[0];
			num2[0] = 0;
			return;
		}
		if(array.length == 2) {
			num1[0] = array[0];
			num2[0] = array[1];
			return;
		}
		int len = array.length;
		Map<Integer, Integer> num_count = new LinkedHashMap<>();
		for(int i = 0; i < len; i++) {
			if(num_count.containsKey(array[i])) {
				int count = num_count.get(array[i]) + 1;
				num_count.put(array[i], count);
			}else {
				num_count.put(array[i], 1);
			}
		}
		int n = 1;
		for(Integer key : num_count.keySet()) {
			
			if(num_count.get(key)==1) {
				if(n==1) {
					num1[0] = key;
					n = 2;
				}else {
					num2[0] = key;
					return;
				}
			}
		}
    }
}

