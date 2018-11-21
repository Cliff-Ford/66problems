package problem47;


/**
 * @author Cliff_Ford
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字
 * 及条件判断语句（A?B:C）。
 */
public class Solution {
	//为大佬们的疯狂打call
	public int Sum_Solution(int n) {
        int sum = n;
        //当n=1,下一次递归时n=0,&&短路不计算sum不变化返回，递归返回求值
        boolean b = (n>0) && ( ( sum+=Sum_Solution(n-1) ) > 0 );
        //仅仅是为了去掉警告，没有意义的
        b = !b;
        return sum;
    }
}

 