package test;






import org.junit.Test;


import problem57.Solution;
import problem57.TreeLinkNode;




public class Test57 {
	@Test
	public void test() {
		Solution solution = new Solution();
		TreeLinkNode t1 = new TreeLinkNode(1);
		TreeLinkNode t2 = new TreeLinkNode(2);
		TreeLinkNode t3 = new TreeLinkNode(3);
		TreeLinkNode t4 = new TreeLinkNode(4);
		TreeLinkNode t5 = new TreeLinkNode(5);
		TreeLinkNode t6 = new TreeLinkNode(6);
		t1.left = t2;
		t1.right = t3;
		t2.next = t1;
		t3.next = t1;
		t2.left = t4;
		t3.left = t5;
		t4.next = t2;
		t5.next = t3;
		t4.right = t6;
		t6.next = t4;
		System.out.println(solution.GetNext(t1).val);
		System.out.println(solution.GetNext(t2).val);
		System.out.println(solution.GetNext(t3));
		System.out.println(solution.GetNext(t4).val);
		System.out.println(solution.GetNext(t5).val);
		System.out.println(solution.GetNext(t6).val);
	}
	
	
	
}
