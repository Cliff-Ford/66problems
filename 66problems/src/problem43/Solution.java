package problem43;


/**
 * @author Cliff_Ford
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class Solution {
	public String LeftRotateString(String str,int n) {
		if(str == null) {
			return null;
		}
        int len = str.length();
        if(len == 0 || n == 0) {
        	return str;
        }
        n = n % len;
        char s[] = str.toCharArray();
        char move[] = new char[n];
        for(int i = 0; i < n; i++) {
        	move[i] = s[i];
        }
        int j = 0;
        for(int i = n; i < len; i++) {
        	s[j++] = s[i];
        }
        int k = 0;
        for(int i = j; i < len; i++) {
        	s[i] = move[k++];
        }
        return String.valueOf(s);
    }
}

