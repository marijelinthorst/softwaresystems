package ss.week4;

public class DoublyLinkedList<Element> {

    private /*@ spec_public @*/ int size;
    private Node head;

    //@ ensures this.size == 0;
    public DoublyLinkedList() {
        size = 0;
        head = new Node(null);
        head.next = head;
        head.previous = head;
    }

    //@ requires element != null;
    //@ requires 0 <= index && index <= this.size;
    //@ ensures this.size == \old(size) + 1;
    //@ ensures this.getNode(index).equals(element);
    public void add(int index, Element element) {
      Node newNode = new Node(element);
      if (index>0 && index<size) {
        newNode.previous=getNode(index-1);
        newNode.next=getNode(index);
        getNode(index).previous = newNode;
        getNode(index-1).next = newNode;
        
      } else if (index == 0) {
        newNode.previous=head;
        newNode.next=getNode(index);
        getNode(index).previous = newNode;
        head.next = newNode;
      } else {
        newNode.previous=getNode(index-1);
        newNode.next=head;
        head.previous = newNode;
        getNode(index-1).next = newNode;
      }
      size = size +1;
    }

    //@ requires 0 <= index && index < this.size;
    //@ ensures this.size == \old(size) - 1;
    public void remove(int index) {
        if (size ==1) {
          head.next = head;
          head.previous = head;
          size = 0;
        } else if (index == 0) {
          head.next = getNode(index+1);
          getNode(index+1).previous = head;
        } else if (index==size-1) {
          getNode(index-1).next=head;
          head.previous=getNode(index-1);
        } else {
          getNode(index-1).next=getNode(index+1);
          getNode(index+1).previous=getNode(index-1);
        }
        size=size-1;
    }

    //@ requires 0 <= index && index < this.size;
    /*@ pure */ public Element get(int index) {
        Node p = getNode(index);
        return p.element;
    }

    /**
     * The node containing the element with the specified index.
     * The head node if the specified index is -1.
     */
    //@ requires -1 <= i && i < this.size;
    //@ pure
    public Node getNode(int i) {
        Node p = head;
        int pos = -1;
        while (pos < i) {
            p = p.next;
            pos = pos + 1;
        }
        return p;
    }

    public int size() {
        return this.size;
    }
    public class Node {
        public Node(Element element) {
            this.element = element;
            this.next = null;
            this.previous = null;
        }

        private Element element;
        public Node next;
        public Node previous;

        public Element getElement() {
            return element;
        }
    }
}
