package problem41;

import java.util.ArrayList;




/**
 * @author Cliff_Ford
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Solution {
	
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<Integer> seque = new ArrayList<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
	       if(sum<=2) {
	    	   return result;
	       }
	       if(sum==3) {
	    	   seque.add(1);
	    	   seque.add(2);
	    	   result.add(seque);
	    	   return result;
	       }
	       //期望的连续整数序列的个数
	       int n = (int) Math.sqrt(2 * sum);
	       while(n>=2) {
	    	   //该期望个数下的第一个数x的通项公式 x = (sum + n(n-1)/2)/n
		       int x = (sum - n*(n-1)/2) / n;
		       
		       //校验  可能找不到 比如100找不到两个连续的正数和为100
		       if(x>0) {
		    	   if((x*n+n*(n-1)/2)==sum) {
			    	   for(int i = 0; i < n; i++) {
			    		   seque.add(x+i);
			    	   }
			    	   result.add(new ArrayList<>(seque));
			       }
			       seque.removeAll(seque);
		       }
		       
		       n--;
	       }
	       
	       /*Collections.sort(result, new Comparator<ArrayList<Integer>>() {
	    	   
	            @Override
	            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
	                    return o1.get(0).compareTo(o2.get(0));
	                 
	            }
	        });*/
	       
	       return result;
    }
	
	//这个才是计算机的解法
	/*/左神的思路，双指针问题
	//当总和小于sum，大指针继续+
	//否则小指针+
	class Solution {
	public:
	    vector<vector<int> > FindContinuousSequence(int sum) {
	        vector<vector<int> > allRes;
	        int phigh = 2,plow = 1;
	         
	        while(phigh > plow){
	            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
	            if( cur < sum)
	                phigh++;
	             
	            if( cur == sum){
	                vector<int> res;
	                for(int i = plow; i<=phigh; i++)
	                    res.push_back(i);
	                allRes.push_back(res);
	                plow++;
	            }
	             
	            if(cur > sum)
	                plow++;
	        }
	         
	        return allRes;
	    }
	};*/
	
}

