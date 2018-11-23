package problem66;



/**
 * @author Cliff_Ford
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 */
public class Solution {
	
	public int movingCount(int threshold, int rows, int cols){
        boolean table[][] = new boolean[rows][cols];
        //找出所有可以走的格子
        findAllCanBeMovedGrids(table,threshold,rows,cols);
        return movingCount(table, rows, cols, 0, 0);
        
    }

	private int movingCount(boolean[][] table, int rows, int cols, int i, int j) {
		if(i<0 || j<0 || i>=rows || j>=cols || table[i][j]==false) {
			return 0;
		}
		table[i][j] = false;
		return 1 + movingCount(table, rows, cols, i, j+1)
				 + movingCount(table, rows, cols, i-1, j)
				 + movingCount(table, rows, cols, i, j-1)
				 + movingCount(table, rows, cols, i+1, j);
	}

	private void findAllCanBeMovedGrids(boolean[][] table, int threshold, int rows, int cols) {
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				table[i][j] = addOneByOne(i, j, threshold);
			}
		}		
	}
    private boolean addOneByOne(int i,int j,int threshold) {
    	int r = 0;
		while(i!=0) {
			int t = i % 10;
			r = r + t;
			i = i / 10;
		}
		while(j!=0) {
			int t = j % 10;
			r = r + t;
			j = j / 10;
		}
		if(r>threshold) {
			return false;
		}
    	return true;
	}
}

 