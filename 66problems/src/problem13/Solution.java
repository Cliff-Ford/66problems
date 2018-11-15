package problem13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cliff_Ford
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ������ĺ�벿�֣�
 * ����֤������������ż����ż��֮������λ�ò��䡣
 */
public class Solution {
	public void reOrderArray(int [] array) {
        Queue<Integer> oddQueue = new LinkedList<>();
        Queue<Integer> evenQueue = new LinkedList<>();
        for(int i = 0; i < array.length; i++) {
        	if((array[i]&1) == 1) {
        		oddQueue.offer(array[i]);
        	}else {
        		evenQueue.offer(array[i]);
        	}
        }
        int i = 0;
        while(!oddQueue.isEmpty()) {
        	array[i++] = oddQueue.poll();
        }
        while(!evenQueue.isEmpty()) {
        	array[i++] = evenQueue.poll();
        }
    }
}