package problem11;


/**
 * @author Cliff_Ford
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
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
    			//判断n的二进制表示数的最后一位是不是1
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