import java.util.NoSuchElementException;
import java.util.Iterator;

/**
 * Creates a LinkedList
 * Does not have random access
 * @author Anish Seth
 * @version 11-18-15
 */
public class LinkedList<E> implements Iterable<E>, Stack<E>, Queue<E>
{
	protected ListNode<E> head; //First item in the LinkedList
	private ListNode<E> tail; //Last item in the LinkedList
	private int size; //Size of LinkedList
	
	/**
	 * Constructor
	 * Sets head and tail pointers to null
	 */
	public LinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}
	/**
	 * Constructor
	 * @param h sets head pointer equal to ListNode parameter
	 */
	public LinkedList(ListNode<E> h)
	{
		head = h;
		tail = h;
		size++;
	}
	/**
	 * Copy constructor
	 * @param other LinkedList that will be copied to the current List
	 */
	public LinkedList(LinkedList<E> other)
	{
		for (int i = 0; i < other.size; i++)
			add(other.get(i));
		size = other.size;
	}
	/**
	 * 
	 * @return size of list
	 */
	public int Size()
	{
		return size;
	}
	/**
	 * 
	 * @param node 
	 * @return size of list from certain point
	 */
	public int Size(ListNode<E> node)
	{
		if(node == null)
			return 0;
		else
			return Size(node.getNext());
	}
	/**
	 * Adds an item to the end of the LinkedList
	 * @param item Object that is added to the LinkedList
	 * @return Boolean on whether or not we can add the object to the LinkedList
	 */
	public boolean add(E item)
	{
		if(head==null)
		{
			head = new ListNode<E> (null, item);
			tail = head;
		}
		else
		{
			ListNode<E> hold = new ListNode<E> (null, item);
			tail.setNext(hold);
			tail = hold;
		}
		size++;
		return true;
	}
	/**
	 * Adds an item to a specific index in the LinkedList
	 * @param item Object that is added to the LinkedList
	 * @param i Index of the LinkedList where the item is added
	 */
	public void add(E item, int index)
	{
		if (index > size)
			throw new IndexOutOfBoundsException();
		if (index < 0)
			throw new IllegalArgumentException();
		if (index == size)
			add(item);
		else if (index == 0)
		{
			ListNode<E> hold = new ListNode<E>(item);
			hold.setNext(head);
			head = hold;
			size++;
		}
		else
		{
			ListNode<E> hold = new ListNode<E>(item);
			ListNode<E> curr = head;
			for (int i = 0; i < index - 1; i++)
				curr = curr.getNext();
			hold.setNext(curr.getNext());
			curr.setNext(hold);
			size++;
		}
	}
	/**
	 * Add object to stack
	 */
	public void push(E item)
	{
		add(item);
	}
	/**
	 * Add object to queue
	 */
	public void offer(E item)
	{
		add(item);
	}
	/**
	 * Remove item and return whether or not object was removed
	 * @param o Object to be removed
	 * @return true if can be removed, else false
	 */
	public boolean remove(E o)
	{
		if(!contains(o))
			return false;
		remove(indexOf(o));
		size--;
		return true;
	}
	/**
	 * Remove and return item at specified index
	 * @param index index of object to be removed
	 * @return object that has been removed
	 */
	public E remove(int index)
	{
		if(index > size)
			throw new IndexOutOfBoundsException();
		if(index < 0)
			throw new IllegalArgumentException();
		if(index == 0)
		{
			ListNode<E> hold = head;
			head = head.getNext();
			return hold.getObject();
		}
		else
		{
			int counter = 0;
			for(ListNode<E> curr = head; curr != null; curr = curr.getNext())
			{
				if(counter==index)
				{
					E hold = curr.getNext().getObject();
					curr.setNext(null);
					size--;
					return hold;
				}
			}
			return null;
		}
	}
	/**
	 * Remove and return first item in the list
	 * @return object removed
	 */
	public E removeFirst()
	{
		if (isEmpty() == true)
			throw new NoSuchElementException();
		return remove(0);
	}
	/**
	 * Remove and return last item in the list
	 * @return object removed
	 */
	public E removeLast()
	{
		if (isEmpty() == true)
			throw new NoSuchElementException();
		return remove(size);
	}
	/**
	 * Add object to front of list
	 * @param item item to be added
	 */
	public void addFirst(E item)
	{
		add(item, 0);
	}
	/**
	 * Add object to end of list
	 * @param item item to be added
	 */
	public void addLast(E item)
	{
		add(item);
	}

	/**
	 * Return whether or not list contains specified object
	 * @param o object to be checked
	 * @return true if object in list, else false
	 */
	public boolean contains(E o)
	{
		if(indexOf(o) < 0)
			return false;
		return true;
	}
	/**
	 * Return size of the list
	 * @return size of list
	 */
	public int size()
	{
		return size;
	}
	/**
	 * Remove all items from the list
	 */
	public void clear()
	{
		head = null;
		tail = head;
		size = 0;
	}
	/**
	 * Return item at specified index
	 * @param i index of ListNode to be returned
	 * @return object at index
	 */
	public E get(int i)
	{
		if (i >= size || head == null)
			throw new IndexOutOfBoundsException();
		if (i < 0)
			throw new IllegalArgumentException();
		int index = 0;
		for (ListNode<E> curr = head; curr != null; curr = curr.getNext())
		{
			if (index == i)
				return curr.getObject();
			index++;
		}
		return null; 
	}
	/**
	 * Place object at specified location
	 * @param i index of object
	 * @param o object to be placed
	 * @return value at index
	 */
	public E set(int i, E o)
	{
		if (i >= size || head == null)
			throw new IndexOutOfBoundsException();
		if (i < 0)
			throw new IllegalArgumentException();
		int index = 0;
		ListNode<E> hold = head;
		for (ListNode<E> curr = head; curr != null; curr = curr.getNext())
		{
			if (index == i)
			{
				hold = curr;
				E value = hold.getObject();
				hold.setObject(o);
				return value;
			}
			index++;
		}
		E value = hold.getObject();
		hold.setObject(o);
		return value;
	}
	/**
	 * Return index of the first instance of specified object
	 * @param o object in List
	 * @return index of object
	 */
	public int indexOf(E o)
	{
		int i = 0;
		for(ListNode<E> curr = head; curr != null; curr = curr.getNext())
		{
			if(curr.getObject() == o)
				return i;
			i++;
		}
		return -1;
	}
	/**
	 * Remove object from queue
	 * @return object removed
	 */
	public E poll()
	{
		return removeLast();
	}
	/**
	 * Remove object from stack
	 * @return object removed
	 */
	public E pop()
	{
		return removeLast();
	}
	/**
	 * returns first value in stack or queue
	 * @return first value in stack or queue
	 */
	public E peek()
	{
		if (head != null)
			return head.getObject();
		return null;
	}
	/**
	 * Return whether or not list is empty
	 * @return true if empty, else false
	 */
	public boolean isEmpty()
	{
		if(head == null)
			return true;
		return false;
	}

	/**
	 * How the list will be displayed once printed
	 * @return A string representation of the LinkedList
	 */
	public String toString()
	{
		String s = "{ ";
		for(ListNode<E> x = head.getNext(); x != null; x = x.getNext())
		{
			s += "[" + x.toString() + "] ";
		}
		s += "}";
		return s;
	}

	/**
	 * Create and return an iterator
	 * @return iterator of the list
	 */
	public Iterator<E> iterator()
	{
		return new LinkedListIterator<E>(head);
	}
}
