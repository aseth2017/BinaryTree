/**
 * A Binary Tree is a data structure in which each node points to two other nodes
 * referred to as its left child and its right child
 * @author Anish Seth
 * @version 12-9-15
 */
import java.lang.Math;
import java.util.Iterator;
import java.lang.Iterable;
public class BinaryTree<E> implements Iterable<E>
{
	protected E value;
	protected BinaryTree<E> left;
	protected BinaryTree<E> right;

	public BinaryTree(E v, BinaryTree<E> l, BinaryTree<E> r)
	{
		value = v;
		left = l;
		right = r;
	}
	/**
	 * Set value equal to v, left and right are null
	 * @param v value to be set
	 */
	public BinaryTree(E v)
	{
		value = v;
		right = null;
		left = null;
	}
	/**
	 * Value, left, and right are all null
	 */
	public BinaryTree()
	{
		value = null;
		right = null;
		left = null;		
	}
	/**
	 * @return Returns left node
	 */
	public BinaryTree<E> left()
	{
		return left;
	}
	/**
	 * 
	 * @return Returns right node
	 */
	public BinaryTree<E> right()
	{
		return right;
	}
	/**
	 * 
	 * @return Returns value
	 */
	public E value()
	{
		return value;
	}
	/**
	 * Sets left node
	 * @param node node left will be set to
	 */
	public void setLeft(BinaryTree<E> node)
	{
		left = node;
	}
	/**
	 * Sets right node
	 * @param node node right will be set to
	 */
	public void setRight(BinaryTree<E> node)
	{
		right = node;
	}
	/**
	 * Sets value
	 * @param val what value will be set to
	 */
	public void setValue(E val)
	{
		value = val;
	}
	/**
	 * Return true if node does not have any children
	 * @return true if node has no leaves, else false
	 */
	public boolean isLeaf()
	{
		return !(right() == null && left() == null);
	}
	/**
	 * Return number of descendants of node, including current node
	 * @return size of tree
	 */
	public int size()
	{
		if(isLeaf())
			return 1;
		else
		{
			if (left != null && right == null)
				return 1 + left.size();
			if (left == null && right != null)
				return 1 + right.size();
			if (left != null && right != null)
				return 1 + left.size() + right.size();
		}
		return 0;

	}
	/**
	 * InOrderIterator
	 * left, root, right
	 */
	public Iterator<E> iterator()
	{
		return inorderIterator();
	}
	/**
	 * root, left, right
	 * @return preorderiterator
	 */
	public Iterator<E> preorderIterator()
	{
		return new PreOrderIterator<E>(this);
	}
	/**
	 * left, root, right
	 * @return inorderiterator
	 */
	public Iterator<E> inorderIterator()
	{
		return new InOrderIterator<E>(this);
	}
	/**
	 * left, right, root
	 * @return postorderiterator
	 */
	public Iterator<E> postorderIterator()
	{
		return new PostOrderIterator<E>(this);
	}
	/**
	 * String representation of the tree
	 */
	public String toString()
	{
		
		if(isLeaf())
			return (String)value;
		else
		{
			if (left != null && right == null)
				return value + "(" + left.toString() + ")";
			if (left == null && right != null)
				return value + "(" + right.toString() + ")";
			return value + "(" + left.toString() + "," + right.toString() + ")";
		}
	}
	/**
	 * Return the maximum path length to a descendent
	 * @return maximum length of tree
	 */
	public int height()
	{
		if(isLeaf())
			return 0;
		else
		{
			int i = 0;
			if(left() != null && right == null)
				i += 1 + Math.max(i, left().height());
			if(right() != null)
				i += 1 + Math.max(i, right().height());
			return i+1;
		}
	}
	/**
	 * Return true if adding a node to tree would increase its height
	 * If etiher right or left is null - set false
	 * @return if right and left are not null, then true, else false
	 */
	public boolean isFull()
	{
		if(isLeaf())
			return true;
		else if(right() == null || left() == null)
			return false;
		return right().height() == left().height() && (left().isFull() && right().isFull());
			
	}
	/**
	 * Return true if tree has minimal height and any holes in the tree
	 * appear in the last level to the right
	 * @return true if height is greater than min and holes only occur at right nodes, else false
	 */
	public boolean isComplete()
	{
		if(isLeaf())
			return true;
		if(left() == null)
			return false;
		if(right() == null && left().isLeaf())
			return true;
		else
		{
			if (left().height() - right().height() == 1)
				return (left().isComplete() && right().isFull());
			if (left().height() == right().height())
				return (left().isFull() && right().isComplete());
			return false;
		}
	}
	/**
	 * Return true if the difference of heights of subtrees at every node
	 * is no greater than one
	 * @return true if height difference is one or less, else false
	 */
	public boolean isBalanced()
	{
		if(isLeaf())
			return true;
		if(left() == null && right() != null && right().height() < 1)
			return true;
		if(right() == null && left() != null && left().height() < 1)
			return true;
		return (Math.abs(left().height()-right().height()) > 1);
	}
}
