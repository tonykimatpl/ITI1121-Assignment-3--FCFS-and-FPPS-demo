/*
PriorityQueue.java
Noël Khalaf, Tony Kim
300079144, 300087407
ITI1121[Z]
Class instantiates a PriorityQueue object that is a prioritized queue.
*/
public class PriorityQueue implements Queue //define class PriorityQueue which implements interface Queue
{
        private Job[] heap; //instantiate instance variable heap which is an array of elements of type Job
        private int tail; //instantiate instance variable tail of type int that store the first empty slot within array heap

        public PriorityQueue() //constructor instantiates an empty array for the heap and sets the tail to 0.
        {
                heap = new Job[10]; //instantiates an array of jobs of size 10
                tail = 0; //the first open slot is of index 0
        }

        public boolean isEmpty() //checks if the top of the top of the queue and returns True if the queue is empty
        {
				return tail == 0; //if the first open slot is of index 0, the queue is empty and method returns True
        }

        public void enqueue(Job element) //method adds an element of type Job to the tail of the queue
        {
                if(heap.length == tail){ //if the array heap is full
					resize(); //extend the size of the array by a factor of 2, hence adding new empty spaces into the array
				}
				heap[tail] = element; //add element of type Job to the first empty index in array heap
				if(tail > 0){ //if array is not empty
					reverseHeapify(tail); //rearranges the array based on priority
				}
				tail++; //increments the tail to the next free slot in the queue
        }

        public Job dequeue() //method removes an element from the head of the queue and returns its data
        {
          if(heap[0] == null){ //if the array is empty
            return null; //return null
          }
          else{
            Job saved = heap[0]; //set variable saved to point to the first element of the array
    				swap(0,tail-1); //swap the last non empty element with the front of the array
    				heap[--tail] = null; //set the last non empty element to null therefore the element has been removed
    				heapify(0); //rearranges the array based on priority with respect to the first element of the array
    				return saved; //return the data contained within the removed element
          }
        }

        public void clear() //clears the contents of the array
        {
                Job[] temp = new Job[10]; //instantiate a new empty array of size 10
				heap = temp; //sets this to the new empty array
				tail = 0; //sets the first non empty slot of the array to index 0
        }

        private void resize() //doubles the capacity of the given array heap
        {
                Job[] temp = new Job[heap.length*2]; //instantiate a new array containing elements of type Job that has double the capacity of the previous array
				for(int i=0; i<heap.length; i++){ //for loop copying all elements contained in previous array to array temp
					temp[i] = heap[i];
				}
				heap = temp; //set array heap equal to the new array temp which is now double the size
        }

        private void reverseHeapify(int i) //takes the index of the very last element of the array and sorts the array based on element priority
        {
                while(heap[i].getOwner() > heap[parent(i)].getOwner()){ //while the priority of i is greater than the priority of its parent elements
					swap(i,parent(i)); //swap element i with its parent element
				}
        }
        
        /**
         * Given an array index i, this method returns the array index of the i's
         * parent node in the heap.
         *
         * @param i The index of the node for whom's parent we are searching.
         * @return The index in the array of i's parent.
         */
        private int parent(int i)
        {
                return (int) Math.floor((i - 1) / 2.0f);
        }

        /**
         * Given an array index i, this method returns the array index of the i's
         * left child node in the heap.
         *
         * @param i The index of the node for whom's left child we are searching.
         * @return The index in the array of i's left child.
         */
        private int left(int i)
        {
                return 2 * i + 1;
        }

        /**
         * Given an array index i, this method returns the array index of the i's
         * right child node in the heap.
         *
         * @param i The index of the node for whom's right child we are searching.
         * @return The index in the array of i's right child.
         */
        private int right(int i)
        {
                return 2 * i + 2;
        }

        /**
         * Swaps the Job's at position i and j.
         *
         * @param i the array index of one of the job's to be swapped.
         * @param j the array index of the other job to be swapped.
         */
        private void swap(int i, int j)
        {
                Job temp = heap[i];
                heap[i] = heap[j];
                heap[j] = temp;
        }

        /**
         * Heapify works by comparing the current internal node with its children
         * to see which is the largest. If the root is not the largest then it is
         * swapped with the largest of its children. Since the child has now been
         * altered it needs to check to make sure it still satisfies the heap property.
         * Heapify works its way down the tree in this manner and, when it is complete,
         * the tree should again be a heap. The details of how Heapify works are a
         * little complex but the method is provided for you, you just need to
         * understand when to use it.
         *
         * The purpose of heapify is to restore the heap property after one of the
         * internal nodes of the heap has been altered. In the case of a priority queue,
         * this internal nodes get altered during dequeue operations.
         *
         * @param i The index of the node that we are not certain if it satisfied the
         * heap property (one or both of its children might be larger).
         */
        private void heapify(int i)
        {
                int l = left(i);
                int r = right(i);
                int largest = i;

                if (l < tail &&
                    heap[l].getOwner() > heap[largest].getOwner())
                {
                        largest = l;
                }

                if (r < tail &&
                    heap[r].getOwner() > heap[largest].getOwner())
                {
                        largest = r;
                }

                if (largest != i)
                {
                        swap(i, largest);
                        heapify(largest);
                }
        }
}
