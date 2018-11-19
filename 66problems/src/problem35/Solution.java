package problem35;




/**
 * @author Cliff_Ford
 * �������е��������֣����ǰ��һ�����ִ��ں�������֣�
 * ���������������һ������ԡ�
 * ����һ������,�����������е�����Ե�����P��
 * ����P��1000000007ȡģ�Ľ������� �����P%1000000007
 * 
 * ��Ŀ��֤�����������û�е���ͬ������

	���ݷ�Χ��

	����%50������,size<=10^4

	����%75������,size<=10^5

	����%100������,size<=2*10^5
 */
public class Solution {
	
	public int InversePairs(int [] array) {
        return myInversePairs(array, 0, array.length-1) % 1000000007;
    }
	//end��array�����һ���±�
	public int myInversePairs(int [] array,int start,int end) {
		if(start == end) {
			return 0;
		}
		int l = myInversePairs(array, start, end-1);
		int c = 0;
		for(int i = start; i < end; i++) {
			if(array[i]>array[end]) {
				c++;
			}
		}
		return (l + c) % 1000000007;
	}
}

