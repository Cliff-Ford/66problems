package test;






import org.junit.Test;


import problem51.Solution;




public class Test51 {
	@Test
	public void test() {
		Solution solution = new Solution();
		int a1[] = null;
		int a2[] = {};
		int a3[] = {1};
		int a4[] = {1,2};
		int a5[] = {3,5,6};
		int a6[] = {0,1,2};
		int a7[] = {4,5,6,7,8};
		System.out.println(solution.multiply(a1));
		System.out.println(solution.multiply(a2));
		System.out.println(solution.multiply(a3));
		int r[] = solution.multiply(a4);
		for(int i = 0; i < r.length; i++) {
			System.out.print(r[i]+" ");
		}
		System.out.println();
		r = solution.multiply(a5);
		for(int i = 0; i < r.length; i++) {
			System.out.print(r[i]+" ");
		}
		System.out.println();
		r = solution.multiply(a6);
		for(int i = 0; i < r.length; i++) {
			System.out.print(r[i]+" ");
		}
		System.out.println();
		r = solution.multiply(a7);
		for(int i = 0; i < r.length; i++) {
			System.out.print(r[i]+" ");
		}
		System.out.println();
		
		
	}
	
	
}
