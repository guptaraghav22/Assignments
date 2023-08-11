package DataStructureAssignment;

import java.util.ArrayList;
import java.util.List;

public class Mainclass {
	public static void main(String args[]) {
//        NewLinkedList();
//        
//		Stack();
//		Queue();
//		
//		PriorityQ();
		hashtable();
	}

	public static void NewLinkedList() {
		LinkedListAssignment LL = new LinkedListAssignment();
		LL.Insert(5);
		LL.Insert(1);
		LL.Insert(3);
		LL.Insert(6);
		LL.Insert(4);
		LL.Insert(7);
		LL.print();
		System.out.println();
		System.out.println("----------");
		LL.InsertPosition(8, 3);
		LL.InsertPosition(8, 4);
		LL.InsertPosition(218, 6);
		System.out.println("----------");
		LL.DeletePosition(3);
		LL.DeletePosition(2);
		LL.print();
//		LL.sort();
//		LL.reverse();
//		LL.iterator();
//		LL.print();
	}

	public static void PriorityQ() {
		PriorityQueuesAssignment obj = new PriorityQueuesAssignment();
		obj.enqueue(1221, 1);
		obj.enqueue(1222, 2);
		obj.enqueue(1229, 3);
		obj.enqueue(1225, 4);
		obj.enqueue(1227, 5);
		obj.display();
		System.out.println();
//		obj.dequeue();
//		obj.display();
//		System.out.println();
//		obj.peek();
//		
//		System.out.print(obj.contains(1221));
//		obj.size();
		obj.sort();
//		obj.reverse();
//		obj.Center();
		obj.display();
		

	}

	public static void Queue() {
		QueueAssignment obj1 = new QueueAssignment();
		obj1.enqueue(5);
		obj1.enqueue(6);
		obj1.enqueue(7);
		obj1.enqueue(8);
		obj1.enqueue(9);
	
		obj1.enqueue(1);
		obj1.enqueue(2);
		obj1.enqueue(3);
		obj1.enqueue(4);
//		System.out.println();
		
		obj1.display();
		System.out.println();
		System.out.println("---------------");
//		obj1.center();
//		obj1.dequeue();
//		obj1.display();
//		System.out.println("---------------");
//		obj1.peek();
//		System.out.println("---------------");
//		obj1.size();
//		obj1.sort();
//		obj1.center();
		obj1.reverse();
		obj1.display();

	}

	public static void Stack() {
		StackAssignment newstack = new StackAssignment();
		newstack.push(1);
		newstack.push(2);
		newstack.push(3);
		newstack.push(9);
		newstack.push(5);

//		 newstack.peek();
//		 System.out.println(newstack.contains(4));
//		 System.out.println(newstack.contains(8));
		newstack.size();
		System.out.println();
		newstack.Center();
	

		newstack.push(6);
		newstack.push(7);

		newstack.display();
//		newstack.sort();
		newstack.reverse();
		System.out.println();
		newstack.display();
	}

	public static void hashtable() {

		Hashtable obj = new Hashtable();
		obj.insert();
		obj.insert();
		obj.insert();
		obj.insert();
		obj.insert();
		obj.insert();
		obj.insert();
		obj.insert();
		obj.insert();
		obj.insert();
		obj.insert();
		obj.insert();
		
		
//		
//		obj.delete();
		obj.print();
//		obj.insert();
//		obj.contain();
//		obj.delete();
		obj.getValue();
		obj.getValue();
		obj.getValue();
//		obj.getValue();
//		obj.Size();
		obj.print();

	}

}
