package problem19;

import java.util.ArrayList;

/**
 * @author Cliff_Ford
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution {
	//规律有点难，参考了几份代码
	public ArrayList<Integer> printMatrix(int [][] matrix) {
	       int rows = matrix.length;
	       if(rows == 0) {
	    	   return null;
	       }
	       int cols = matrix[0].length;
	       if(cols == 0) {
	    	   return null;
	       }
	       //木桶理论计算圈数
	       int circles = ((rows<cols?rows:cols)-1)/2+1;
	       
	       ArrayList<Integer> r = new ArrayList<>();
	       for(int i = 0; i < circles; i++) {
	    	   //从左向右
	    	   for(int j = i; j < cols - i; j++) {
	    		   r.add(matrix[i][j]);
	    	   }
	    	   //从上向下
	    	   for(int j = i + 1; j < rows - i; j++) {
	    		   r.add(matrix[j][cols-i-1]);
	    	   }
	    	   //从右向左
	    	   for(int j = cols - i - 2; j >= i && (rows-i-1 != i); j--) {
	    		   r.add(matrix[rows-i-1][j]);
	    	   }
	    	   //从下向上
	    	   for(int j = rows - i - 2; j > i && (cols-i-1 != i);j--) {
	    		   r.add(matrix[j][i]);
	    	   }
	       } 
	       return r;
    }
}