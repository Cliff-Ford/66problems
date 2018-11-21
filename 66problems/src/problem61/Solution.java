package problem61;



/**
 * @author Cliff_Ford
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class Solution {
	//反序列化时所用
	private int index = 0;
	//先序遍历序列化
	public String Serialize(TreeNode root) {
		if(root==null) {
			return "#,";
		}
		String s = "" + root.val + ",";
		if(root.left==null) {
			s = s + "#,";
		}else {
			String l = Serialize(root.left);
			s = s + l;
		}
		if(root.right==null) {
			s = s + "#,";
		}else {
			String r = Serialize(root.right);
			s = s + r;
		}
		return s;
	}
	public TreeNode Deserialize(String str) {
		TreeNode root = null;
		if(str.length()==0) {
			return root;
		}
		String string[] = str.split(",");
		root = Deserialize(string);
		
		return root;
	}
	//index 为标记string数组当前位置的下标
	public TreeNode Deserialize(String string[]) {
		TreeNode r = null;
		if(!string[index].equals("#")) {
			r = new TreeNode(Integer.valueOf(string[index++]));
			r.left = Deserialize(string);
			r.right = Deserialize(string);
		}else {
			index++;
		}
		return r;
	}
	/*public void check(TreeNode root) {
		if(root!=null) {
			System.out.println(root.val);
			check(root.left);
			check(root.right);
		}
	}*/
}

 