package problem16;


/**
 * @author Cliff_Ford
 * ������������������������������������ϳɺ��������
 * ��Ȼ������Ҫ�ϳɺ���������㵥����������
 */
public class Solution {
	public ListNode Merge(ListNode list1,ListNode list2) {
		if(list1 == null) {
			return list2;
		}
		if(list2 == null) {
			return list1;
		}
		ListNode h = new ListNode(1);
		ListNode c = h;
        ListNode p = list1;
        ListNode q = list2;
        while(p != null && q != null) {
        	
        	if(p.val < q.val) {
        		
        		c.next = p;
        		p = p.next;
        	}else{
        		c.next = q;
        		q = q.next;
        	}
        	c = c.next;
        }
        if(q == null) {
        	c.next = p;
        }
        if(p == null) {
        	c.next = q;
        }
        return h.next;
    }
	//�ݹ�ⷨ
	/*public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null){
            return list2;
        }else if(list2==null){
            return list1;
        }
        ListNode pMergeHead = null;
        if(list1.val<list2.val){
            pMergeHead = list1;
            pMergeHead.next = Merge(list1.next,list2);
        }else{
            pMergeHead = list2;
            pMergeHead.next = Merge(list1,list2.next);
        }
        return pMergeHead;
    }*/
}