package problem07;


/**
 * @author Cliff_Ford
 * ��Ҷ�֪��쳲��������У�����Ҫ������һ������n���������쳲��������еĵ�n���0��ʼ����0��Ϊ0����
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