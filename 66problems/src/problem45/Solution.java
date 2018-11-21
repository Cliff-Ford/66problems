package problem45;


import java.util.Arrays;

/**
 * @author Cliff_Ford
 * LL���������ر��,��Ϊ��ȥ����һ���˿���,���������Ȼ��2������,2��С��(һ����ԭ����54��^_^)...
 * ��������г����5����,�����Լ�������,�����ܲ��ܳ鵽˳��,
 * ����鵽�Ļ�,������ȥ��������Ʊ,�ٺ٣���
 * ������A,����3,С��,����,��Ƭ5��,��Oh My God!������˳��.....LL��������,��������,
 * ������\С �����Կ����κ�����,����A����1,JΪ11,QΪ12,KΪ13��
 * �����5���ƾͿ��Ա�ɡ�1,2,3,4,5��(��С���ֱ���2��4),��So Lucky!����
 * LL����ȥ��������Ʊ���� ����,Ҫ����ʹ�������ģ������Ĺ���,Ȼ���������LL��������Σ�
 *  ����������˳�Ӿ����true����������false��Ϊ�˷������,�������Ϊ��С����0��
 */
public class Solution {
	//�Լ��븴���ˣ�������Ŀû�����˳�Ӹ������壬���� 13 1 2 3 4 ����˳�ӣ���ȴ����������˳��
	public boolean isContinuous(int [] numbers) {
		if(numbers == null || numbers.length != 5) {
			return false;
		}
		Arrays.sort(numbers);
		int ghostNum = 0;
		for(int i = 0; i < 5; i++) {
			if(numbers[i]==0) {
				ghostNum++;
			}
		}
		//��һ�ŷǹ����Ƶ�����
		int j = ghostNum;
		//�ų�����
		for(int i = j; i < 5; i++) {
			for(int k = i + 1; k < 5; k++) {
				if(numbers[i]==numbers[k]) {
					return false;
				}
			}
		}
		//û�г鵽��
		if(ghostNum==0) {			
			if(numbers[4]-numbers[0]==4) {
				return true;
			}
			return false;
		}
		//�鵽��
		if(numbers[4]-numbers[j]<5) {
			return true;
		}
		return false;
    }
	
}
