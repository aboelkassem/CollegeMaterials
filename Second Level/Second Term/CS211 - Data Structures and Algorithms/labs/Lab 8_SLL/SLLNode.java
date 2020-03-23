package lab7_ll.sll;

/* An inner class: A simple container class which holds an element, and a reference to
 * the next Node. */
public class SLLNode<E> {

   /** The element this Node holds. */
	public E element;

   /** Holds the Node after this one. */
	public SLLNode<E> next;


   /** Create a new Node with the given element, adjacent nodes.       
    * @param elem the element this Node holds.
    * @param next the Node which comes after this one.*/
   public SLLNode(E elem, SLLNode<E> next) {
      this.element = elem;
      this.next = next;
   }

   /** Return a string representation of this Node.       
    * @return a string representation of this Node.*/
   public String toString() {
      return element.toString();
   }

} // end class Node	
