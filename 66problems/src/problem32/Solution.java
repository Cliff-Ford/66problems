package problem32;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Cliff_Ford
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution {
	public String PrintMinNumber(int [] numbers) {
		//思路一：全排序，快速排序		
		//思路二：快速排序，从0下标开始往后累加，每次都选当前下一步最小的
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

