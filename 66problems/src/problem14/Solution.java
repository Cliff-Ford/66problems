package problem14;


/**
 * @author Cliff_Ford
 * ����һ������������������е�����k����㡣
 */
public class Solution {
	public ListNode FindKthToTail(ListNode head,int k) {
		if(head == null) {
			return null;
		}
		int len = 1;
		ListNode result = head;
		while(result.next != null) {
			len++;
			result = result.next;
		}
		if(k > len) {
			return null;
		}
		//˳����target�����ǵ����ĵ�k��
		int target = len - k + 1;
		result = head;
		while(target > 1) {
			result = result.next;
			target--;
		}
		return result;
    }
	public ListNode FindKthToTailII(ListNode head,int k) {
        ListNode pre=null,p=null;
        //����ָ�붼ָ��ͷ���
        p=head;
        pre=head;
        //��¼kֵ
        int a=k;
        //��¼�ڵ�ĸ���
        int count=0;
        //pָ�����ܣ����Ҽ�¼�ڵ�������pָ������k-1���ڵ��preָ�뿪ʼ�ܣ�
        //��pָ���ܵ����ʱ��pre��ָָ����ǵ�����k���ڵ�
        while(p!=null){
            p=p.next;
            count++;
            if(k<1){
                pre=pre.next;
            }
            k--;
        }
        //����ڵ����С������ĵ�����k���ڵ㣬�򷵻ؿ�
        if(count<a) return null;
        return pre;
            
    }
}