package problem20;

import java.util.Stack;

/**
 * @author Cliff_Ford
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Solution {
	public Stack<Integer> data = new Stack<>();
	public Stack<Integer> min = new Stack<>();
	public int count = 0;
	public void push(int node) {
		//每添加一个数据，都会计算出data中最小的值放入min栈中
		if(count == 0) {
			data.push(node);
			min.push(node);
			
		}else {
			data.push(node);
			if(node <= min.peek()) {
				min.push(node);
			}else {
				min.push(min.peek());
			}
		}
		count++;
    }
    
    public void pop() {
        data.pop();
        min.pop();
        count--;
    }
    
    public int top() {
        return data.peek();
    }
    
    public int min() {
        return min.peek();
    }
}