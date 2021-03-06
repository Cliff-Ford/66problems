package problem27;

import java.util.ArrayList;
import java.util.Collections;



/**
 * @author Cliff_Ford
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母
 */
public class Solution {
	//这个是递归的插入写法
	//另一种方法时递归的交换
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