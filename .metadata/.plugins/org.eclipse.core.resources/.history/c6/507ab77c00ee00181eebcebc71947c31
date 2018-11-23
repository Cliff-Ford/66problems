package problem64;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * @author Cliff_Ford
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *  {[2,3,4],2,6,2,5,1}， 
 *  {2,[3,4,2],6,2,5,1}， 
 *  {2,3,[4,2,6],2,5,1}， 
 *  {2,3,4,[2,6,2],5,1}，
 *  {2,3,4,2,[6,2,5],1}， 
 *  {2,3,4,2,6,[2,5,1]}。
 */
public class Solution {
	public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> result = new ArrayList<>();
        if(num==null || num.length==0 || size<=0 || num.length<size) {
        	return result;
        }
        
        LinkedList<Integer> ul = new LinkedList<>();
        LinkedList<Integer> ol = new LinkedList<>();
        for(int i = 0; i < size; i++) {
        	ul.add(num[i]);
        	
        	olInsert(ol, num[i]);
        	
        }
        result.add(ol.getLast());
        for(int i = size; i < num.length; i++) {
        	int e = ul.removeFirst();
        	ul.addLast(num[i]);
        	ol.remove(ol.indexOf(e));
        	olInsert(ol, num[i]);
        	result.add(ol.getLast());
        }
        return result;
    }
	
	public void olInsert(LinkedList<Integer> ol,int num) {
		int addIndex = 0;
    	if(ol.size()==0 || num<=ol.getFirst()) {
    		ol.addFirst(num);
    		
    	}else if(num>=ol.getLast()) {
    		ol.addLast(num);
    	}else {
    		while(num>ol.get(addIndex)) {
    			addIndex++;
    		}        		
    		ol.add(addIndex, num);
    		
    	}
	}

    
}

 