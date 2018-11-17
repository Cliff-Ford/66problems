package problem25;


import java.util.HashMap;
import java.util.Map;


/**
 * @author Cliff_Ford
 * ����һ����������
 * ��ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩��
 * ���ؽ��Ϊ���ƺ��������head��
 * ��ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 */
public class Solution {
	
	private Map<RandomListNode, RandomListNode> tran = new HashMap<>();
	public RandomListNode Clone(RandomListNode pHead){
		RandomListNode pCloneHead = null;
		
		if(pHead == null) {
			return pCloneHead;
		}
		initTranMap(pHead);
		RandomListNode ph = pHead;
		while(ph!=null) {
			tran.get(ph).next = tran.get(ph.next);
			tran.get(ph).random = tran.get(ph.random);
			ph = ph.next;
		}
		
		return tran.get(pHead);
    }
	public void initTranMap(RandomListNode head) {
		RandomListNode h = head;
		while(h!=null) {
			RandomListNode t = new RandomListNode(h.label);
			tran.put(h,t);
			h = h.next;
		}
	}
	//���ж�����ô����
	//��ʯ��
	//https://www.nowcoder.com/profile/963880/codeBookDetail?submissionId=1512226
	public RandomListNode CloneII(RandomListNode pHead){
        if(pHead==null)
            return null;
        RandomListNode pCur = pHead;
        //����next ��ԭ����A->B->C ���A->A'->B->B'->C->C'
        while(pCur!=null){
            RandomListNode node = new RandomListNode(pCur.label);
            node.next = pCur.next;
            pCur.next = node;
            pCur = node.next;
        }
        pCur = pHead;
        //����random pCur��ԭ������Ľ�� pCur.next�Ǹ���pCur�Ľ��
        while(pCur!=null){
            if(pCur.random!=null)
                pCur.next.random = pCur.random.next;
            pCur = pCur.next.next;
        }
        RandomListNode head = pHead.next;
        RandomListNode cur = head;
        pCur = pHead;
        //�������
        while(pCur!=null){
            pCur.next = pCur.next.next;
            if(cur.next!=null)
                cur.next = cur.next.next;
            cur = cur.next;
            pCur = pCur.next;
        }
        return head;       
    }
}