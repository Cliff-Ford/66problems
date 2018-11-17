package problem29;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @author Cliff_Ford
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Solution {
	
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if(input.length == 0 || k == 0) {
        	return result;
        }
        if(k > input.length) {
        	return result;
        }
        quick_sort(input, 0, input.length-1);
        for(int i = 0; i < k; i++) {
        	result.add(input[i]);
        }
        return result;
    }
	public void quick_sort(int [] array,int start,int end) {
		int low = start;
		int high = end;
		int key = array[low];
		while(low<high) {
			while(low<high && array[high]>=key) {
				high--;
			}
			if(low<high) {
				int t = array[high];
				array[high] = array[low];
				array[low] = t;
				low++;
			}
			while(low<high && array[low]<=key) {
				low++;
			}
			if(low<high) {
				int t = array[high];
				array[high] = array[low];
				array[low] = t;
				high--;
			}
		}
		if(low>start) {
			quick_sort(array, 0, low-1);
		}
		if(high<end) {
			quick_sort(array, high+1, end);
		}
	}
	
	//堆排序写法
	public ArrayList<Integer> GetLeastNumbers_SolutionII(int[] input, int k) {
       ArrayList<Integer> result = new ArrayList<Integer>();
       int length = input.length;
       if(k > length || k == 0){
           return result;
       }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }
	
	public void HeapSort(int [] arr) {
		int n = arr.length-1;
		for(int i=(n-1)/2; i>=0; i--) {
			//构造大根堆，从下往上构造
			//i为最后一个根节点，n为数组最后一个元素的下标
			HeapAdjust(arr,i,n);
		}
	}
	public void HeapAdjust(int[] arr,int parent,int length) {
		int temp = arr[parent];
		for(int i=parent*2+1; i<=length; i=i*2+1) {
			//指向大的孩子
			//i==length 代表只有左孩子 防止arr[i+1]越界
			if(i<length && arr[i]<arr[i+1]) {
				i++;
			}
			//如果父节点 >= 大孩子，不用调整
			if(temp>=arr[i]) {
				break;
			}
			//调整父子关系
			arr[parent] = arr[i];
			//把孩子节点的下标赋值给parent
            //让其继续循环以保证大根堆构造正确
            parent = i;
		}
		//将刚刚的父节点中的数据赋值给新位置
        arr[parent] = temp;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

