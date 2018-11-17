package problem21;

import java.util.Stack;

/**
 * @author Cliff_Ford
 * ���������������У���һ�����б�ʾջ��ѹ��˳��
 * ���жϵڶ��������Ƿ����Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳��
 * ����4,5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 */
public class Solution {
	public boolean IsPopOrder(int [] pushA,int [] popA) {
		if(pushA.length == 0 || popA.length == 0) {
			return false;
		}
		if(pushA.length != popA.length) {
			return false;
		}
		int len = pushA.length;
		int i = 0;
		int j = 0;
	    Stack<Integer> stack = new Stack<>();
	    stack.push(pushA[i++]);
	    while(i < len) {
	    	if(stack.peek() == popA[j]) {
	    		stack.pop();
	    		j++;
	    	}else {
	    		stack.push(pushA[i++]);
	    	}	    	
	    }
	    while(j < len) {
	    	if(stack.peek() == popA[j]) {
	    		stack.pop();
	    		j++;
	    	}else {
	    		break;
	    	}
	    }
	    if(stack.isEmpty()) {
	    	return true;
	    }
	    return false;
    }
}