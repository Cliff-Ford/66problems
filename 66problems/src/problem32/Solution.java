package problem32;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Cliff_Ford
 * ����һ�����������飬����������������ƴ�������ų�һ������
 * ��ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323��
 */
public class Solution {
	public String PrintMinNumber(int [] numbers) {
		//˼·һ��ȫ���򣬿�������		
		//˼·�����������򣬴�0�±꿪ʼ�����ۼӣ�ÿ�ζ�ѡ��ǰ��һ����С��
		if(numbers.length == 0) {
			return "";
		}
		if(numbers.length == 1) {
			return "" + numbers[0];
		}
		quick_sort(numbers, 0, numbers.length-1);
		StringBuffer result = new StringBuffer();
		int len = numbers.length;
		
		for(int i = 0; i < len; i++) {
			String a = result.toString() + numbers[i];
			String b = numbers[i] + result.toString();
			if(a.compareTo(b)<0) {
				result.append(numbers[i]);
			}else {
				result.insert(0, numbers[i]);
			}
		}
		return result.toString();
    }
	public void quick_sort(int [] numbers,int start,int end) {
		int low = start;
		int high = end;
		int key = numbers[start];
		while(low<high) {
			while(low<high && numbers[high]>=key) {
				high--;
			}
			if(low<high) {
				int t = numbers[high];
				numbers[high] = numbers[low];
				numbers[low] = t;
				low++;
			}
			while(low<high && numbers[low]<=key) {
				low++;
			}
			if(low<high) {
				int t = numbers[low];
				numbers[low] = numbers[high];
				numbers[high] = t;
				high--;
			}
		}
		if(low>start) {
			quick_sort(numbers, 0, low-1);
		}
		if(high<end) {
			quick_sort(numbers, high+1, end);
		}
	}
	public String PrintMinNumberII(int [] numbers) {
        if(numbers == null || numbers.length == 0) return "";
        int len = numbers.length;
        String[] str = new String[len];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i++){
            str[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(str,new Comparator<String>(){
            @Override
            public int compare(String s1, String s2) {
                String c1 = s1 + s2;
                String c2 = s2 + s1;
                return c1.compareTo(c2);
            }
        });
        for(int i = 0; i < len; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }
}

