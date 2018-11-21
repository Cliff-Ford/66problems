package test;






import org.junit.Test;

import problem56.ListNode;
import problem56.Solution;




public class Test56 {
	@Test
	public void test() {
		Solution solution = new Solution();
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(2);
		ListNode t3 = new ListNode(3);
		ListNode t4 = new ListNode(3);
		ListNode t5 = new ListNode(4);
		ListNode t6 = new ListNode(4);
		ListNode t7 = new ListNode(5);
		t1.next = t2;
		t2.next = t3;
		t3.next = t4;
		t4.next = t5;
		t5.next = t6;
		t6.next = t7;
		// 1 2 3 3 4 4 5
		System.out.println(solution.deleteDuplication(t1).val);
		ListNode t33 = new ListNode(3);
		t4.next = t33;
		t33.next = t5;
		// 1 2 3 3 3 4 4 5
		System.out.println(solution.deleteDuplication(t1).val);
		ListNode t0 = new ListNode(1);
		t0.next = t1;
		//1 1 2 3 3 3 4 4 5
		System.out.println(solution.deleteDuplication(t0).val);
	}
	@Test
	public void test2() {
		Solution solution = new Solution();
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(1);
		ListNode t3 = new ListNode(2);
		ListNode t4 = new ListNode(2);
		ListNode t5 = new ListNode(2);
		t1.next = t2;
		//1 1 
		System.out.println(solution.deleteDuplication(t1));
		t2.next = t3;
		// 1 1 2
		System.out.println(solution.deleteDuplication(t1).val);
		t3.next = t4;
		// 1 1 2 2
		System.out.println(solution.deleteDuplication(t1));
		t4.next = t5;
		// 1 1 2 2 2
		System.out.println(solution.deleteDuplication(t1));
	}
	
	@Test
	public void test3() {
		Solution solution = new Solution();
		ListNode t1 = new ListNode(1);
		ListNode t2 = new ListNode(1);
		ListNode t3 = new ListNode(2);
		ListNode t4 = new ListNode(3);
		ListNode t5 = new ListNode(3);
		ListNode t6 = new ListNode(4);
		ListNode t7 = new ListNode(5);
		ListNode t8 = new ListNode(5);
		ListNode t9 = new ListNode(5);
		ListNode t10 = new ListNode(6);
		t1.next = t2;		
		t2.next = t3;		
		t3.next = t4;		
		t4.next = t5;
		t5.next = t6;		
		t6.next = t7;
		t7.next = t8;
		t8.next = t9;
		t9.next = t10;
		// 1 1 2 3 3 4 5 5 5 6
		//result 2 4 6
		ListNode result = solution.deleteDuplication(t1);
		while(result!=null) {
			System.out.print(result.val);
			result = result.next;
		}
	}
	
	
	
}