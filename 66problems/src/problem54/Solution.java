package problem54;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Cliff_Ford
 * 
请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
输出描述:
如果当前字符流没有存在出现一次的字符，返回#字符。


 */
public class Solution {
	private StringBuffer sb = new StringBuffer();
	
	public void Insert(char ch)
    {
        sb.append(ch);
    }
  
    public char FirstAppearingOnce()
    {
    	char s[] = sb.toString().toCharArray();
    	Map<Character, Integer> char_num = new LinkedHashMap<>();
    	int len = s.length;
    	for(int i = 0; i < len; i++) {
    		if(char_num.containsKey(s[i])) {
    			int num = char_num.get(s[i]);
    			char_num.put(s[i], num+1);
    		}else {
    			char_num.put(s[i], 1);
    		}
    	}
    	for(Character key : char_num.keySet()) {
    		if(char_num.get(key)==1) {
    			return key;
    		}
    	}
    	return '#';
    }

}

 