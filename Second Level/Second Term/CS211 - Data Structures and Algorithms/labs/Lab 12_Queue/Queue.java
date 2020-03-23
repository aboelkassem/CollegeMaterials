package lab10_queue;

/** A Queue is a data structure in which objects are inserted at one
    end and removed from the other (i.e., first in-first out).
    @author Koffman and Wolfgang
 */

public interface Queue {

  /** Insert an item into the queue.
      @param obj The object to be inserted
      @return The object inserted
   */
  Object insert(Object obj);

  /** Peek at the first item in the queue.
      @return The object at the front of the queue
      @throws EmptyQueueException
   */
  Object peek();

  /** Remove the first item in the queue.
   *  @return The object at the front of the queue
      @throws EmptyQueueException
   */
  Object remove();

  /** Return the size of the queue.
      @return The number of items in the queue
   */
  int getSize();

  /** Determine whether the queue is empty.
      @return true if the queue is empty
   */
  boolean isEmpty();
}
