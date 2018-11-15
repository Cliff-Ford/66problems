package problem06;


/**
 * @author Cliff_Ford
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���Ǽ�����������һ����ת�������ת�������СԪ�ء� 
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� 
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 */
public class Solution {
	public int minNumberInRotateArray(int [] array) {
	    if(array.length == 0 || array == null) {
	    	return 0;
	    }
	    if(array.length == 1) {
	    	return array[0];
	    }
	    
	    int min = array[0];
	    int i = 1;
	    int len = array.length;
	    for(;i<len;i++) {
	    	if(min > array[i]) {
	    		return array[i];
	    	}
	    }
	    return min;	    
    }
}	