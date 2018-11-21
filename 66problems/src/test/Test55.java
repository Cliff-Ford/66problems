package test;






import org.junit.Test;

import problem55.ListNode;
import problem55.Solution;




public class Test55 {
	@Test
	public void test() {
		Solution solution = new Solution();
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(2);
		ListNode t3 = new ListNode(3);
		ListNode t4 = new ListNode(4);
		ListNode t5 = new ListNode(5);
		ListNode t6 = new ListNode(6);
		t1.next = t2;
		t2.next = t3;
		t3.next = t4;
		t4.next = t5;
		t5.next = t6;
		System.out.println(solution.EntryNodeOfLoop(t1));
		t6.next = t4;
		System.out.println(solution.EntryNodeOfLoop(t1).val);
	}
	
	
}
