package test;





import org.junit.Test;


import problem20.Solution;





public class Test20 {
	@Test
	public void test() {
		Solution solution = new Solution();
		
		
		solution.push(3);
		solution.push(2);
		solution.push(7);
		solution.push(5);
		solution.push(1);
		while(solution.count!=0) {
			System.out.println(solution.min());
			solution.pop();
		}
	}
}
