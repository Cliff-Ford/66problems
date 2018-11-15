package problem11;


/**
 * @author Cliff_Ford
 * ����һ��������������������Ʊ�ʾ��1�ĸ��������и����ò����ʾ��
 */
public class Solution {
    public int NumberOf1(int n) {
    	if(n == 0) {
    		return 0;
    	}
    	if(n == 1) {
    		return 1;
    	}
    	int count = 0;
    	if(n > 0) {
    		while(n != 0) {
    			//�ж�n�Ķ����Ʊ�ʾ�������һλ�ǲ���1
    			int flag = n & 1;
    			if(flag == 1) {
    				count++;
    			}    			
    			n = n >> 1;
    		}
    		return count;
    	}
    	if(n < 0) {
    		int flag = 1;
    		while(flag != 0) { 
    			int r = n & flag;
    			if(r != 0) {
    				count++;
    			}
    			flag = flag << 1;
    		}
    	}
    	return count;
    	/*int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;*/
    	/*int count = 0;
        while (n != 0) {
            ++count;
            n = (n - 1) & n;
        }
        return count;*/
    }
}