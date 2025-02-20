
public class LinkedList {
	Node head; // head of list

    /* Node Class */
    class Node {
        int data;
        Node next;

        // Constructor to create a new node
        Node(int d)
        {
            data = d;
            next = null;
        }
    }
    /* This function is in LinkedList class. Inserts a
    new Node at front of the list. This method is
    defined inside LinkedList class shown above */
    public void push(int new_data)
    {
    	/* 1 & 2: Allocate the Node &
    			Put in the data*/
    	Node new_node = new Node(new_data);

    	/* 3. Make next of new Node as head */
    	new_node.next = head;

    	/* 4. Move the head to point to new Node */
    	head = new_node;
    }
    /* This function is in LinkedList class.
    Inserts a new node after the given prev_node. This method is
    defined inside LinkedList class shown above */
    public void insertAfter(Node prev_node, int new_data)
    {
    	/* 1. Check if the given Node is null */
    	if (prev_node == null) {
    		System.out.println(
    			"The given previous node cannot be null");
    		return;
    	}

    	/* 2. Allocate the Node &
    	3. Put in the data*/
    	Node new_node = new Node(new_data);

    	/* 4. Make next of new Node as next of prev_node */
    	new_node.next = prev_node.next;

    	/* 5. make next of prev_node as new_node */
    	prev_node.next = new_node;
    }
    /* Appends a new node at the end. This method is
    defined inside LinkedList class shown above */
    public void append(int new_data)
    {
    	/* 1. Allocate the Node &
    	2. Put in the data
    	3. Set next as null */
    	Node new_node = new Node(new_data);

    	/* 4. If the Linked List is empty, then make the
    		new node as head */
    	if (head == null) {
    		head = new Node(new_data);
    		return;
    	}

    	/* 4. This new node is going to be the last node, so
    		make next of it as null */
    	new_node.next = null;

    	/* 5. Else traverse till the last node */
    	Node last = head;
    	while (last.next != null)
    		last = last.next;

    	/* 6. Change the next of last node */
    	last.next = new_node;
    	return;
    }
    void deleteNode(int position)
    {
        // If linked list is empty
        if (head == null)
            return;
 
        // Store head node
        Node temp = head;
 
        // If head needs to be removed
        if (position == 0) {
            head = temp.next; // Change head
            return;
        }
 
        // Find previous node of the node to be deleted
        for (int i = 0; temp != null && i < position - 1;
             i++)
            temp = temp.next;
 
        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;
 
        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;
 
        temp.next
            = next; // Unlink the deleted node from list
    }
 
    /* This function prints contents of linked list starting
       from the given node */
    public void printList()
    {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }
    public static void main(String[] args)
    {
        /* Start with the empty list */
        LinkedList llist = new LinkedList();
 
        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);
        llist.push(8);
 
        System.out.println("\nCreated Linked list is: ");
        llist.printList();
 
        llist.deleteNode(4); // Delete node at position 4
 
        System.out.println(
            "\nLinked List after Deletion at position 4: ");
        llist.printList();
    }
}
