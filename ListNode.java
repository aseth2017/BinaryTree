/**
 * Creates a ListNode, which is a data structure inside the LinkedList
 * Has an object which it contains and a pointer to the next ListNode
 * @author Anish Seth
 * @version 11-12-15
 * @param <E> The type of ListNode being created
 */
public class ListNode<E>
{
	/** Object in node*/
	private E object;
	/** pointer to next node*/
	private ListNode<E> next;
	/** 
	 * Sets object to parameter
	 * @param object parameter object is set to
	 */
	public ListNode(E object)
	{
		this.object = object;
		next = null;
	}
	/**
	 * Sets values of pointer and object to pointer and object in node
	 * @param pointer set to pointer
	 * @param object set to object
	 */
	public ListNode(ListNode<E> pointer, E object)
	{
		next = pointer;
		object = null;
	}
	/**
	 * 
	 * @return returns the object
	 */
	public E getObject()
	{
		return object;
	}
	/**
	 * 
	 * @return pointer to the next node
	 */
	public ListNode<E> getNext()
	{
		return next;
	}
	/**
	 * 
	 * @param object set object to parameter
	 */
	public void setObject(E object)
	{
		this.object = object;
	}
	/**
	 * 
	 * @param pointer sets pointer to new ListNode
	 */
	public void setNext(ListNode<E> pointer)
	{
		next = pointer;
	}
	/**
	 * @return String representation of the ListNode
	 */
	public String toString()
	{
		return object.toString();
	}
}
	