package problem66;



/**
 * @author Cliff_Ford
 * ������һ��m�к�n�еķ���
 * һ�������˴�����0,0�ĸ��ӿ�ʼ�ƶ���ÿһ��ֻ�������ң��ϣ����ĸ������ƶ�һ��
 * ���ǲ��ܽ�������������������λ֮�ʹ���k�ĸ��ӡ� 
 * ���磬��kΪ18ʱ���������ܹ����뷽��35,37������Ϊ3+5+3+7 = 18��
 * ���ǣ������ܽ��뷽��35,38������Ϊ3+5+3+8 = 19��
 * ���ʸû������ܹ��ﵽ���ٸ����ӣ�
 */
public class Solution {
	
	public int movingCount(int threshold, int rows, int cols){
        boolean table[][] = new boolean[rows][cols];
        //�ҳ����п����ߵĸ���
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

 