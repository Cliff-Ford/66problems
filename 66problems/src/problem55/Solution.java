package problem55;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Cliff_Ford
 * ��һ�����������а����������ҳ�������Ļ�����ڽ�㣬�������null��
 */
public class Solution {
	//���õ������ǿ���ָ���ҵ������㣬��ʱ��ָ��պ�����һ�����Ĳ������ÿ�ָ�����ã�����ָ��
	//��ʱͬʱÿ����һ���������������ڵ�
	public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null) {
        	return null;
        }
        ListNode p = pHead;
        Map<ListNode, Integer> node_num = new LinkedHashMap<>();
        while(p!=null) {
        	if(node_num.containsKey(p)) {
        		return p;
        	}else {
        		node_num.put(p, 1);
        	}
        	p = p.next;
        }
        return null;
    }

}

 