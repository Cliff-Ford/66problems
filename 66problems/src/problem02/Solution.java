package problem02;


/**
 * @author Cliff_Ford
 * ��ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
    	for(int i = 0; i < str.length(); i++) {
    		if(str.charAt(i) == ' ') {
    			str.replace(i, i+1, "%20");
    			i = i + 2;
    		}
    	}
    	return str.toString();
    }
}