package problem52;


/**
 * @author Cliff_Ford
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Solution {
	public boolean match(char[] str, char[] pattern){
		if(str.length==0 && pattern.length==0) {
			return true;
		}
        if(str==null || pattern==null || str.length==0 || pattern.length==0) {
        	return false;
        }
        int len = str.length;
        int j = 0;
        int i = 0;
        int patternLen = pattern.length;
        for(; i < len && j < patternLen; i++) {
        	if(str[i]==pattern[j] || pattern[j]=='.') {
        		j++;
        		if(j<patternLen && pattern[j]=='*') {
        			char c = str[i];
        			if(c!='.') {
        				
        				
						while(i+1<len && c==str[i+1]) {
	        				i++;
	        			}
    					
        				
	        			j++;
        			}else {
        				//  以 .*  的情况未处理
        				
        			}
        			
        		}
        	}else if(j+1<patternLen && pattern[j+1]=='*') {
    			//即使第一个匹配不上，i=-1,因为当前循环体结束时会+1,变成0,不会越界
        		i--;
        		if(j+2<patternLen) {
        			j = j + 2;
        		}else {
        			return false;
        		}    			
    		}else {
    			return false;
    		}
        }
        //去掉模式末尾多余的 a*b*c*
        for(; j < patternLen; j++) {
        	if(j+1<patternLen && pattern[j+1]=='*') {
        		j = j + 1;
        	}else {
        		return false;
        	}
        }
        
        if(i==len && j==patternLen) {
        	return true;
        }
        return false;
    }

}

 