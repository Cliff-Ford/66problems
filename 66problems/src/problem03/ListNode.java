package problem03;

public class ListNode {
	private int val;
    ListNode next = null;
    public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
	public ListNode(int val) {
        this.val = val;
    }
}
