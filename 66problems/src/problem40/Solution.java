package problem40;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Cliff_Ford
 * һ�����������������������֮�⣬���������ֶ�������ż���Ρ�
 * ��д�����ҳ�������ֻ����һ�ε����֡�
 * 
 * num1,num2�ֱ�Ϊ����Ϊ1�����顣��������
  *  ��num1[0],num2[0]����Ϊ���ؽ��
 */
public class Solution {
	
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        //�ռ任ʱ��
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

