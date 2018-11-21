package problem63;


import java.util.LinkedList;

/**
 * @author Cliff_Ford
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class Solution {
	private LinkedList<Integer> list = new LinkedList<>();
	
	public void Insert(Integer num) {
	    if(list.size()==0 || num<list.getFirst()) {
	    	list.addFirst(num);
	    }else {
	    	boolean isInsert = false;
	    	for(Integer ele : list) {
	    		if(num<ele) {
	    			int index = list.indexOf(ele);
	    			list.add(index, num);
	    			isInsert = true;
	    			break;
	    		}
	    	}
	    	if(isInsert==false) {
	    		list.addLast(num);
	    	}
	    }
	    
    }

    public Double GetMedian() {
    	if(list.size()==0) {
    		return null;
    	}
		//奇数
		if(list.size()%2==1) {
			return Double.valueOf(list.get(list.size()/2));
		}
        //偶数
		return Double.valueOf(list.get(list.size()/2-1) + list.get(list.size()/2))/2;
    }
}

 