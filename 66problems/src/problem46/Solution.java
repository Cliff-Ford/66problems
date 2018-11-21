package problem46;


/**
 * @author Cliff_Ford
 * ÿ����һ��ͯ��,ţ�Ͷ���׼��һЩС����ȥ�����¶�Ժ��С����,����������ˡ�
 * HF��Ϊţ�͵�����Ԫ��,��ȻҲ׼����һЩС��Ϸ��
 * ����,�и���Ϸ��������:����,��С������Χ��һ����Ȧ��
 * Ȼ��,�����ָ��һ����m,�ñ��Ϊ0��С���ѿ�ʼ������
 * ÿ�κ���m-1���Ǹ�С����Ҫ���г��׸�,Ȼ���������Ʒ�����������ѡ����,���Ҳ��ٻص�Ȧ��,
 * ��������һ��С���ѿ�ʼ,����0...m-1����....
 * ������ȥ....ֱ��ʣ�����һ��С����,���Բ��ñ���,
 * �����õ�ţ������ġ�����̽���ϡ���ذ�(��������Ŷ!!^_^)��
 * ������������,�ĸ�С���ѻ�õ������Ʒ�أ�(ע��С���ѵı���Ǵ�0��n-1)
 */
public class Solution {
	
	public int LastRemaining_Solution(int n, int m) {
		if(n==0 || m==0) {
			return -1;
		}
        if(n==1) {
        	return 0;
        }
        if(m==1) {
        	return n-1;
        }
        
        
        
        boolean flag[] = new boolean[n];
        int index = 0;
       
    	int step = 0;
    	
    	for(int i=index,cur=n; step<=m && cur!=1 ; i++,i=i%n) {
    		if(flag[i] == false) {
    			
    			step++;
    			if(step==m) {
    				flag[i] = true;
    				//����û��Խ��
    				if(i+1<=n-1) {
    					index = i + 1;
    				}else {
    					index = (i + 1) % n;
    				}
    				step = 0;
    				cur--;
    				//System.out.print(i);
    			}
    			
    			
    		}
    	}
        	
        for(int i = 0; i < n; i++) {
        	if(flag[i]==false) {
        		//System.out.println(i);
        		return i;
        	}
        }
       
        return -1;
        
    }
}

 