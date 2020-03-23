package lab5_sort.quicksort;

import java.util.Comparator;



public abstract class Quicksort2 {
	
 /**
   * Sort in nondecreasing order the elements of sequence S between
   * ranks leftBound and rightBound, using a recursive, in-place,
   * implementation of the quick-sort algorithm.
   **/
  private static void quickSortStep (Sequence S, Comparator c,
                              int leftBound, int rightBound ) {
    if (leftBound >= rightBound)
      return;
    Object pivot = S.atRank(rightBound).element();
    int leftIndex = leftBound;     // will scan rightward
    int rightIndex = rightBound-1; // will scan leftward
    while (leftIndex <= rightIndex) {
      // scan rightward to find an element larger than the pivot
      while ( (leftIndex <= rightIndex) &&
            c.isLessThanOrEqualTo(S.atRank(leftIndex).element(), pivot) )
        leftIndex++; 
      // scan leftward to find an element smaller than the pivot
      while ( (rightIndex >= leftIndex) &&
            c.isGreaterThanOrEqualTo(S.atRank(rightIndex).element(), pivot) )
        rightIndex--;
      if (leftIndex < rightIndex) // both elements were found
        S.swapElements(S.atRank(leftIndex), S.atRank(rightIndex));
    } // the loop continues until the indices cross
    // place the pivot by swapping it with the element at leftIndex
    S.swapElements(S.atRank(leftIndex), S.atRank(rightBound));
    // the pivot is now at leftIndex, so recur on both sides of it
    quickSortStep(S, c, leftBound, leftIndex-1);
    quickSortStep(S, c, leftIndex+1, rightBound);
  }
  
  }
