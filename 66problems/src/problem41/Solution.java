package problem41;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



/**
 * @author Cliff_Ford
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
 * û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22��
 * ���ڰ����⽻����,���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
 * 
 * ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
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
	       //�����������������еĸ���
	       int n = (int) Math.sqrt(2 * sum);
	       while(n>=2) {
	    	   //�����������µĵ�һ����x��ͨ�ʽ x = (sum + n(n-1)/2)/n
		       int x = (sum - n*(n-1)/2) / n;
		       
		       //У��  �����Ҳ��� ����100�Ҳ�������������������Ϊ100
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
	
	//������Ǽ�����Ľⷨ
	/*/�����˼·��˫ָ������
	//���ܺ�С��sum����ָ�����+
	//����Сָ��+
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
