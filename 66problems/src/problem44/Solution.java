package problem44;

import java.util.ArrayList;



/**
 * @author Cliff_Ford
 * ţ���������һ����Ա��Fish��ÿ���糿���ǻ�����һ��Ӣ����־��дЩ�����ڱ����ϡ�
 * ͬ��Cat��Fishд�������ĸ���Ȥ����һ������Fish������������ȴ������������˼��
 * ���磬��student. a am I������������ʶ������һ�ԭ���Ѿ��ӵ��ʵ�˳��ת�ˣ�
 * ��ȷ�ľ���Ӧ���ǡ�I am a student.����Cat��һһ�ķ�ת��Щ����˳��ɲ����У����ܰ�����ô��
 */
public class Solution {
	public String ReverseSentence(String str) {
        if(str == null) {
        	return null;
        }
        if(str.length() <= 1) {
        	return str;
        }
        
        char s[] = str.toCharArray();
        int len = s.length;
        ArrayList<ArrayList<Integer>> word_start_end = new ArrayList<>();
        ArrayList<Integer> start_end = new ArrayList<>();
        int lastWordEnd = len - 1;
        //ȷ�ϵ�һ�����ʵ����һ����ĸ��λ��
        for(int i = lastWordEnd; i >= 0; i--) {
        	if(s[i] != ' ') {
        		lastWordEnd = i;
        		break;
        	}
        }
        for(int i = lastWordEnd; i >= 0; i--) {
        	if(s[i] == ' ') {
        		start_end.add(i+1);
        		start_end.add(lastWordEnd);
        		word_start_end.add(new ArrayList<>(start_end));
        		start_end.removeAll(start_end);
        		if(i-1>=0) {
        			lastWordEnd = i - 1;
        		}        		
        	}else if(i == 0){
        		start_end.add(0);
        		start_end.add(lastWordEnd);
        		word_start_end.add(new ArrayList<>(start_end));
        		start_end.removeAll(start_end);
        	}
        }
        
        int j = 0;
        char result[] = new char[len];
        int spaceNumBeforeStr = (len-1)-word_start_end.get(0).get(1);
        while(spaceNumBeforeStr!=0) {
        	result[j++] = ' ';
        	spaceNumBeforeStr--;
        }
        for(ArrayList<Integer> w : word_start_end) {
        	int start = w.get(0);
        	
        	int end = w.get(1);
        	while(start<=end) {
        		result[j++] = s[start];
        		start++;
        	}
        	if(j!=len) {
        		result[j++] = ' ';
        	}
        	
        }
        return String.valueOf(result);
    }
}

