package problem01;


/**
 * @author Cliff_Ford
 * ��һ����ά�����У�ÿ��һά����ĳ�����ͬ����ÿһ�ж����մ����ҵ�����˳������
 * ÿһ�ж����մ��ϵ��µ�����˳������
 * �����һ������������������һ����ά�����һ���������ж��������Ƿ��и�������
 */
public class Solution {
	public boolean Find(int target,int [][] array) {
		int rows = array.length;	
		//�ų�{} 
		if(rows == 0) {
			return false;
		}
		int cols = array[0].length;
		//�ų�{{}} �Ŀ��������
		if(cols == 0) {
			return false;
		}
		//Ŀ��ֵ�����ֵ��������Сֵ
		if(target == array[rows-1][cols-1] || target == array[0][0]) {
			return true;
		}
		//�ų������ֵ�����Ŀ��ֵ
		if(target > array[rows-1][cols-1]) {
			return false;
		}
		//�ų�����Сֵ��С��Ŀ��ֵ
		if(target < array[0][0]) {
			return false;
		}
		for(int i = 0,j = cols - 1; i < rows && j >= 0;) {
			if(target == array[i][j]) {
				return true;
			}
			if(target > array[i][j]) {
				i++;
			}
			if(target < array[i][j]) {
				j--;
			}
		}
		return false;
	}
}
