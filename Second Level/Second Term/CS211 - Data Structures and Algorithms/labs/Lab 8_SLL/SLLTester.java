package lab7_ll.sll;

public class SLLTester {

	private SLL sll = null;
	
	public void createSLL()
	{
		this.sll = new SLL();
	}
	
	public void addElements()
	{
		this.sll.addFirst("C");
		this.sll.addFirst("A");
		this.sll.addLast("D");
		this.sll.addAfter("B","A");
		showList();		
	}
	
	public void removeElements()
	{
		this.sll.delete("A"); // remove the first node
		sll.traverse();
		this.sll.delete("C"); // remove an intermediate node
		sll.traverse();
		this.sll.delete("D"); // remove the last node
		sll.traverse();
	}
	
	public void showList()
	{
		System.out.println("The list=" + this.sll.toString());
		System.out.println("The length of the list=" + this.sll.size());
		sll.traverse();
	}
	
	public static void main(String[] args) {
		
		SLLTester sllTester = new SLLTester();
		sllTester.createSLL();
		sllTester.addElements();
		sllTester.removeElements();
	}

}
