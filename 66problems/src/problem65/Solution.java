package problem65;

import java.util.ArrayList;

/**
 * @author Cliff_Ford
 * �����һ�������������ж���һ���������Ƿ����һ������ĳ�ַ��������ַ���·����
 * ·�����ԴӾ����е�����һ�����ӿ�ʼ��ÿһ�������ھ������������ң����ϣ������ƶ�һ�����ӡ�
 * ���һ��·�������˾����е�ĳһ�����ӣ���֮�����ٴν���������ӡ� 
 * ���� a b c e 
 * 	  s f c s 
 * 	  a d e e ������3 X 4 �����а���һ���ַ���"bcced"��·����
 * ���Ǿ����в�����"abcb"·����
 * ��Ϊ�ַ����ĵ�һ���ַ�bռ���˾����еĵ�һ�еڶ�������֮��·�������ٴν���ø��ӡ�
 */
public class Solution {
	
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
		
		if(matrix==null || matrix.length==0 || str==null || str.length==0) {
			return false;
		}
		boolean isSelected[][] = new boolean[rows][cols];
		char matrixII[][] = new char[rows][cols];
		int startRow;
		int startCol;
		
		ArrayList<ArrayList<Integer>> startPosition = new ArrayList<>();
		//��һά��matrixתΪ��ά��matixII
		oneToTwo(matrix, rows, cols, matrixII);
		//�ҳ����п��ܵ����
		findAllStartPosition(startPosition,matrixII,str[0]);
		for(ArrayList<Integer> start : startPosition) {
			startRow = start.get(0);
			startCol = start.get(1);
			boolean result = findPathFromThisPosition(matrixII,isSelected,startRow,startCol,str,0);
			if(result==true) {
				return true;
			}else {
				initIsSelected(isSelected);
			}
		}
		return false;
    }
	
	public boolean findPathFromThisPosition(char[][] matrixII, boolean[][] isSelected, int startRow, int startCol,
			char[] str, int strIndex) {
		int rows = matrixII.length;
		int cols = matrixII[0].length;
		int strLen = str.length;
		if(startRow<rows && startCol<cols && startRow>=0 && startCol>=0 && strIndex<strLen) {
			if(matrixII[startRow][startCol]==str[strIndex] && isSelected[startRow][startCol]==false) {
				isSelected[startRow][startCol] = true;
				if(strIndex+1<strLen) {
					return findPathFromThisPosition(matrixII, isSelected, startRow, startCol+1, str, strIndex+1) ||
						   findPathFromThisPosition(matrixII, isSelected, startRow+1, startCol, str, strIndex+1) ||
						   findPathFromThisPosition(matrixII, isSelected, startRow, startCol-1, str, strIndex+1) ||
						   findPathFromThisPosition(matrixII, isSelected, startRow-1, startCol, str, strIndex+1);
				}else if(strIndex+1==strLen) {
					//matrixII [[a]]  str [a]
					return true;
				}
				
			}
		}else if(startRow<rows && startCol<cols && startRow>=0 && startCol>=0 && strIndex==strLen) {
			return true;
		}
		
		return false;
	}

	public void findAllStartPosition(ArrayList<ArrayList<Integer>> startPosition, char[][] matrixII, char c) {
		ArrayList<Integer> start = new ArrayList<>();
		for(int i = 0; i < matrixII.length; i++) {
			for(int j = 0; j < matrixII[0].length; j++) {
				if(matrixII[i][j]==c) {
					start.add(i);
					start.add(j);
					startPosition.add(new ArrayList<>(start));
					start.removeAll(start);
				}
			}
		}
		
	}
	//һά����ת��ά����
	public void oneToTwo(char[] matrix,int rows,int cols,char [][] matrixII) {
		int index = 0;
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				matrixII[i][j] = matrix[index++];
			}
		}
	}
	
	public void initIsSelected(boolean[][] isSelected) {
		for(int i = 0; i < isSelected.length; i++) {
			for(int j = 0; j < isSelected[0].length; j++) {
				isSelected[i][j] = false;
			}
		}
	}
    
}

 