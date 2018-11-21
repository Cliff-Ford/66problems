package problem49;


/**
 * @author Cliff_Ford
 * ��һ���ַ���ת����һ������(ʵ��Integer.valueOf(string)�Ĺ��ܣ�
 * ����string����������Ҫ��ʱ����0)��Ҫ����ʹ���ַ���ת�������Ŀ⺯���� 
 * ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0��
 * 
 * input����һ���ַ���,����������ĸ����,����Ϊ��
 * +2147483647
    1a33
    
    output����ǺϷ�����ֵ����򷵻ظ����֣����򷵻�0
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
        //�ų�0 01234�����
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

 