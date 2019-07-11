/*
Queue.java
Noël Khalaf, Tony Kim
300079144, 300087407
ITI1121[Z]
Queue.java is an interface that is implemented by two different types of queues which are run on the same simulator.
*/

public interface Queue{ //define interface Queue
    public abstract void enqueue(Job object); //abstract method which adds an element of type Job to the back queue
    public abstract Job dequeue(); //abstract method which removes an element from the front of the queue
	  public abstract boolean isEmpty(); //override method for isEmpty which checks to see if the queue contains any elements
    public abstract void clear(); //abstract method which removes all elements from the queue, emptying it

}
