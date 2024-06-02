
public class SingleLinkedList 
{
	Node head;
	
	public void add(int data)
	{
		Node newNode = new Node();
		newNode.data = data;			// create new node and assign its value to the passed value, its link to null
		newNode.link = null;
		
		if (head == null)				// if list is empty, make passed value the first node
		{
			head = newNode;
		}
		else
		{
			Node tempNode = head;					// create temp node to use to traverse through the linked list
			while(tempNode.link != null)		// while we are not at the last node, move to the next node
			{	
				tempNode = tempNode.link;
			}
			tempNode.link = newNode;		// last node in linked list points to new element
		}	
	}
	
	public void remove(int data)
	{
		Node tempNode = head;		
		Node prevNode = head;		// previous node of tempNode
		if (tempNode.data == data)		// check if head is being removed
		{
			head = tempNode.link;
			return;
		}
		while(tempNode.link != null)		// loop through list
		{
			tempNode = tempNode.link;
			if (tempNode.data == data)		// if val to remove is current node
			{
				prevNode.link = tempNode.link;		//prev node link points to two nodes ahead
			}
			prevNode = tempNode.link;
		}
	}
	
	public void print()
	{
		Node tempNode = head;
		while(tempNode.link != null)		// loop through the list, printing every element
		{
			System.out.print(tempNode.data + " ");
			tempNode = tempNode.link;
		}
		System.out.println(tempNode.data);		// since the loop stops at the last element, manually print it
	}
	
	public int size()
	{
		Node tempNode = head;
		int size;
		if (tempNode == null)
		{
			return 0;
		}
		else
		{
			size = 1;
		}
		
		while(tempNode.link != null)
		{
			tempNode = tempNode.link;
			size++;
		}
		return size;
	}
	
	public void swapWithNext(int firstVal)
	{
		Node prevNode = head;		// prevNode = first
		Node tempNode = prevNode.link;		//tempNode = second
		if(prevNode.data == firstVal)	//check if first node is the data to swap
		{
			Node nextNode = tempNode.link;	// nextNode = third node
			head = tempNode;		// set head to second node
			tempNode.link = prevNode;		// second node points to first node now
			prevNode.link = nextNode;		// first node points to third node now
			return;
		}
		
		while(tempNode.link != null)
		{
			if (tempNode.data == firstVal)
			{
				Node nextNode = tempNode.link;
				Node nextNextNode = nextNode.link;
				prevNode.link = tempNode.link;	// prev node points to two nodes ahead
				nextNode.link = tempNode;		// two nodes ahead now points to one node ahead
				tempNode.link = nextNextNode;	// one node ahead now points to three nodes ahead
				return;
			}
			tempNode = tempNode.link;
			prevNode = prevNode.link;
			
		}
	}
	
	public void remSecondHalf()
	{
		int remHalf = size() / 2; 	// will round down if size is odd
		int keepHalf = size() - remHalf; // number of elements to keep
		int counter = 1;
		Node prevNode = head;
		Node tempNode = prevNode.link;
		if (size() == 2)	// if size is 2, make the head point to nothing
		{
			prevNode.link = null;
		}
		
		while(tempNode.link != null)
		{
			if (counter < keepHalf)		// if current list element is less than num of elements to keep, just continue traversing through list
			{
				tempNode = tempNode.link;
				prevNode = prevNode.link;
				counter++;				// increment counter to keep track of current index in list
			}
			else
			{
				prevNode.link = null;		// once past the number of elements to keep, make prevNode point to null as its the new end of list
				return;
			}
		}
		
	}
	
	
}
