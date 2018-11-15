package problem07;


/**
 * @author Cliff_Ford
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39 
 */
public class Solution {
	private static int fibonacci[] = new int[40];
	static {
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		for(int i = 2; i <= 39; i++) {
			fibonacci[i] = fibonacci[i-1] + fibonacci[i-2];
		}
		
	}
	public int Fibonacci(int n) {
		return fibonacci[n];
    }
}	