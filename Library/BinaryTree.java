public class BinaryTree<T extends Comparable<T>>{
	
	private BinaryTree<T> left;
	private BinaryTree<T> right;
	public T data;
	
	public BinaryTree(T data){
		left = null;
		right = null;
		this.data = data;
	}
	
	public void insertLeft(T data){
		if(left == null )
			left = new BinaryTree<T>(data);
		else
			left.insertLeft(data);
	}
	
	public void insertRight(T data){
		if(right == null)
			right = new BinaryTree<T>(data);
		else
			right.insertRight(data);
	}
	
	public boolean isBST(){
		if(left != null){
			if(left.data.compareTo(data) == 1)
				return false;
			if(!left.isBST())
				return false;
		}
		
		if(right != null){
			if(right.data.compareTo(data) == -1)
				return false;
			if(!right.isBST())
				return false;
		}			
		
		return true;
	}
	
	public int size(){
		int count = 1;
		
		if(left != null)
			count += left.size();
		if(right != null)
			count += right.size();
		
		return count;
	}
	
	public boolean exists(T data){
		if(this.data == data)
			return true;	
		if(left != null && left.exists(data))
			return true;
		if(right != null && right.exists(data))
			return true;
		
		return false;
	}
	
	public String toString(){
		
		
		return "";
	}
}
