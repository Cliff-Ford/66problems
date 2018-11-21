package problem51;


/**
 * @author Cliff_Ford
 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],
 * ����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
 */
public class Solution {
	public int[] multiply(int[] A) {
		int B[] = null;
		if(A==null || A.length<=1) {
			return B;
		}
		int len = A.length;
		
		
		B = new int[len];
		
		for(int i = 0; i < len; i++) {
			int result = 1;
			int j = 0;
			while(j<i) {
				result *= A[j++];
			}
			int k = i + 1;
			while(k<len) {
				result *= A[k++];
			}
			B[i] = result;
		}		
		return B;
    }
	//o(n)ţ��
	//B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
	//�������� B[i]=A[0]*A[1]*...*A[i-1]
	//���ҵ�����B[i]*=A[i+1]*...*A[n-1]
	/*class Solution {
	public:
	    vector<int> multiply(const vector<int>& A) {
	     
	        int n=A.size();
	        vector<int> b(n);
	        int ret=1;
	        for(int i=0;i<n;ret*=A[i++]){
	            b[i]=ret;
	        }
	        ret=1;
	        for(int i=n-1;i>=0;ret*=A[i--]){
	            b[i]*=ret;
	        }
	        return b;
	    }
	};*/

}

 