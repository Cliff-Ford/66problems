package problem51;


/**
 * @author Cliff_Ford
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
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
	//o(n)牛逼
	//B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]
	//从左到右算 B[i]=A[0]*A[1]*...*A[i-1]
	//从右到左算B[i]*=A[i+1]*...*A[n-1]
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

 