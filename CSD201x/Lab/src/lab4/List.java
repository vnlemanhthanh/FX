/*******************************************************************************
 * Copyright (c) 2022.
 ******************************************************************************/

package lab4;

import java.util.Arrays;

public class List {
    public Node head, tail;

    public List() {}

    private static class Node{
        private int info;
        private Node nextNode;

        public Node(int info, Node nextNode) {
            this.info = info;
            this.nextNode = nextNode;
        }

        public Node(int info) {
            this.info = info;
        }
    }

    public void addHead(int item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.nextNode = head;
        head = newNode;
    }

    public void addTail(int item) {
        Node newNode = new Node(item);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.nextNode = newNode;
        tail = newNode;
    }

    public String toString() {
        String result = "";
        Node cur = head;
        while (cur != null) {
            result += " " + cur.info;
            cur = cur.nextNode;
        }
        return result;
    }

    // Test
    public static void main(String[] args) {
        List list = new List();
        list.addHead(1);
        list.addHead(2);
        list.addHead(5);
        list.addHead(7);
        list.addTail(0);
        System.out.println(list);
    }
}
