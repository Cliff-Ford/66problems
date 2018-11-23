package problem33;

import java.util.ArrayList;

/**
 * @author Cliff_Ford
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 *  习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *  
 *  
 *  注意是求数  而不是个数
 */
public class Solution {
	
	//暴力  超时
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

