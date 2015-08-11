/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archival;

import java.util.Iterator;

/**
 *
 * @author swans_000
 */
public class LinkedList2D<V> {
    
    private Node firstNode;
    
    public LinkedList2D() {
        this(null);
    }
    
    public LinkedList2D(V val){
        firstNode = new Node(val);
    }
    
    public void add(V val){
        Node cur = firstNode;
        if (cur == null) {
            firstNode = new Node(val);
        }
        while (cur.hasNext()) {
            cur = cur.next();
        }
        cur.setNext(new Node(val));
    }
    
    private class Node<V> implements Iterator<Node> {
        
        private V value;
        private Node nextNode;
        
        public Node(V val) {
            value = val;
        }
        
        public V getValue() {
            return value;
        }
        
        public void setNext(Node<V> next){
            nextNode = next;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public Node next() {
            return nextNode;
        }
    }
    
}
