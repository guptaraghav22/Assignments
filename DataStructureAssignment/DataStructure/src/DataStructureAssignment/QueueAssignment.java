package DataStructureAssignment;



public class QueueAssignment extends NodeClass {
	Node head;

	// Node class
	

	// Enqueue-------
	public void enqueue(int value) {
		
		if (head == null) {
			head = new Node(value);
			return;
		}
		Node temp = head;
		while (temp.next != null) 
		{
			temp = temp.next;
		}
		temp.next = new Node(value);
	
	}
	//dequeue
	public void dequeue() 
	{
		if(head!=null)
		{
			head=head.next;
		}
		else 
		{
			System.out.print("Empty");
		}
	}

	// --Display
	public void display() {
		Node temp = head;
		while (temp!= null) {
			System.out.print(temp.data + "<-");
			temp = temp.next;
			
		}
	}
	//peek--
	public void peek() 
	{
		System.out.println(head.data);
	}
	//contains
	 public boolean contains(int value) 
	 {	Node temp = head;
	 	
	 	while(temp.next!=null) 
	 	{
	 		if(temp.data==value)
	 		{return true;
	 			
	 		}
	 		temp=temp.next;
	 	
	 		
	 	}
	 	
		return false;
	 }
	 //size
	 public void size() {
			int Size=0;
			Node temp=head;
			while(temp!=null) {
				Size++;
				temp=temp.next;
			}
			System.out.println("Size is"+Size);
			
			}
	 //reverse--
	 public void reverse() 
		{
			Node prev = null;
			Node curr = head;
			Node Next =null;
			while(curr!=null) 
			{
				Next=curr.next;
				curr.next=prev;
				prev=curr;
				curr=Next;
			}
			head =prev;
		}
	 //iterator
	 public boolean hasnext(Node temp) {
		 if(temp==null)
		 {return false;}
		 return true;
	 }
	 public void iterator()
	 {
		 Node temp= head;
		 if(temp==null)
		 {
			 System.out.print("Empty");
			 return;
		 }
		do
		 {
			System.out.print(temp.data); 
			temp=temp.next;
			
			
		 }
		while(hasnext(temp)); 
			
			System.out.println();
		
		
		 
		 
	 }


	//Sorting
		public void sort() 
		{
			
			int Size=0;
			Node temp=head;
			while(temp!=null) {
				Size++;
				temp=temp.next;
			}
			
			for(int i=0;i<Size;i++) {
				Node curr=head;
				Node Next=curr.next;
				for(int j=0;j<Size-i-1;j++) {
					if(curr.data>Next.data)
					{
						int value= curr.data;
						curr.data=Next.data;
						Next.data=value;
						
					}
					curr=Next;
					Next=Next.next;
				}
			}
			
		}
	 //centere
	 public void center() 
		{ 
			Node slow = head;
			Node fast=head;
			while(fast!=null && fast.next!=null) 
			{	slow=slow.next;
				fast=fast.next.next;
				
			}
			System.out.println();
			System.out.println("Center Element is"+slow.data);
		}

	

}
