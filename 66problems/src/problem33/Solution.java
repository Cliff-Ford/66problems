package problem33;

import java.util.ArrayList;

/**
 * @author Cliff_Ford
 * ��ֻ����������2��3��5��������������Ugly Number����
 * ����6��8���ǳ�������14���ǣ���Ϊ������������7��
 *  ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 *  
 *  
 *  ע��������  �����Ǹ���
 */
public class Solution {
	
	//����  ��ʱ
	public int GetUglyNumber_Solution(int index) {
        if(index<=0) {
        	return 0;
        }
        if(index==1) {
        	return 1;
        }
        ArrayList<Integer> uglyNumSet = new ArrayList<>();
        uglyNumSet.add(1);
        int i2 = 0;
        int i3 = 0;
        int i5 = 0;
        for(int i = 2; i <= index; i++) {
        	int r = min(uglyNumSet.get(i2)*2, min(uglyNumSet.get(i3)*3, uglyNumSet.get(i5)*5));
        	if(uglyNumSet.get(i2)*2==r) {
        		i2++;
        	}
        	if(uglyNumSet.get(i3)*3==r) {
        		i3++;
        	}
        	if(uglyNumSet.get(i5)*5==r) {
        		i5++;
        	}
        	uglyNumSet.add(r);
        }
        int result = uglyNumSet.get(index-1);
        return result;
    }
	
	public int min(int a,int b) {
		return a>b?b:a;
	}
	
}

