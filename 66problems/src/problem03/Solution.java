package problem03;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Cliff_Ford
 * ����һ������������ֵ��β��ͷ��˳�򷵻�һ��ArrayList�� * 
 * public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 */
public class Solution {
	//�ݹ�ⷨ
	 public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		if(listNode == null) {
			return arrayList;
		}
	    if(listNode.next != null) {
	    	ArrayList<Integer> temp = printListFromTailToHead(listNode.next);	
	    	arrayList.addAll(temp);
	    }
	    arrayList.add(listNode.getVal());
		return arrayList;
	 }
	 //ջ�ⷨ
	 public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
		ArrayList<Integer> arrayList = new ArrayList<>();
		if(listNode == null) {
			return arrayList;
		}
		Stack<Integer> stack = new Stack<>();
		while(listNode != null) {
			stack.push(listNode.getVal());
			listNode = listNode.next;
		}
		while(!stack.isEmpty()) {
			arrayList.add(stack.pop());
		}
		return arrayList;
	 }
}	