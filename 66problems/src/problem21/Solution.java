package problem21;

import java.util.Stack;

/**
 * @author Cliff_Ford
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
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