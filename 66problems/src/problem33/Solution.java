package problem33;


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
        if(index <= 1) {
        	return index;
        }
        //index >= 2
        int uglyNum[] = new int[index+1];
        uglyNum[0] = 0;
        uglyNum[1] = 1;
        
        return 0;
    }
	
	
}

