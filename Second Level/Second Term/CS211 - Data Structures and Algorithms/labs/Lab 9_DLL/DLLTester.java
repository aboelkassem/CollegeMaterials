package lab7_ll.dll;

public class DLLTester {

	private DLL<String> dll = null;
	
	public void createDLL()
	{
		this.dll = new DLL<String>();
	}
	
	public void addElements()
	{
		this.dll.addFirst("C");
		this.dll.addFirst("A");
		this.dll.addLast("D");
		this.dll.addAfter("B","A");
		showStatus();
	}
	
	public void removeElements()
	{
		System.out.println("Delete A");
		this.dll.delete("A"); // remove the first node
		dll.traverse();
		
		System.out.println("Delete C");
		this.dll.delete("C"); // remove an intermediate node
		dll.traverse();
		
		System.out.println("Delete D");
		this.dll.delete("D"); // remove the last node
		dll.traverse();
	}
	
	public void showStatus()
	{
		System.out.println("The list=" + this.dll.toString());
		System.out.println("The reversed list=" + this.dll.reverseString());
		System.out.println("The length of the list=" + this.dll.size());
		dll.traverse();
	}
	
	public static void main(String[] args) {
		
		DLLTester dllTester = new DLLTester();
		dllTester.createDLL();
		dllTester.addElements();
		dllTester.removeElements();
	}
}
