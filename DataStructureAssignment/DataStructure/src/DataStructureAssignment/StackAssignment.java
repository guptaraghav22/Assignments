package DataStructureAssignment;



public class StackAssignment extends NodeClass {
	Node head;
	
	//---push---
	 public void push(int value) 
	 {	 
		 Node temp = head;
		 Node obj = new Node(value);
		 obj.next=temp;
		 head=obj;
		 }
	 //pop--
	 public void pop() 
	 {
		 if(head!=null) 
		 {
			 int temp=head.data;
			 head=head.next;
			 System.out.println("Poped element="+temp);
		 }
		 else 
		 {
			 System.out.println("Empty");
		 }
		 
		 
		 
	 }
	 //peek()
	 public void peek() 
	 {
		 if(head==null) 
		 {
			 System.out.println("Empty");
		 }
		 else { 
			 System.out.println("Peeked element ="+head.data);
		 }
	 }
	 //Contains
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
	 //Center
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
	 
	 //----Display---
	 public void display() 
	 {
		 Node temp  = head;
		 while(temp!=null) 
		 {
			System.out.print(temp.data+"->");
			temp=temp.next;
		 }
		 
		 
		 
	 }
	 
	


	 
	 
}
