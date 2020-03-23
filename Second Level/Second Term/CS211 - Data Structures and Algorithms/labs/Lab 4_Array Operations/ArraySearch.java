package lab4_array;

/** Provides a static method search for searching an array.
 *  @author Koffman & Wolfgang
 *  */

public class ArraySearch {

  /** Searches an array to find the first occurrence of a target.
        @param x Array to search
        @param target Target to search for
        @return The subscript of first occurrence if found;
                otherwise, return -1.
   */
  public static int search(int[] x, int target) {
    for (int i = 0; i < x.length; i++) {
      if (x[i] == target)
        return i;
    }

    // target not found
    return -1;
  }

  /** Test method.
        @param args Command line arguments. Not used.
   */
  public static void main(String[] args) {
    int[] x = {
        5, 12, 15, 4, 8, 12, 7}; // Array to search.

    // Test for target as first element.
    verify(x, 5, 0);
    // Test for target as last element.
    verify(x, 7, 6);
    // Test for target not in array.
    verify(x, -5, -1);
    // Test for multiple occurrences of target.
    verify(x, 12, 1);
    // Test for target somewhere in middle.
    verify(x, 4, 3);

    // Test for 1-element array
    x = new int[1];
    x[0] = 10;
    verify(x, 10, 0);
    verify(x, -10, -1);

    // Test for an empty array
    x = new int[0];
    verify(x, 10, -1);
  }

  /** Call the search method with the specified parameters and
        verify the expected result.
        @param x The array to be searched
        @param target The target to be found
        @param expected The expected result
   */
  private static void verify(int[] x, int target, int expected) {
    int actual = search(x, target);
    System.out.print("search(x, " + target + ") is "
                     + actual + ", expected " + expected);
    if (actual == expected)
      System.out.println(":  Pass");
    else
      System.out.println(":  ****Fail");
  }
}
