package problem01;


/**
 * @author Cliff_Ford
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {
	public boolean Find(int target,int [][] array) {
		int rows = array.length;	
		//排除{} 
		if(rows == 0) {
			return false;
		}
		int cols = array[0].length;
		//排除{{}} 的空数组情况
		if(cols == 0) {
			return false;
		}
		//目标值是最大值或者是最小值
		if(target == array[rows-1][cols-1] || target == array[0][0]) {
			return true;
		}
		//排除比最大值还大的目标值
		if(target > array[rows-1][cols-1]) {
			return false;
		}
		//排除比最小值还小的目标值
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
