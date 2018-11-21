package problem55;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Cliff_Ford
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class Solution {
	//更好的做法是快慢指针找到相遇点，此时慢指针刚好走了一个环的步数，让快指针重置，快慢指针
	//此时同时每次走一步，相遇点就是入口点
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

 