package problem49;


/**
 * @author Cliff_Ford
 * 将一个字符串转换成一个整数(实现Integer.valueOf(string)的功能，
 * 但是string不符合数字要求时返回0)，要求不能使用字符串转换整数的库函数。 
 * 数值为0或者字符串不是一个合法的数值则返回0。
 * 
 * input输入一个字符串,包括数字字母符号,可以为空
 * +2147483647
    1a33
    
    output如果是合法的数值表达则返回该数字，否则返回0
    2147483647
    0
 */
public class Solution {
	public int StrToInt(String str) {
        if(str==null || str.length()==0) {
        	return 0;
        }
        int len = str.length();
        char s[] = str.toCharArray();
        int result = 0;
        boolean isPositive = false;
        boolean isNegative = false;
        int i = 0;
        if(s[0]=='+') {
        	isPositive = true;
        	i++;
        }else if(s[0]>='1') {
        	isPositive = true;
        	result = s[0]-'0';
        	i++;
        }else if(s[0]=='-') {
        	isNegative = true;
        	i++;
        }
        //排除0 01234的情况
        if(isNegative==false && isPositive==false) {
        	return 0;
        }
        
        for(; i < len; i++) {
        	if(s[i]>='0'&&s[i]<='9') {
        		result = result * 10 + (s[i]-'0');
        	}else if(s[i]=='.') {
        		//12.0   12.00000  12.00001
        		if(i+1<len && s[i+1]>='1') {
        			return 0;
        		}
        		int t = i + 1;
        		while(t<len) {
        			if(s[t]=='0') {
        				t++;
        			}else {
        				return 0;
        			}
        		}
        		if(isPositive==true) {
        			return result;
        		}else {
        			return -result;
        		}
        		
        	}else {
        		return 0;
        	}
        }
        if(isPositive==true) {
        	return result;
        }
        return -result;
    }
}

 