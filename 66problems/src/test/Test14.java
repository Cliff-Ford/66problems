package test;



import org.junit.Test;

import problem14.ListNode;
import problem14.Solution;




public class Test14 {
	@Test
	public void test() {
		Solution solution = new Solution();
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		listNode1.next = listNode2;
		listNode2.next = listNode3;
		// 3 2 1
		for(int i = 1; i <= 3; i++) {
			System.out.println(solution.FindKthToTail(listNode1, i).val);
		}
	}
}