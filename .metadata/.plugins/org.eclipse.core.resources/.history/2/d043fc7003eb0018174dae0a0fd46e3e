package problem34;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Cliff_Ford
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 * 
 * 空间换时间
 */
public class Solution {
	
	public int FirstNotRepeatingChar(String str) {
		
		if(str.length()==0) {
			return -1;
		}
		Map<Character,Integer> char_num = new LinkedHashMap<>();
		char s[] = str.toCharArray();
		for(int i = 0; i < s.length; i++) {
			
			if(char_num.containsKey(s[i])) {
				int n = char_num.get(s[i]) + 1;
				char_num.put(s[i], n);
			}else {
				char_num.put(s[i], 1);
			}
		}
		Character k = null;
		for(Character key : char_num.keySet()) {
			if(char_num.get(key)==1) {
				k = key;
				break;
			}
		}
		if(k != null) {
			for(int i = 0; i < s.length; i++) {
				if(s[i] == k) {
					return i;
				}
			}
		}
		
        return -1;
    }
	
}

