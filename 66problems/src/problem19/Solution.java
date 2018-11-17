package problem19;

import java.util.ArrayList;

/**
 * @author Cliff_Ford
 * ����һ�����󣬰��մ���������˳ʱ���˳�����δ�ӡ��ÿһ�����֣�
 * ���磬�����������4 X 4���� 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
 * �����δ�ӡ������1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Solution {
	//�����е��ѣ��ο��˼��ݴ���
	public ArrayList<Integer> printMatrix(int [][] matrix) {
	       int rows = matrix.length;
	       if(rows == 0) {
	    	   return null;
	       }
	       int cols = matrix[0].length;
	       if(cols == 0) {
	    	   return null;
	       }
	       //ľͰ���ۼ���Ȧ��
	       int circles = ((rows<cols?rows:cols)-1)/2+1;
	       
	       ArrayList<Integer> r = new ArrayList<>();
	       for(int i = 0; i < circles; i++) {
	    	   //��������
	    	   for(int j = i; j < cols - i; j++) {
	    		   r.add(matrix[i][j]);
	    	   }
	    	   //��������
	    	   for(int j = i + 1; j < rows - i; j++) {
	    		   r.add(matrix[j][cols-i-1]);
	    	   }
	    	   //��������
	    	   for(int j = cols - i - 2; j >= i && (rows-i-1 != i); j--) {
	    		   r.add(matrix[rows-i-1][j]);
	    	   }
	    	   //��������
	    	   for(int j = rows - i - 2; j > i && (cols-i-1 != i);j--) {
	    		   r.add(matrix[j][i]);
	    	   }
	       } 
	       return r;
    }
}