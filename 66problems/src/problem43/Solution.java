package problem43;


/**
 * @author Cliff_Ford
 * �����������һ����λָ�����ѭ�����ƣ�ROL���������и��򵥵�����
 * �������ַ���ģ�����ָ���������������һ���������ַ�����S��
 * �������ѭ������Kλ������������
 * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ����
 * ����XYZdefabc�����ǲ��Ǻܼ򵥣�OK���㶨����
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

