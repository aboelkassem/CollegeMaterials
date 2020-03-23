/* $Id: DLL.java 1684 2007-03-27 03:02:15Z ihewson $ */
package lab7_ll.dll;

/* This class implements doubly linked lists, as covered in Cosc241 lectures. 
 * @author  Iain Hewson*/

public class DLL<E> {
	   
   /* A reference to the first node in this DLL. */
   private DLLNode<E> first;

   /* A reference to the last node in this DLL. */
   private DLLNode<E> last;

   /*Construct an empty DLL.*/
   public DLL() {
      first = null;
      last = null;
   }
   
   /* Return the first element in this DLL, or null if DLL empty.    
    * @return  The first element in this DLL, or null if DLL empty.*/
   public E getFirst() {
      return first != null ? first.element : null;
   }
   
   /* Return the last element in this DLL, or null if DLL empty.    
    * @return  The last element in this DLL, or null if DLL empty.*/
   public E getLast() {
      return last != null ? last.element : null;
   }

   /* Return the number of nodes in this DLL.    
    * @return  The number of nodes in this DLL.*/
   
   public int size() {
	  int size = 0;
	  
      for (DLLNode<E> curr = first; curr != null; curr = curr.next) {
         size++;
      }
      return size;
   }
   
   /* Add an element to the start of this DLL.    
    * @param elem  An element to add to the start of this DLL.*/
   public void addFirst(E elem) {
      insert(elem, null);
   }
   
   /* Add an element to the end of this DLL.    
    * @param elem  An element to add to the end of this DLL.*/
   public void addLast(E elem) {
      // implement this method (only takes one line of code)
	   insert(elem,this.last);
   }

   /* Add a new element after the element 'prev' (or at the end of this DLL if
    * 'prev' isn't found).    
    * @param elem  A new element to add to this DLL.
    * @param prev  An element to add 'elem' after.*/
   public void addAfter(E elem, E prev) {
      // implement this method (start by searching for prev)
	  DLLNode<E> prevNode = search(prev);
	  insert(elem,prevNode);
   }
   
   /* Delete a given element from this DLL.    
    * @param elem  An element to delete from this DLL.*/
   public void delete(E target) {
	   
      DLLNode<E> node = search(target);
      
      if(node == null) return;
      
      DLLNode<E> predecessor = node.prev;
      DLLNode<E> successor = node.next;
      
      if (node == this.first) {
    	  this.first = successor;
    	  successor.prev = null;
      } else if(node == this.last){
    	  predecessor.next = null;
    	  this.last = predecessor;
      } else { 	  
    	  predecessor.next = successor;
    	  successor.prev = predecessor;
      }
      
   }

   /* Return a string representation of DLL to allow System.out.println(aList).    
    * @return  A String representation of this DLL.*/
   public String toString() {
      String result = "[";
      for (DLLNode<E> curr = first; curr != null; curr = curr.next) {
         result += curr;
         if (curr != last) 
            result += ", ";         
      }
      return result + "]";
   }
 
   /* Return a string representation of all the elements in this DLL, in 
    * last-to-first order.    
    * @return  A String representation of this DLL in reverse order.*/
   
   public String reverseString() {
	  String result = "[";
	  for (DLLNode<E> curr = last; curr != null; curr = curr.prev) {
         result += curr;
         if (curr != first)
            result += ", ";         
      }
      return result + "]";
   }
   
   
   /* Find the first Node which contains the given element.    
    * @param elem  The element to search for.
    * @return The first Node containing the given element, or null if no Node
    *         contains the element.*/
   
   private DLLNode<E> search(E target) {     
	   for (DLLNode<E> curr = first; curr != null; curr = curr.next) {
	         if (target.equals(curr.element)) {
	            return curr;
	         }
	   }
	   return null; 
   }
   
   /* Insert a new element after the element 'prev'.  
    * If 'prev' is null then insert 'elem' at the front of this DLL.    
    * @param elem  A new element to insert into this DLL.
    * @param prev  An element to insert 'elem' after. 
    * If 'prev' is null insert 'elem' at the start of this DLL.*/
   private void insert(E elem, DLLNode<E> prev) {
	   
	   DLLNode<E> newNode = new DLLNode<E>(elem,prev,null);
	   
	   if (prev == null) {
		   newNode.next = this.first;
	       this.first = newNode;
	   } else {
		   newNode.next = prev.next;
		   prev.next = newNode;  
	   }
	   
	   DLLNode<E> successor = newNode.next;
       
       if(successor == null) {
    	   newNode.prev = this.last;
    	   this.last = newNode;
       } else {
    	   newNode.prev = successor.prev;
    	   successor.prev = newNode;
       }
   }
   
   public void traverse() {
	      
	   System.out.println("Traversing the list:");  
	   System.out.print("First element=" + this.first);
	   System.out.println(". Last element=" + this.last);
	      
	   System.out.format("%1$10s %2$10s %3$10s\n","element","prev","next");
	   System.out.println("   -----------------------------------");
			   
       for (DLLNode<E> curr = first; curr != null; curr = curr.next)               
          System.out.format("%1$10s %2$10s %3$10s\n",curr.element,curr.prev,curr.next);                
   }

} // end class DLL
