public class BinarySearchTree <E extends Comparable>
{
	private BinaryTree<E> root;

	public BinarySearchTree(E v)
	{
		root = new BinaryTree<E>(v);
	}
	public boolean add(E item);
	{
		return add(item, root);
		//return false if value already exists in the search tree
		//Do NOT DO ITERATIVELY
	}
	public void add(E item, BinaryTree<E> node)
	{
		if(v.equals(item))
			return false;
		if(v.compareTo(root.value()) < 0)
		{
			if(root.left() == null)
			{
				BinaryTree<E> curr = new BinaryTree<E>(v);
				root.setLeft(curr);
				return true;
			}
			return add(v, root.left());
		}
		else if(v.compareTo(root.value()) > 0)
		{
			if(root.right() == null)
			{
				BinaryTree<E> curr = new BinaryTree<E>(v);
				root.setRight(curr);
				return true;
			}
			return add(v, root.right());
		}
		//item.compareto or item.equals
		//Equals, return false
		//Left is null, less than left, return true
		//Right is null, greater than right, link to right, return true
	}
	public BinaryTree<E> find(E item)
	{
		//goes through at lookks for reference of object
		//helps find pointers to the node
		//can eventually be used to remove object
	}
	/** optional
	public E remove(E item)
	{
		//look at algorithms to see how remove works without parent pointers
	}
	*/
	public String toString()
	{
		return root.toString();
	}

}