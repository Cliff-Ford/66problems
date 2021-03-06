package problem65;

import java.util.ArrayList;

/**
 * @author Cliff_Ford
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。 
 * 例如 a b c e 
 * 	  s f c s 
 * 	  a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，
 * 但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
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
		//将一维的matrix转为二维的matixII
		oneToTwo(matrix, rows, cols, matrixII);
		//找出所有可能的起点
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
	//一维数组转二维数组
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

 