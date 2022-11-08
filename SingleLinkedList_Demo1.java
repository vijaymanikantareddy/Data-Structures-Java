class Node1{
	int data;
	Node1 next;
	public Node1(int data){
		this.data = data;
		this.next = null;
	}
}
public class SingleLinkedList_Demo1 {
	public static void main(String args[]) {
		Node1 n1 = new Node1(101);
		Node1 n2 = new Node1(201);
		Node1 n3 = new Node1(301);
		Node1 n4 = new Node1(401);
		Node1 head = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		System.out.println("Elements in LinkedList are: ");
		Node1 temp = head;
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next; 
		}
		
		
		//insert at beginning
		Node1 newnode = new Node1(55);
		newnode.next = head;
		head = newnode;
		System.out.println("\n\nInsertion at the Beginning");
		System.out.println("New Node is "+newnode.data);
		temp = head;
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next; 
		}
		
		//insert at ending
		newnode = new Node1(777);
		Node1 trav = head;
		while(trav.next != null) {
			trav = trav.next;
		}
		trav.next = newnode;
		System.out.println("\n\nInsertion at the Ending");
		System.out.println("New Node is "+newnode.data);
		temp = head;
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next; 
		}
		
		
		//insert in middle
		newnode = new Node1(252);
		int cnt = 3;
		Node1 pre = head;
		trav = head;
		while(cnt>0) {
			pre = trav;
			trav = trav.next;
			cnt--;
		}
		pre.next = newnode;
		newnode.next = trav;
		
		System.out.println("\n\nInsertion in the Middle");
		System.out.println("New Node is "+newnode.data+" inserted at position 3");
		temp = head;
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next; 
		}
		
		
		//Delete at the Beginning
		head = head.next;
		System.out.println("\n\nDeletion in the Beginning");
		temp = head;
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next; 
		}
		
		
		//Delete in the Middle
		int delnum = 252;
		trav = head;
		pre = head;
		while(trav.data != delnum) {
			pre = trav;
			trav = trav.next;
		}
		pre.next = trav.next;
		System.out.println("\n\nDeletion in the Middle");
		System.out.println("Deleted Node is "+delnum);
		temp = head;
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next; 
		}
		
		
		//Delete in the end
		trav = head;
		pre = head;
		while(trav.next!= null) {
			pre = trav;
			trav = trav.next;
		}
		pre.next = null;
		System.out.println("\n\nDeletion at the Ending");
		temp = head;
		while(temp!=null){
			System.out.print(temp.data + " ");
			temp = temp.next; 
		}
	}
}
