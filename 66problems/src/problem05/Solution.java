package problem05;

import java.util.Stack;

/**
 * @author Cliff_Ford
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 */
public class Solution {
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    private int counter = 0;
    public void push(int node) {
        stack1.push(node);
        counter++;
    }
    
    public int pop() {
    	if(counter > 0) {
    		while(!stack1.isEmpty()) {
        		stack2.push(stack1.pop());    		
        	}
        	int result = stack2.pop();
        	while(!stack2.isEmpty()) {
        		stack1.push(stack2.pop());
        	}
        	counter--;
    		return result;
    	}
    	return 0;
    }
}	