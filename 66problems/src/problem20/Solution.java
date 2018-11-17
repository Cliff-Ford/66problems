package problem20;

import java.util.Stack;

/**
 * @author Cliff_Ford
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��������СԪ�ص�min������ʱ�临�Ӷ�ӦΪO��1������
 */
public class Solution {
	public Stack<Integer> data = new Stack<>();
	public Stack<Integer> min = new Stack<>();
	public int count = 0;
	public void push(int node) {
		//ÿ���һ�����ݣ���������data����С��ֵ����minջ��
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