package problem53;


/**
 * @author Cliff_Ford
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。 
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution {
	public boolean isNumeric(char[] str) {
		if(str.length==0) {
			return false;
		}
		int i = 0;
		//记录str数组的当前索引位置
		int flag = 0;
		int len = str.length;
		boolean isPositive = true;
		if(str[0]=='+') {
			isPositive = true;
			i++;
			flag++;
		}
		if(str[0]=='-') {
			isPositive = false;
			i++;
			flag++;
		}
		double result = 0;
		double beforeDoc = 0;
		double afterDoc = 0;
		double afterE = 0;
		//小数点之前的部分
		for(; i < len && str[i]!='.' && str[i]!='e' && str[i]!='E' && str[i]!='+' && str[i]!='-'; i++,flag++) {
			if(str[i]>='0' && str[i]<='9') {
				beforeDoc = beforeDoc * 10 + (str[i] - '0');
			}else {
				break;
			}
		}
		int j = i;
		if(j<len && str[i]=='.') {
			
			j++;
			flag++;
			//小数点后面部分
			for(; j < len && str[j]!='e' && str[j]!='E' && str[j]!='+' && str[j]!='-'; j++,flag++) {
				if(str[j]>='0' && str[j]<='9') {
					afterDoc = afterDoc * 10 + (str[j]-'0');
				}else {
					break;
				}
			}
		}
		afterDoc = afterDoc * Math.pow(10.0, -Double.valueOf(j-i-1));
		result = beforeDoc + afterDoc;
		if(isPositive==false) {
			result = -result;
		}
		int k = j;
		boolean isPositiveAfterE = true;
		if(k<len && (str[k]=='e' || str[k]=='E')) {
			k++;
			flag++;
			//e后面部分
			//e后面可能有+-符号
			if(k<len && str[k]=='+') {
				k++;
				flag++;
			}
			if(k<len && str[k]=='-') {
				k++;
				flag++;
				isPositiveAfterE = false;
			}
			for(; k < len && str[k]!='.' && str[k]!='+' && str[k]!='-'; k++,flag++) {
				if(str[k]>='0' && str[k]<='9') {
					afterE = afterE * 10 + (str[k]-'0');
				}else {
					break;
				}
			}
			// 12e e后面没有数字
			if(k-1<len && (str[k-1]=='e' || str[k-1]=='E')) {
				return false;
			}
		}
		
		if(isPositiveAfterE==true) {
			result = result * Math.pow(10.0, afterE);
		}else {
			result = result * Math.pow(10.0, -afterE);
		}
		
		
		
		if(flag==len) {
			System.out.print(result  + "   ");
			return true;
		}
		return false;
        
    }

}

 