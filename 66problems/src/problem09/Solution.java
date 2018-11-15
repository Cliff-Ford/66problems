package problem09;


/**
 * @author Cliff_Ford
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution {
	public int JumpFloorII(int target) {
		if(target <= 0) {
			return 0;
		}
		if(target == 1) {
			return 1;
		}
		if(target == 2) {
			return 2;
		}
		//一步走完是一种情况
		int result = 1;
		int i = 1;
		//迭代非一步走完的情况
		while(i<=target) {
			result = result + JumpFloorII(target-i);
			i++;
		}
		return result;
    }
}	