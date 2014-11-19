
public class BinarySearchTree <T extends Comparable<T>> extends BinaryTree<T>{
	
	public BinarySearchTree(T data) {
		left = null;
		right = null;
		this.data = data;
	}
	
	public void insert(T newData){
		if(newData.compareTo(data) == -1){
			if(left == null)
				left = new BinarySearchTree<T>(newData);
			else
				((BinarySearchTree<T>)left).insert(newData);
		} else if(newData.compareTo(data) == 1){
			if(right == null)
				right = new BinarySearchTree<T>(newData);
			else
				((BinarySearchTree<T>)right).insert(newData);
		}
	}
	
	public boolean exists(T d){
		if(data.compareTo(d) == 0)
			return true;
		else if (d.compareTo(data) == -1 && left != null)
			return ((BinarySearchTree<T>)left).exists(d);
		else if (d.compareTo(data) == 1 && right != null)
			return ((BinarySearchTree<T>)right).exists(d);
		else
			return false;
	}
}
