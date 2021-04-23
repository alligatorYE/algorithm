package linkedlist;

import java.util.StringJoiner;

/**
 * @Description
 * @Version v1.0
 * @Author yange1
 * @Time 2021/3/3 16:25
 */

public class SinglyLinkedList {
    /** Head refer to the front of the list */
    private Node head;

    /** Size of SinglyLinkedList */
    private int size;

    /** Init SinglyLinkedList */
    public SinglyLinkedList(){
        this.head = null;
        this.size = 0;
    }

    /**
     * Init SinglyLinkedList with specified head node and size
     *
     * @param head the head node of list
     * @param size the size of list
     */
    public SinglyLinkedList(Node head, int size){
        this.head = head;
        this.size = size;
    }

    /**
     * Inserts an element at the head of the list
     *
     * @param data element to be added
     */
    public void insertAtHead(int data){
        insertAtNth(data,0);
    }

    /**
     * Insert an element at the tail of the list
     *
     * @param data element to be added
     */
    public void insertAtTail(int data){
        insertAtNth(data,size);
    }

    /**
     * Inserts a new node at a specified position of the list
     *
     * @param data     data to be stored in a new node
     * @param position position at which a new node is to be inserted
     */
    public void insertAtNth(int data, int position){

        /** check position*/
        checkBounds(position, 0, size);

        Node newNode = new Node(data);

        if (head == null){
            /** the list is empty */
            head = newNode;
            size++;
            return;
        }else if (position == 0){
            /** insert at the head of the list */
            newNode.setNext(head);
            head = newNode;
            size++;
            return;
        }
        Node cur = head;

        for (int i = 0; i < position -1; i++) {
            cur = cur.getNext();
        }
        newNode.setNext(cur.getNext());
        cur.setNext(newNode);
        size++;
    }

    /** Deletes a node at the head */
    public void deleteAtHead(){
        deleteAtNth(0);
    }

    /** Deletes an element at the tail */
    public void deleteAtTail(){
        deleteAtNth(size);
    }

    /** Deletes an element at Nth position */
    public void deleteAtNth(int position){
        checkBounds(position, 0,size - 1);
        if (position == 0){
            Node destory = head;
            head = head.getNext();
            destory = null;
            size--;
            return;
        }
        Node cur = head;
        for (int i = 0; i < position; i++) {
            cur = cur.getNext();
        }
        Node destory = cur.getNext();
        cur.setNext(cur.getNext().getNext());
        destory = null;
        size--;
    }

    /**
     * @param position to check position
     * @param low      low index
     * @param high     high index
     * @throws IndexOutOfBoundsException if {@code position} not in range
     *                                   {@code low} to {@code high}
     */
    public void checkBounds(int position, int low, int high){
        if (position >high || position < low){
            throw new IndexOutOfBoundsException(position + "");
        }
    }

    /** Clear all nodes in the list */
    public void clear(){

        Node cur = head;

        while (cur != null){
            Node prev = cur;
            cur = cur.getNext();
            prev = null;
        }
        head = null;
        size = 0;
    }

    /**
     * Checks if the list is empty
     *
     * @return {@code true} if list is empty, otherwise {@code false}.
     */
    public boolean isEmpty(){
        return false;
    }

    /**
     * Returns the size of the linked list.
     *
     * @return the size of the list.
     */
    public int getSize(){
        return this.size;
    }

    /**
     * Get head of the list.
     *
     * @return head of the list.
     */
    public Node getHead(){
        return this.head;
    }

    /**
     * Calculate the count of the list manually
     *
     * @return count of the list
     */
    public int getCount(){

        int count = 0;

        Node cur = head;

        while (cur.getNext() != null){
            cur = cur.getNext();
            count++;
        }

        return count;
    }

    /**
     * Test if the value key is present in the list.
     *
     * @param key the value to be searched.
     * @return {@code true} if key is present in the list, otherwise {@code false}.
     */
    public boolean search(int key){
        Node cur  = head;

        while (cur != null){
            if (cur.getValue() == key){
                return true;
            }
            cur = cur.getNext();
        }

        return false;
    }

    /**
     * Return element at special index.
     *
     * @param index given index of element
     * @return element at special index.
     */
    public int getNth(int index){

        checkBounds(index, 0, size - 1);

        Node cur = head;

        for (int i = 0; i < index; i++) {
            cur = cur.getNext();
        }

        return cur.getValue();
    }

    @Override
    public String toString(){

        StringJoiner joiner = new StringJoiner("->");

        Node cur = head;

        while (cur != null){
            joiner.add(cur.getValue() + "");
            cur = cur.getNext();
        }
        return joiner.toString();
    }


    /** Driver Code */

    public static void main(String[] args) {

        SinglyLinkedList list = new SinglyLinkedList();

        assert list.isEmpty();

        assert list.getSize() == 0 && list.getCount() == 0;

        assert list.toString().equals("");


    }

}

/**
 * This class is the nodes of the SinglyLinked List. They consist of a value and
 * a pointer to the node after them.
 */
class Node {
    /** The value of the node */
    private int value;

    /** Point to the next node */
    private Node next;

    public Node(){}

    /**
     * Constructor
     *
     * @param value Value to be put in the node
     */
    public Node(int value){
        this(value,null);
    }

    /**
     * Constructor
     *
     * @param value Value to be put in the node
     * @param next  Reference to the next node
     */
    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
