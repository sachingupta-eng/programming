package com.example.myapplication;

import java.util.*;


public class SingleLinkedLIst {
    private Node head;

    public static void main(String[] args) {
        SingleLinkedLIst s1 = new SingleLinkedLIst();
        s1.showLinkedListMenu();

    }

    private void showLinkedListMenu() {
        boolean isRun = true;
        while (isRun) {
            System.out.println();
            System.out.println("Single Linked list Operation Menu");
            System.out.println("Press 1 for add at last");
            System.out.println("Press 2 for add at Beginning");
            System.out.println("Press 3 for remove first");
            System.out.println("Press 4 for remove last");
            System.out.println("Press 5 for add at position");
            System.out.println("Press 6 for remove at position");
            System.out.println("Press 7 for display");
            System.out.println("Press 8 for Exit from program");
            System.out.println("Press 9 for reverse linked list");

            Scanner sc = new Scanner(System.in);
            int choose = sc.nextInt();
            switch (choose) {
                case 1: {
                    System.out.println("Please enter number to store");
                    int data = sc.nextInt();
                    addAtLast(new Node(data));
                    break;
                }
                case 2: {
                    System.out.println("Please enter number to store");
                    int data = sc.nextInt();
                    addAtBeginning(new Node(data));
                    break;
                }
                case 3: {
                    removeFirst();
                    break;
                }
                case 4: {
                    removeLast();
                    break;
                }
                case 5: {
                    System.out.println("Please enter number to store");
                    int data = sc.nextInt();
                    System.out.println("Please enter position");
                    int i = sc.nextInt();
                    addAtPosition(new Node(data), i);
                    break;
                }
                case 6: {
                    System.out.println("Please enter position where item to be removed");
                    int i = sc.nextInt();
                    removeAtPosition(i);
                    break;
                }
                case 7: {
                    display();
                    break;
                }
                case 8: {
                    isRun = false;
                    break;
                }
                case 9: {
                    int i=0;
                    // This is test data for reverse list by group. U can remove if needed
                    while (i<15){
                        addAtLast(new Node(i));
                        i++;
                    }
                    display();
                    System.out.println("Please enter noe to reverse linked list");
                    int k = sc.nextInt();
                    head=reverse(head,k);
                    break;
                }

                default: {
                    System.out.println("Invalid choice");
                    break;
                }
            }
        }
    }

    private void addAtLast(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;


        }
    }

    private void addAtBeginning(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;

        }
    }

    private void removeFirst() {
        if (head == null) {
            System.out.println("no elements");
        } else {
            head = head.next;
        }

    }

    private void removeLast() {
        if (head == null) {
            System.out.println("no elements");
        } else {
            Node temp1 = head;
            Node temp2 = head.next;
            while (temp2.next != null) {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            temp1.next = null;

        }
    }

    private void addAtPosition(Node node, int i) {
        int count = 0;
        Node prev = head;
        Node next = head.next;
        while (count != i && next.next != null) {
            prev = prev.next;
            next = next.next;
            count++;
        }
        if(count == i) {
            prev.next = node;
            node.next = next;
        } else {
            System.out.println(i +" is not any position in this list.Please try position under "+count);
        }


    }

    private void removeAtPosition(int i) {
        int count = 1;
        Node prev = head;
        Node next = head.next;

        while (count != i && next.next != null) {
            prev = prev.next;
            next = next.next;
            count++;
        }
        if (count == i) {
            prev.next = next.next;
            next.next = null;

        }
        else
        {
            System.out.println(i +" is not any position in this list.Please try position under "+count);
        }
    }

    /**
     * Use to reverse group of list
     * @param node
     * @param k group size
     * @return updated head
     */
        private Node reverse(Node node,int k) {
            int count = 0;
            Node prev = null;
            Node curr = node;
            Node next = null;
            while (count < k && curr!= null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if (next != null)
                node.next = reverse(next, k);
                return prev;
        }

    private void display() {
        if (head == null) {
            System.out.println("no elements found");
        } else {
            Node temp = head;
            while (temp.next != null) {
                System.out.print(temp.data + " ->");
                temp = temp.next;
            }
            System.out.print(temp.data);
            System.out.println();
        }

    }

}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
