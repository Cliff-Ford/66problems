package problem12;


/**
 * @author Cliff_Ford
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Solution {
	/*public double Power(double base, int exponent) {
        return Math.pow(base, (int)exponent);
	}*/
	public double Power(double base, int exponent) {
		if(exponent == 0) {
			return 1.0;
		}
		if(exponent == 1) {
			return base;
		}
		int n = Math.abs(exponent);
		double r = Power(base, n>>1);
		r = r * r;
		//奇数幂
		if((n&1) == 1) {
			r = r * base;
		}
		if(exponent < 0) {
			r = 1 / r;
		}
		return r;
	}
}