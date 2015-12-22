public interface Stack<E>
{
	void push(E item);
	E pop();
	E peek();
	boolean isEmpty();
}
//LIFO Last in, First out

//Stack<Character> calculator = new LinkedList<Character();