package DataStructureAssignment;



public class PriorityQueuesAssignment {
	Node head=null;
//Node class
	class Node
	{
		int data;
		int priority;
		Node next;
	
	Node(int d, int p)
	{
		this.data=d;
		this.priority=p;
		this.next=null;
	}
	
	
}
	//Enqueue
	public void enqueue(int data,int priority) 
	{	Node newnode =new Node(data,priority);
		if(head==null) 
		{
			head=newnode;
		}
		else if(head.priority>priority) 
		{
			newnode.next=head;
			head=newnode;
		}
		else 
		{
			Node ptr = head.next;
			Node prev = head;
			while(ptr!=null)
			{
				if(ptr.priority>priority) 
				{
					prev.next=newnode;
					newnode.next=ptr;
					break;
				}
				prev=ptr;
				ptr=ptr.next;
			}
			if(ptr==null)
			{
				prev.next=newnode;
			}
		}
		
	}
	
	//Dequeue-------
	public void dequeue() 
	{
		if(head==null)
		{
			System.out.print("Empty");
		}
		
		System.out.print(head.data+"Removed");
		System.out.println("");
		head=head.next;
	}
	
	//peek--------------
	public void peek() 
	{
		if(head==null)
		{
			System.out.print("PQ is empty");
			
		}
		else 
		{
			System.out.print(head.data);
			System.out.println();
			
			
		}
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
	//Size
		 public void size() 
		 {
			 Node temp=head;
			 int count=0;
			 while(temp!=null) 
			 {
				 count++;
				 temp=temp.next;
			 }
			 System.out.print("Length of the satck is "+count);
		 }
		 //Sort
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
		 //reverse
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
		 //centere
		 public void Center() 
		 {
			 Node slow=head;
			 Node fast = head;
			 while(fast!=null&&fast.next!=null) 
			 {
				 slow = slow.next;
				 fast=fast.next.next;
			 }
			 System.out.println("Center is "+slow.data);
		 }
		 //Display-----------------
		 public void display() 
		 {
			 if(head==null)
			 {
				 System.out.print("The list is empty");
			 }
			 else 
			 {
				 Node ptr= head;
				 while(ptr!=null) 
				 {
					 System.out.print(ptr.data+"<-");
					 ptr=ptr.next;
				 }
			 }
		 }
	
}
