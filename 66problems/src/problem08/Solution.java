package problem08;


/**
 * @author Cliff_Ford
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2����
 * �����������һ��n����̨���ܹ��ж������������Ⱥ����ͬ�㲻ͬ�Ľ������
 */
public class Solution {
	public int JumpFloor(int target) {
		if(target == 0) {
			return 0;
		}
		if(target == 1) {
			return 1;
		}
		if(target == 2) {
			return 2;
		}
		return JumpFloor(target-1) + JumpFloor(target-2);
    }
}	