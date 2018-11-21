package problem54;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Cliff_Ford
 * 
��ʵ��һ�����������ҳ��ַ����е�һ��ֻ����һ�ε��ַ���
���磬�����ַ�����ֻ����ǰ�����ַ�"go"ʱ����һ��ֻ����һ�ε��ַ���"g"��
���Ӹ��ַ����ж���ǰ�����ַ���google"ʱ����һ��ֻ����һ�ε��ַ���"l"��
�������:
�����ǰ�ַ���û�д��ڳ���һ�ε��ַ�������#�ַ���


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

 