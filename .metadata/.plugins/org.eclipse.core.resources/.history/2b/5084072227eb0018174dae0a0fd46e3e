package problem35;




/**
 * @author Cliff_Ford
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，
 * 则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 
 * 题目保证输入的数组中没有的相同的数字

	数据范围：

	对于%50的数据,size<=10^4

	对于%75的数据,size<=10^5

	对于%100的数据,size<=2*10^5
 */
public class Solution {
	
	public int InversePairs(int [] array) {
        return myInversePairs(array, 0, array.length-1) % 1000000007;
    }
	//end是array的最后一个下标
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

