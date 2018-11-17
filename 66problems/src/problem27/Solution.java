package problem27;

import java.util.ArrayList;
import java.util.Collections;



/**
 * @author Cliff_Ford
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С�
 * ���������ַ���abc,
 * ���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 * 
 * ����һ���ַ���,���Ȳ�����9(�������ַ��ظ�),�ַ�ֻ������Сд��ĸ
 */
public class Solution {
	//����ǵݹ�Ĳ���д��
	//��һ�ַ���ʱ�ݹ�Ľ���
	public ArrayList<String> Permutation(String str) {
		   ArrayList<String> list = new ArrayList<>();
	       if(str.length() == 0) {
	    	   return list;
	       }
	       if(str.length() == 1) {
	    	   list.add(str);
	    	   return list;
	       }
	       int len = str.length();
	       // if(len>1)
	       ArrayList<String> temp = Permutation(str.substring(0, len-1));
	       char last = str.charAt(len-1);
	       for(String t : temp) {
	    	   StringBuffer sb = new StringBuffer(t);
	    	   for(int i = 0; i <= sb.length(); i++) {
	    		   String r = sb.insert(i, last).toString();
	    		   if(!list.contains(r)) {
	    			   list.add(r);
	    		   }
	    		   sb.deleteCharAt(i);
	    	   }
	       }
	       Collections.sort(list);
	       return list;
    }
}