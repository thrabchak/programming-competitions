import java.util.ArrayList;

public class BinaryTree<T extends Comparable<T>>{
	
	BinaryTree<T> left;
	BinaryTree<T> right;
	public T data;
	
	BinaryTree(){
		left = null;
		right = null;
		data = null;
	}
	
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
	
	public ArrayList<T> inOrderTraversal(){
		ArrayList<T> output = new ArrayList<T>();
		if(left != null)
			output.addAll(left.inOrderTraversal());
		output.add(data);
		if(right != null)
			output.addAll(right.inOrderTraversal());
		return output;
	}
	
	public ArrayList<T> preOrderTraversal(){
		ArrayList<T> output = new ArrayList<T>();
		output.add(data);
		if(left != null)
			output.addAll(left.preOrderTraversal());
		if(right != null)
			output.addAll(right.preOrderTraversal());
		return output;
	}
	
	public ArrayList<T> postOrderTraversal(){
		ArrayList<T> output = new ArrayList<T>();
		if(left != null)
			output.addAll(left.postOrderTraversal());
		if(right != null)
			output.addAll(right.postOrderTraversal());
		output.add(data);
		return output;	
	}
	
	public String toString(){
		ArrayList<T> traversal = inOrderTraversal();
		StringBuffer output = new StringBuffer();
		for(int i = 0; i < traversal.size(); i++)
			output.append(traversal.get(i).toString() + " ");
		return output.toString();
	}
}
