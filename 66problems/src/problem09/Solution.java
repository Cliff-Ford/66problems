package problem09;


/**
 * @author Cliff_Ford
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n����
 * �����������һ��n����̨���ܹ��ж�����������
 */
public class Solution {
	public int JumpFloorII(int target) {
		if(target <= 0) {
			return 0;
		}
		if(target == 1) {
			return 1;
		}
		if(target == 2) {
			return 2;
		}
		//һ��������һ�����
		int result = 1;
		int i = 1;
		//������һ����������
		while(i<=target) {
			result = result + JumpFloorII(target-i);
			i++;
		}
		return result;
    }
}	