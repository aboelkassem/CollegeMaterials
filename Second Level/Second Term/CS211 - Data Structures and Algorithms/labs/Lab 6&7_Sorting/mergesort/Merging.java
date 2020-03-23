package lab5_sort.mergesort;

import java.util.Comparator;

public abstract class Merging {

	/** Sorts an array with a comparator using nonrecursive merge sort. */
	public static <E> void mergeSort(E[] orig, Comparator<E> c) {
		
		E[] in = (E[]) new Object[orig.length]; // make a new temporary array
		System.arraycopy(orig, 0, in, 0, in.length); // copy the input
		E[] out = (E[]) new Object[in.length]; // output array
		E[] temp; // temp array reference used for swapping
		int n = in.length;
		
		for (int i = 1; i < n; i *= 2) { // each iteration sorts all length-2*i
											// runs
			for (int j = 0; j < n; j += 2 * i)
				// each iteration merges two length-i pairs
				merge(in, out, c, j, i); // merge from in to out two length-i
											// runs at j
			temp = in;
			in = out;
			out = temp; // swap arrays for next iteration
		}
		// the "in" array contains the sorted array, so re-copy it
		System.arraycopy(in, 0, orig, 0, in.length);
	}

	/** Merges two subarrays, specified by a start and increment. */
	protected static <E> void merge(E[] in, E[] out, Comparator<E> c,
			int start, int inc) { // merge in[start..start+inc-1] and
									// in[start+inc..start+2*inc-1]
		int x = start; // index into run #1
		int end1 = Math.min(start + inc, in.length); // boundary for run #1
		int end2 = Math.min(start + 2 * inc, in.length); // boundary for run #2
		int y = start + inc; // index into run #2 (could be beyond array
								// boundary)
		int z = start; // index into the out array
		while ((x < end1) && (y < end2))
			if (c.compare(in[x], in[y]) <= 0)
				out[z++] = in[x++];
			else
				out[z++] = in[y++];
		if (x < end1) // first run didn't finish
			System.arraycopy(in, x, out, z, end1 - x);
		else if (y < end2) // second run didn't finish
			System.arraycopy(in, y, out, z, end2 - y);
	}

}
