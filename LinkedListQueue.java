/*
LinkedListQueue.java
Noël Khalaf, Tony Kim
300079144, 300087407
ITI1121[Z]
Class instantiates an LinkedListQueue object which implements a linked list as a queue.
*/
public class LinkedListQueue implements Queue{ //define class LinkedListQueue which implements interface Queue
	private Node head; //instantiate instance variable of type Node that points to the start of the list
	private Node tail; //instantiate instance variable of type Node that points to the end of the list

	public void enqueue(Job object){ //method adds an element of type Job to the tail of the queue
		if(isEmpty()){ //if the queue is empty
			head = new Node(object); //the start of the line is defined as a new Node containing element object of type Job
			tail = head; //the end of the line is the start of the line since there is only one element in the queue
		}
		else{ //if the queue is not empty
			Node temp = new Node(object); //set a temporary Node pointing to the Node containing element object of type Job
			tail.setNext(temp); //set tail.next to the object temp of type Node containing element object of type Job
			tail = tail.getNext(); //tail now points to the last element of the queue
		}
	}

	public Job dequeue(){ //method removes an element from the head of the queue and returns its data
		if(isEmpty()){ //if the queue is empty
			return null; //there is nothing to remove
		}
		else if(head == tail){ //if there is only one element in the queue
			Job saved = head.getData(); //variable saved points to the data contained within the first element of the queue
			head = null; //set head of queue to null
			tail = null; //set tail of queue to null
			return saved; //return the data contained within the removed Node
		}
		else{ //if there is more than one element in the queue and the queue is not empty
			Job saved = head.getData(); //variable saved points to the data contained within the first element of the queue
			head = head.getNext(); //set head of queue to the next Node contained in the queue
			return saved; //return the data contained within the removed Node
		}
	}

	public boolean isEmpty(){ //checks if the top of the top of the queue and returns True if the queue is empty
		return head == null; //if the head of the queue is null, returns True
	}

	public void clear(){ //clears the contents of the queue
		head = null; //head points to null
		tail = null; //tail points to null
	}
}
