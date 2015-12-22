import java.util.Iterator;
public class InOrderIterator<E> implements Iterator<E>
{
	private Queue<E> Trees;
	/**
	 * Takes in BinaryTree
	 * @param tree tree to be iterated
	 * Left, Value, Right
	 */
	public InOrderIterator(BinaryTree<E> tree)
	{
		Trees = new LinkedList<E>();
		fill(tree);
	}
	/**
	 * Fills queue with values
	 * @param tree tree that will be iterated
	 */
	public void fill(BinaryTree<E> tree)
	{
		if(tree.isLeaf() == true)
			Trees.offer(tree.value());
		else
		{
			
			if(tree.left() != null)
				fill(tree.left());
			Trees.offer(tree.value());
			if(tree.left() != null)
				fill(tree.left());
		}
	}
	/**
	 * Returns true if element exists in next position, else false
	 * @return boolean does another element exist in the vector
	 */	
	public boolean hasNext()
	{
		return !Trees.isEmpty();
	}
	/**
	 * Returns next item in vector
	 * @return Next element in vector
	 */
	public E next()
	{
		return Trees.poll();
	}
}