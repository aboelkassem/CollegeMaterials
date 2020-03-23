package lab9_stack.array_stack;

public class ArrayStack {

	public String toString() {
		String s;
		s = "[";
		if (size() > 0)
			s += S[0];
		if (size() > 1)
			for (int i = 1; i <= size() - 1; i++) {
				s += ", " + S[i];
			}
		return s + "]";
	}

	// Prints status information about a recent operation and the stack.
	public void status(String op, Object element) {
		System.out.print("------> " + op); // print this operation
		System.out.println(", returns " + element); // what was returned
		System.out.print("result: size = " + size() + ", isEmpty = "
				+ isEmpty());
		System.out.println(", stack: " + this); // contents of the stack
	}

	/**
	 * Test our program by performing a series of operations on stacks, printing
	 * the operations performed, the returned elements and the contents of the
	 * stack involved, after each operation.
	 */
	public static void main(String[] args) {
		Object o;

		ArrayStack<Integer> A = new ArrayStack<Integer>();
		A.status("new ArrayStack<Integer> A", null);
		A.push(7);
		A.status("A.push(7)", null);
		o = A.pop();
		A.status("A.pop()", o);
		A.push(9);
		A.status("A.push(9)", null);
		o = A.pop();
		A.status("A.pop()", o);

		ArrayStack<String> B = new ArrayStack<String>();
		B.status("new ArrayStack<String> B", null);
		B.push("Bob");
		B.status("B.push(\"Bob\")", null);
		B.push("Alice");
		B.status("B.push(\"Alice\")", null);
		o = B.pop();
		B.status("B.pop()", o);
		B.push("Eve");
		B.status("B.push(\"Eve\")", null);
	}

}
