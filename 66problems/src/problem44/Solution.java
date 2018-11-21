package problem44;

import java.util.ArrayList;



/**
 * @author Cliff_Ford
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
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
        //确认第一个单词的最后一个字母的位置
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

