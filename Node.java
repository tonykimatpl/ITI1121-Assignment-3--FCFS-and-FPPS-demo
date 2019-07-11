/*
Node.java
Noël Khalaf, Tony Kim
300079144, 300087407
ITI1121[Z]
Class instantiates an object of type Node.
*/
public class Node{ //define class Node
	private Job data; //instantiate instance variable data of type Job
	private Node next; //instantiate instance variable next of type Node which points to the next node in the queue

	public Node(Job data, Node next){ //constructor that takes elements of type Job and Node and initializes a new object of type Node containing these elements
		this.data = data;
		this.next = next;
	}

	public Node(Job data){ //constructor that takes an element of type Job and initializes a new object of type Node with the next Node pointing to null
		this.data = data;
		this.next = null;
	}

	public Job getData(){ //getter method to return the data stored within a Node
		return this.data;
	}

	public void setData(Job data){ //setter method to set the data stored within a Node to element data of type Job
		this.data = data;
	}

	public Node getNext(){ //getter method to return the next Node contained withing this Node
		return this.next;
	}

	public void setNext(Node next){ //setter method to point the next Node to another object next of type Node.
		this.next = next;
	}
}
