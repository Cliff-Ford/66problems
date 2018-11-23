package problem53;


/**
 * @author Cliff_Ford
 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 * ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ�� 
 * ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 */
public class Solution {
	public boolean isNumeric(char[] str) {
		if(str.length==0) {
			return false;
		}
		int i = 0;
		//��¼str����ĵ�ǰ����λ��
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
		//С����֮ǰ�Ĳ���
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
			//С������沿��
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
			//e���沿��
			//e���������+-����
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
			// 12e e����û������
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

 