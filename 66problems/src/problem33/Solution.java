package problem33;


/**
 * @author Cliff_Ford
 * ��ֻ����������2��3��5��������������Ugly Number����
 * ����6��8���ǳ�������14���ǣ���Ϊ������������7��
 *  ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 *  
 *  
 *  ע��������  �����Ǹ���
 */
public class Solution {
	
	//����  ��ʱ
	public int GetUglyNumber_Solution(int index) {
        if(index <= 1) {
        	return index;
        }
        //index >= 2
        int uglyNum[] = new int[index+1];
        uglyNum[0] = 0;
        uglyNum[1] = 1;
        
        return 0;
    }
	
	
}

