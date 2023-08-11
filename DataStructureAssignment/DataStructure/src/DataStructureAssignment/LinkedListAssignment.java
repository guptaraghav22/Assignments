package DataStructureAssignment;



public class LinkedListAssignment extends NodeClass
{	
	 
	
	Node head;
	
	Node iterator;
	//Node Class
	
	//Inserting Node
	public void Insert(int data) 
	{	Node NewNode = new Node(data);
	
		if(head==null) 
		{
			head=NewNode;
			return;
		}
	
		NewNode.next=head;
		head=NewNode;
		}
	//Inserting at a position
	public void InsertPosition(int data, int position) 
	{  
		
		Node newhead = head;
		if(position <1) 
		{
			System.out.print("Invalid Position");
			
		}
		if(position==1)
		{
			Node NewNode = new Node(data);
			NewNode.next=head;
			head=NewNode;
		}
		else {
			Node NewNode = new Node(data);
			int count=1;
			while(newhead.next!=null && count <position) 
			{
				newhead=newhead.next;
				count++;
			}
			Node temp = newhead.next;
			newhead.next=NewNode;
			NewNode.next=temp;
			newhead.next=NewNode;
		}
		
	
		
	}
	//Deleting a node
	public void Delete()
	{
		if(head==null)
		{
			System.out.print("List is Empty");
		}
		else 
		{
			
			head=head.next;
		}
	}
	//Delete at a position
	public void DeletePosition(int position) 
	{
		Node newhead = head;
		if(position <1) 
		{
			System.out.print("Invalid Position");
			
		}
		else if(position==1)
		{
			head=head.next;
		}
		else {
			
			int count=1;
			while(newhead.next!=null && count <position) 
			{
				newhead=newhead.next;
				count++;
			}
			 Node nextt = newhead.next.next;
			 newhead.next= nextt;
			  
		       
		            
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
	//Center
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
	//Size
	public void size() {
	int Size=0;
	Node temp=head;
	while(temp!=null) {
		Size++;
		temp=temp.next;
	}
	System.out.println("Size is"+Size);
	
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
	//Iterate
	public void iterate() 
	{
		Node temp =head;
		if(temp==null)
		{
			System.out.print("Empty");
		}
		do
				{
					System.out.print(temp.data+"->");
					temp=temp.next;
				}
		while(Hasnext(temp));
		
	}
	public boolean Hasnext(Node temp) 
	{if(temp==null) 
	{
		return false;
	}
	else {
		return true;
	}
	}
	//Traverse/Print
	public void print() 
	{
		Node newnode =head;
		if(newnode==null) 
		{
			System.out.print("Linked List is Empty");
		}
		System.out.print("Null");
		while(newnode!=null)
		{
			System.out.print("<-"+newnode.data);
			newnode=newnode.next;
		}
		
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
	
	

}
