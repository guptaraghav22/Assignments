package DataStructureAssignment;

import java.util.Scanner;
public class Hashtable {

	public class mapNode {
		int key;
		int value;
		mapNode next;

		public mapNode(int key, int value) {
			this.key = key;
			this.value = value;
			next = null;
		}

	}
	
	int Size = 10;
	mapNode bucket[] = new mapNode[Size];
	int count = 0;

	Scanner sc = new Scanner(System.in);

	public void Size() {
		System.out.println("Element's in hash table: " + count);
		return;
	}

	public int getHash(int key) {
		int index = key %Size;
		return index;
	}

	public void insert() {
		System.out.println("Enter key and value pair to add:");
		int key = sc.nextInt();
		int value = sc.nextInt();
		int index = getHash(key);
		mapNode head = bucket[index];

		mapNode temp = head;
		while (temp != null) {
			if (temp.key == key) {
				temp.value = value;
				return;
			} else {
				temp = temp.next;
			}
		}
		mapNode newNode = new mapNode(key, value);
		newNode.next = head;
		bucket[index] = newNode;
		count += 1;
		return;
	}

	public void print() {
		for (int i = 0; i < Size; i++) {
			mapNode head = bucket[i];
			while (head != null) {
				System.out.print(head.key + ":" + head.value);
				if (head.next != null) {
					System.out.print("->");
				}
				head = head.next;
			}
			System.out.println();
		}
		return;
	}

	public void delete() {
		System.out.println("Enter the key to delete");
		int key = sc.nextInt();
		int index = getHash(key);
		mapNode head = bucket[index];
		if (head == null) {
			System.out.println("Key does not exist");
		} else {
			if (head.key == key) {
				head = head.next;
				bucket[index] = head;
			} else {
				mapNode temp = head;
				mapNode prev = null;
				boolean flag = false;
				while (temp != null) {
					if (temp.key == key) {
						prev.next = temp.next;
						flag = true;
						break;
					} else {
						prev = temp;
						temp = temp.next;
					}
				}
				if (flag == false) {
					System.out.println("Key does not exist");
				}

			}

		}

		return;
	}

	public void contain() {
		System.out.println("Enter the key value pair to search:");
		int key = sc.nextInt();
		int index = getHash(key);
		mapNode head = bucket[index];
		if (head == null) {
			System.out.println("Key does not exist");
		} else {
			mapNode temp = head;
			boolean flag = false;
			while (temp != null) {
				if (temp.key == key) {
					System.out.println("It's key value pair is: " + temp.key + " ->" + temp.value);
					flag = true;
					break;
				} else {
					temp = temp.next;
				}
			}
			if (flag == false) {
				System.out.println("value does not exist");
			}

		}

		return;

	}

	public void getValue() {
		System.out.println("Enter the key value ");
		int key = sc.nextInt();
		int index = getHash(key);
		mapNode head = bucket[index];
		if (head == null) {
			System.out.println("value does not exist");
		} else {
			mapNode temp = head;
			boolean flag = false;
			while (temp != null) {
				if (temp.key == key) {
					System.out.println("The value associated with key" + temp.key + ": " + temp.value);
					flag = true;
					break;
				} else {
					temp = temp.next;
				}
			}
			if (flag == false) {
				System.out.println("Key does not exist");
			}

		}

		return;

	}
	

}

