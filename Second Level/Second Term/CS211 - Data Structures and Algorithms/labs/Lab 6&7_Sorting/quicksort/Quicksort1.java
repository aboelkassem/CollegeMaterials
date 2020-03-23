package lab5_sort.quicksort;

import java.util.Comparator;

public abstract class Quicksort1 {

private static <E> void quickSortStep (E[] s, Comparator<E> c,
                              int leftBound, int rightBound ) {
    if (leftBound >= rightBound) return; // the indices have crossed
    E temp;  // temp object used for swapping
    E pivot = s[rightBound];
    int leftIndex = leftBound;     // will scan rightward
    int rightIndex = rightBound-1; // will scan leftward
    while (leftIndex <= rightIndex) { // scan right until larger than the pivot
      while ( (leftIndex <= rightIndex) && (c.compare(s[leftIndex], pivot)<=0) )
        leftIndex++; 
      // scan leftward to find an element smaller than the pivot
      while ( (rightIndex >= leftIndex) && (c.compare(s[rightIndex], pivot)>=0))
        rightIndex--;
      if (leftIndex < rightIndex) { // both elements were found
        temp = s[rightIndex]; 
	s[rightIndex] = s[leftIndex]; // swap these elements
	s[leftIndex] = temp;
      }
    } // the loop continues until the indices cross
    temp = s[rightBound]; // swap pivot with the element at leftIndex
    s[rightBound] = s[leftIndex]; 
    s[leftIndex] = temp; // the pivot is now at leftIndex, so recurse
    quickSortStep(s, c, leftBound, leftIndex-1);
    quickSortStep(s, c, leftIndex+1, rightBound);
  }

}
