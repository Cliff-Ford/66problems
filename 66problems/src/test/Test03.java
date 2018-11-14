package test;

import java.util.ArrayList;

import org.junit.Test;


import problem03.ListNode;
import problem03.Solution;

public class Test03 {
	@Test
	public void test() {
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		ListNode listNode3 = new ListNode(3);
		listNode1.setNext(listNode2);
		listNode2.setNext(listNode3);
		Solution solution = new Solution();
		ArrayList<Integer> arrayList = solution.printListFromTailToHead2(listNode1);
		for (Integer integer : arrayList) {
			System.out.println(integer);
		}
	}
	@Test
	public void test1() {
		ListNode listNode1 = null;
		Solution solution = new Solution();
		ArrayList<Integer> arrayList = solution.printListFromTailToHead(listNode1);
		for (Integer integer : arrayList) {
			System.out.println(integer);
		}
	}
}
