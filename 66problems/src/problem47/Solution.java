package problem47;


/**
 * @author Cliff_Ford
 * ��1+2+3+...+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ���
 * �������ж���䣨A?B:C����
 */
public class Solution {
	//Ϊ�����ǵķ���call
	public int Sum_Solution(int n) {
        int sum = n;
        //��n=1,��һ�εݹ�ʱn=0,&&��·������sum���仯���أ��ݹ鷵����ֵ
        boolean b = (n>0) && ( ( sum+=Sum_Solution(n-1) ) > 0 );
        //������Ϊ��ȥ�����棬û�������
        b = !b;
        return sum;
    }
}

 