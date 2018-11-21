package problem56;



/**
 * @author Cliff_Ford
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution {
	public ListNode deleteDuplication(ListNode pHead){
		if(pHead==null) {
			return null;
		}
		
		ListNode pCur = pHead;
		ListNode pNext = pHead.next;
		//只有一个点
		if(pNext==null) {
			return pCur;
		}
		//至少两个节点
		if(pCur.val!=pNext.val) {
			//区分  1 2 2    和  1 2 3 的情况
			if(pNext.next!=null && pNext.next.val!=pNext.val) {
				ListNode endPart = deleteDuplication(pNext.next);
				pNext.next = endPart;
				return pCur;
			}else if(pNext.next!=null && pNext.next.val==pNext.val) {
				while(pNext.next!=null && pNext.next.val==pNext.val) {
					pNext = pNext.next;
				}
				ListNode endPart = deleteDuplication(pNext.next);
				pCur.next = endPart;
				
			}
			return pCur;
		}
		//pCur.val==pNext.val 的情况的处理
		//1 1 1         1 1 2
		while(pNext.next!=null && pNext.next.val==pNext.val) {
			pNext = pNext.next;
		}
		return deleteDuplication(pNext.next);
		
		
		
    }

}

 