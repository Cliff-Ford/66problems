package test;



import org.junit.Test;

import problem15.ListNode;
import problem15.Solution;




public class Test15 {
	@Test
	public void test() {
		Solution solution = new Solution();
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		solution.Reverse(listNode1);
		ListNode listNode = solution.ReverseList(listNode1);
		solution.Reverse(listNode);
	}
}
