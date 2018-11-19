package problem36;




/**
 * @author Cliff_Ford
 * 输入两个链表，找出它们的第一个公共结点。
 *  
 *  
 *  公共节点是指两个链表的交点，不是第一个值相等的点
 */
public class Solution {
	
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 if(pHead1 == null || pHead2 == null) {
			 return null;
		 }
		 int n1 = 0;
		 int n2 = 0;
		 ListNode p1 = pHead1;
		 ListNode p2 = pHead2;
		 while(p1 != null) {
			 p1 = p1.next;
			 n1++;
		 }
		 while(p2 != null) {
			 p2 = p2.next;
			 n2++;
		 }
		 int n = n1 > n2 ? n1 - n2 : n2 - n1;
		 p1 = pHead1;
		 p2 = pHead2;
		 if(n > 0) {
			 if(n1 > n2) {
				 while(n>0) {
					 p1 = p1.next;
					 n--;
				 }
			 }else {
				 while(n>0) {
					 p2 = p2.next;
					 n--;
				 }
			 }
		 }
		 while(p1!=null && p2!=null) {
			 if(p1 == p2) {
				 return p1;
			 }
			 p1 = p1.next;
			 p2 = p2.next;
		 }
		 return null;
    }
}

