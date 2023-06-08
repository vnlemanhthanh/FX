/*******************************************************************************
 * Copyright (c) 2022.
 ******************************************************************************/

package linear;

public class LinkedList<E> {
    private int n;
    private Node<E> first;

    private static class Node<T> {  
        private T item;
        private Node<T> next;


        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }


}
