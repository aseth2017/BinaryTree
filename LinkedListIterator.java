import java.util.NoSuchElementException;
import java.util.Iterator;

/** 
* Iterator for LinkedList
* @author Anish Seth
* @version 11/22/15
*/
public class LinkedListIterator<E> implements Iterator<E>
{
	/** current ListNode*/
	private ListNode<E> curr;
	
	/**
	* 
	* @param l List that will be iterated
	*/
	public LinkedListIterator(ListNode<E> l)
	{
		curr = l;
	}
	
	/**
	* 
	* @return true if not end of list
	*/
	public boolean hasNext()
	{
		return (curr != null);
	}
	
	/**
	*
	* @return next value in list
	*/
	public E next()
	{
		if (!hasNext())
			throw new NoSuchElementException();
		E hold = curr.getObject();
		curr = curr.getNext();
		return hold;
	}
}
