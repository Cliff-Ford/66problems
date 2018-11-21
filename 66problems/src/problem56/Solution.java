package problem56;



/**
 * @author Cliff_Ford
 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬
 * �ظ��Ľ�㲻��������������ͷָ�롣 
 * ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 */
public class Solution {
	public ListNode deleteDuplication(ListNode pHead){
		if(pHead==null) {
			return null;
		}
		
		ListNode pCur = pHead;
		ListNode pNext = pHead.next;
		//ֻ��һ����
		if(pNext==null) {
			return pCur;
		}
		//���������ڵ�
		if(pCur.val!=pNext.val) {
			//����  1 2 2    ��  1 2 3 �����
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
		//pCur.val==pNext.val ������Ĵ���
		//1 1 1         1 1 2
		while(pNext.next!=null && pNext.next.val==pNext.val) {
			pNext = pNext.next;
		}
		return deleteDuplication(pNext.next);
		
		
		
    }

}

 