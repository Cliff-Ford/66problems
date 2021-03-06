package test;



import org.junit.Test;

import problem16.ListNode;
import problem16.Solution;




public class Test16 {
	@Test
	public void test() {
		Solution solution = new Solution();
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(5);
		ListNode listNode3 = new ListNode(7);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		
		ListNode listNode4 = new ListNode(2);
		ListNode listNode5 = new ListNode(3);
		ListNode listNode6 = new ListNode(8);
		listNode4.next = listNode5;
		listNode5.next = listNode6;
		
		ListNode result = solution.Merge(listNode4, listNode1);
		ListNode r = result;
		while(r!=null) {
			System.out.println(r.val);
			r = r.next;
		}
	}
}
