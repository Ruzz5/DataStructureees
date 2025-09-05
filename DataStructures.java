package Data;

import java.util.Scanner;


class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class DataStructures{
    static Scanner sc = new Scanner(System.in);

    
    static class Stack {
        int[] arr = new int[10];
        int top = -1;

        void push(int x) {
            arr[++top] = x;
            System.out.println("Pushed " + x + " into stack.");
        }

        void pop() {
            if (top >= 0)
                System.out.println("Popped: " + arr[top--]);
            else
                System.out.println("Stack is empty.");
        }

        void display() {
            if (top == -1) {
                System.out.println("Stack is empty.");
                return;
            }
            System.out.print("Stack contents: ");
            for (int i = top; i >= 0; i--)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    static class Queue {
        int[] arr = new int[10];
        int front = 0, rear = -1;

        void enqueue(int x) {
            arr[++rear] = x;
            System.out.println("Enqueued " + x + " into queue.");
        }

        void dequeue() {
            if (front <= rear)
                System.out.println("Dequeued: " + arr[front++]);
            else
                System.out.println("Queue is empty.");
        }

        void display() {
            if (front > rear) {
                System.out.println("Queue is empty.");
                return;
            }
            System.out.print("Queue contents: ");
            for (int i = front; i <= rear; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }

    
    static class LinkedList {
        Node head;

        void insertEnd(int x) {
            Node n = new Node(x);
            if (head == null) {
                head = n;
            } else {
                Node t = head;
                while (t.next != null)
                    t = t.next;
                t.next = n;
            }
            System.out.println("Inserted " + x + " at end.");
        }

        void deleteBegin() {
            if (head != null) {
                System.out.println("Deleted: " + head.data);
                head = head.next;
            } else {
                System.out.println("List is empty.");
            }
        }

        void display() {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
            System.out.print("Linked list contents: ");
            for (Node t = head; t != null; t = t.next)
                System.out.print(t.data + " ");
            System.out.println();
        }
    }

   
    static class CircularList {
        Node tail;

        void insert(int x) {
            Node n = new Node(x);
            if (tail == null) {
                tail = n;
                n.next = n;
            } else {
                n.next = tail.next;
                tail.next = n;
                tail = n;
            }
            System.out.println("Inserted " + x + " into circular list.");
        }

        void delete(int x) {
            if (tail == null) {
                System.out.println("List is empty.");
                return;
            }
            Node cur = tail.next, prev = tail;
            do {
                if (cur.data == x) {
                    prev.next = cur.next;
                    if (cur == tail) tail = prev;
                    if (cur == prev) tail = null; // only 1 node
                    System.out.println("Deleted: " + x);
                    return;
                }
                prev = cur;
                cur = cur.next;
            } while (cur != tail.next);
            System.out.println("Value not found.");
        }

        void display() {
            if (tail == null) {
                System.out.println("Circular list is empty.");
                return;
            }
            System.out.print("Circular list contents: ");
            Node t = tail.next;
            do {
                System.out.print(t.data + " ");
                t = t.next;
            } while (t != tail.next);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Stack st = new Stack();
        Queue q = new Queue();
        LinkedList ll = new LinkedList();
        CircularList cl = new CircularList();

        while (true) {
            System.out.println("\nChoose Data Structure:");
            System.out.println("1. Stack\n2. Queue \n 3. Linked List \n4. Circular Linked List \n5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("\n Stack Operations");
                    System.out.println("1. Push\n2. Pop\n3. Display");
                    System.out.print("Enter choice: ");
                    int s = sc.nextInt();
                    if (s == 1) {
                        System.out.print("Enter value to push: ");
                        st.push(sc.nextInt());
                    } else if (s == 2) st.pop();
                    else st.display();
                    break;

                case 2:
                    System.out.println("\nQueue Operations");
                    System.out.println("1. Enqueue\n2. Dequeue\n3. Display");
                    System.out.print("Enter choice: ");
                    int qch = sc.nextInt();
                    if (qch == 1) {
                        System.out.print("Enter value to enqueue: ");
                        q.enqueue(sc.nextInt());
                    } else if (qch == 2) q.dequeue();
                    else q.display();
                    break;

                case 3:
                    System.out.println("\n Linked List Operations");
                    System.out.println("1. Insert at End\n2. Delete at Beginning\n3. Display");
                    System.out.print("Enter choice: ");
                    int l = sc.nextInt();
                    if (l == 1) {
                        System.out.print("Enter value to insert: ");
                        ll.insertEnd(sc.nextInt());
                    } else if (l == 2) ll.deleteBegin();
                    else ll.display();
                    break;

                case 4:
                    System.out.println("\nCircular Linked List Operations");
                    System.out.println("1. Insert\n2. Delete\n3. Display");
                    System.out.print("Enter choice: ");
                    int c = sc.nextInt();
                    if (c == 1) {
                        System.out.print("Enter value to insert: ");
                        cl.insert(sc.nextInt());
                    } else if (c == 2) {
                        System.out.print("Enter value to delete: ");
                        cl.delete(sc.nextInt());
                    } else cl.display();
                    break;

                case 5:
                    return;
            }
        }
    }
}
