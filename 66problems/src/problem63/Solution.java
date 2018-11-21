package problem63;


import java.util.LinkedList;

/**
 * @author Cliff_Ford
 * ��εõ�һ���������е���λ����
 * ������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��
 * ������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 * ����ʹ��Insert()������ȡ��������ʹ��GetMedian()������ȡ��ǰ��ȡ���ݵ���λ����
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
		//����
		if(list.size()%2==1) {
			return Double.valueOf(list.get(list.size()/2));
		}
        //ż��
		return Double.valueOf(list.get(list.size()/2-1) + list.get(list.size()/2))/2;
    }
}

 