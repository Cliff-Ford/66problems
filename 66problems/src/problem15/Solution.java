package problem15;


/**
 * @author Cliff_Ford
 * ����һ��������ת��������������ı�ͷ��
 */
public class Solution {
	//�ݹ�ⷨ
	public ListNode ReverseList(ListNode head) {
		//������
		if(head == null) {
			return null;
		}
		//�����ڵ�����
		if(head.next == null) {
			return head;
		}
		//��������
		ListNode p = head;
		ListNode pL = p;
		ListNode q = p.next;
		while(q.next != null) {
			pL = q;
			q = q.next;
		}
		pL.next = null;
		ListNode t = ReverseList(p);
		q.next = t;
		return q;
    }
	public void Reverse(ListNode head) {
		if(head.next != null) {
			Reverse(head.next);
		}
		System.out.println(head.val);
	}
	//ѭ���ⷨ
	public ListNode ReverseListII(ListNode head) {
	       
        if(head==null)
            return null;
        //headΪ��ǰ�ڵ㣬�����ǰ�ڵ�Ϊ�յĻ����Ǿ�ʲôҲ������ֱ�ӷ���null��
        ListNode pre = null;
        ListNode next = null;
        //��ǰ�ڵ���head��preΪ��ǰ�ڵ��ǰһ�ڵ㣬nextΪ��ǰ�ڵ����һ�ڵ�
        //��Ҫpre��next��Ŀ�����õ�ǰ�ڵ��pre->head->next1->next2���pre<-head next1->next2
        //��pre�ýڵ���Է�ת��ָ���򣬵���ת֮���������next�ڵ㱣��next1�ڵ�Ļ����˵�����ʹ˶Ͽ���
        //������Ҫ�õ�pre��next�����ڵ�
        //1->2->3->4->5
        //1<-2<-3 4->5
        while(head!=null){
            //��ѭ���������ǰ�ڵ㲻Ϊ�յĻ���ʼ��ִ�д�ѭ������ѭ����Ŀ�ľ����õ�ǰ�ڵ��ָ��next��ָ��pre
            //��˾Ϳ���������ת�����Ч��
            //����next����head����һ���ڵ����Ϣ����֤����������Ϊʧȥhead�ڵ��ԭnext�ڵ���ʹ˶���
            next = head.next;
            //������next���Ϳ�����head��ָ��next���ָ��pre�ˣ���������
            head.next = pre;
            //headָ��pre�󣬾ͼ������η�ת��һ���ڵ�
            //��pre��head��next��������ƶ�һ���ڵ㣬������һ�ε�ָ�뷴ת
            pre = head;
            head = next;
        }
        //���headΪnull��ʱ��pre��Ϊ���һ���ڵ��ˣ����������Ѿ���ת��ϣ�pre���Ƿ�ת������ĵ�һ���ڵ�
        //ֱ�����pre����������Ҫ�õ��ķ�ת�������
        return pre;
    }
	//Ҳ������ջ��˳������ڵ���ջ��Ȼ�����γ�ջ��������
}