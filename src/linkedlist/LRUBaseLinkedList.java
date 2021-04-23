package linkedlist;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @Description  基于单链表的LRU算法
 * @Version v1.0
 * @Author yange1
 * @Date 2021/2/23
 * @Time 15:34
 */
public class LRUBaseLinkedList <T>{

    private final static Integer DEFAULT_CAPACITY = 10;

    private Integer capacity;

    private Integer length;

    private Node<T> head;

    public LRUBaseLinkedList(Integer capacity){
        this.head = new Node<>();
        this.capacity = capacity;
        this.length = 0;
    }

    public LRUBaseLinkedList(){
        this.head = new Node<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    private void addNode(T element){
        Node preNode = findPreNode(element);

        if (preNode != null){
            deleteNode(preNode);
        }else if (this.length >= this.capacity){
            deleteNodeAtTail();
        }
        insertNodeAtHead(element);
    }

    private void deleteNode(Node preNode){

        Node current = preNode.getNext();

        preNode.setNext(current.next);

        current = null;

        this.length--;
    }

    private void deleteNodeAtTail(){
        Node current = head;

        while (current.getNext().getNext() != null){
            current = current.getNext();
        }

        Node tempNode = current.getNext();

        current.setNext(null);

        tempNode = null;

        this.length--;
    }

    private Node findPreNode(T element){

        Node preNode = head;

        while (preNode.getNext() != null){
            if (element.equals(preNode.getNext().getElement())){
                return preNode;
            }
            preNode = preNode.getNext();
        }
        return null;
    }

    private void insertNodeAtHead(T element){
        Node next = head.getNext();

        head.setNext(new Node(element,next));

        this.length++;
    }

    @Override
    public String toString(){

        Node current = head.getNext();

        CharSequence separator = "->";
        StringJoiner stringJoiner = new StringJoiner(separator);

        while (current != null){
            stringJoiner.add(current.getElement() + "");
            current = current.getNext();
        }

        return stringJoiner.toString();
    }


    public class Node<T>{

        private T element;

        private Node next;

        public Node(T element, Node next){

            this.element = element;

            this.next = next;
        }

        public Node(T element){
            this(element,null);
        }

        public Node(){
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {

        LRUBaseLinkedList list = new LRUBaseLinkedList();

        for (int i = 1; i < 11; i++) {
            list.addNode(100 + i);
        }

        System.out.println(list.toString());

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入一个整数，-1 退出");
            Integer input = scanner.nextInt();

            if (input == -1){
                break;
            }

            list.addNode(input);

            System.out.println(list.toString());
        }
    }
}
