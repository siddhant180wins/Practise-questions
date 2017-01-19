
class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	TreeNode(int data,TreeNode left, TreeNode right){
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public TreeNode getLeft() {
		return left;
	}
	
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}
	
	public TreeNode createNode(int data){
		return new TreeNode(data,null,null);
	}
	public void inorder(){
		inorder(this);
	}
	private void inorder(TreeNode x){
		if(x!=null){
			inorder(x.getLeft());
			System.out.print(x.getData()+",");
			inorder(x.getRight());
		}
	}
}
public class SumTree {
	public int sum(TreeNode root){
		if(root == null) return 0;
		if(root.getLeft()==null && root.getRight()==null) {
			return root.data;
		}
			int temp = root.getData();
			int add = sum(root.getLeft()) + sum(root.getRight());
			root.setData(add);			
			return (temp + add); 
		}
	public int zigzagConversion(TreeNode root){
		
	}
	public static void main(String s[]){
		TreeNode root = new TreeNode(1,null,null);
		TreeNode r1 = root.createNode(2);
		TreeNode r2 = root.createNode(3);
		root.setLeft(r1);
		root.setRight(r2);
		TreeNode r3 = new TreeNode(4,null,null);
		TreeNode r4 = new TreeNode(5,null,null);
		TreeNode r5 = new TreeNode(6,null,null);
		TreeNode r6 = new TreeNode(7,null,null);
		r1.setLeft(r3);
		r1.setRight(r4);
		r2.setLeft(r5);
		r2.setRight(r6);
		root.inorder();
		new SumTree().sum(root);
		System.out.println();
		root.inorder();
	}
}
