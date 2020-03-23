package lab7_ll.dll;

/* A simple container class which holds an element, and references to
 * previous and next Nodes.*/
public class DLLNode<E> {

   /** The element this Node holds. */
   public E element;

   /** A reference to the Node before this one. */
   public DLLNode<E> prev;
   
   /** A reference to the Node after this one. */
   public DLLNode<E> next;

   /* Create a new Node with the given element, adjacent nodes.       
    * @param elem  The element this Node holds.
    * @param prev  The Node which comes before this one.
    * @param next  The Node which comes after this one. */
   public DLLNode(E elem, DLLNode<E> prev, DLLNode<E> next) {
      this.element = elem;
      this.prev = prev;
      this.next = next;
   }

   /* Return a string representation of this Node.       
    * @return A string representation of this Node. */
   public String toString() {
      return element.toString();
   }

} // end class Node