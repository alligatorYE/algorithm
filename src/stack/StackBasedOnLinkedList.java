package stack;

import linkedlist.LinkedList.Node;

import java.security.PublicKey;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @Description
 * @Version v1.0
 * @Author yange1
 * @Time 2021/3/23 11:36
 */
public class StackBasedOnLinkedList <T>{

    private Node<T> top;

    public void pushStack(T data){

        Node current = new Node(data,null);

        if (top != null){
            current.setNext(top);
        }
        top = current;
    }

    public T popStack(){
        if (top == null){
            return null;
        }
        T element = top.getElement();
        top = top.getNext();
        return element;
    }

    @Override
    public String toString(){

        Node current = top;

        CharSequence separator = "->";
        StringJoiner stringJoiner = new StringJoiner(separator);

        while (current != null){
            stringJoiner.add(current.getElement() + "");
            current = current.getNext();
        }

        return stringJoiner.toString();
    }

    public class  Node<T>{

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

        StackBasedOnLinkedList list = new StackBasedOnLinkedList();

        for (int i = 0; i < 10; i++) {
            list.pushStack(i + 100);
        }
        System.out.println("The stack is displayed as:");
        System.out.println(list.toString());

        Scanner scanner = new Scanner(System.in);

        while (true){

            System.out.println("\nPlease enter a number, enter number \"0\" to exit! " +
                    "\nIn addition, entering a negative number will perform a pop operation, " +
                    "\nand entering a positive number will perform a push operation! ");

            int input = scanner.nextInt();

            if (input == 0){
                break;
            }else if (input < 0){
                list.popStack();
            }else if (input > 0){
                list.pushStack(input);
            }
            System.out.println("The stack is now displayed as:");
            System.out.println(list.toString());
        }
    }
}
