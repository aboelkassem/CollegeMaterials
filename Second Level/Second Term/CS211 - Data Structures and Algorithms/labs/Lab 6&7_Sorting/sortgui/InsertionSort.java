package lab5_sort.sortgui;

/**
 * An insertion sort implementation which is able to be observed through its
 * Sorter superclass.
 *
 * @author Iain Hewson
 */
public class InsertionSort extends Sorter { // make your class extend Sorter

   /**
    * Create a new InsertionSort sorter with the given integers to sort.
    * 
    * @param nums the integers to sort.
    */
   public InsertionSort(Integer[] nums) {
      super(nums);  // pass nums to our super class (Sorter) because nums
                    // gets stored as a protected datafield there not here
   }

   /**
    * Sort the integers (which are stored in the parent Sorter class). 
    */
   public void sortNums() {
      int tmp;
      // We don't declare comparisons or i or j.  They are declared
      // in Sorter as protected datafields so we can use and alter them.
      // For shell sort don't declare h either.
      comparisons = 0;
      // make sure your array is called nums, since you should access the
      // protected datafield nums in Sorter
      for (i = 1; i < nums.length; i++) {
         tmp = nums[i];
         for (j = i-1; j >=0 && ++comparisons > 0 && nums[j] >= tmp; j--) {
            nums[j+1] = nums[j];
            update();  // tell super class i, j, nums, and comparisons changed
         }
         nums[j+1] = tmp;
         update(); // tell super class we've altered the contents of nums
      }
      update(); // this one is just to say we are finished
   }

}
