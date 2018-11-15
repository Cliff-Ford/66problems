package problem13;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Cliff_Ford
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
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