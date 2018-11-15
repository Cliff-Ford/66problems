package problem12;


/**
 * @author Cliff_Ford
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
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
		//������
		if((n&1) == 1) {
			r = r * base;
		}
		if(exponent < 0) {
			r = 1 / r;
		}
		return r;
	}
}