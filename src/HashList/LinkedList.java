/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashList;

import java.util.Iterator;

/**
 *
 * @author swans_000
 */
public class LinkedList<S extends Comparable<? super S>, V extends Comparable> implements Iterable<V>{
    
    private Node firstNode;
    
        
    private Node curNode;

    /*
    @Override
    public boolean hasNext() {
        return curNode.hasNext();
    }

    @Override
    public Object next() {
        curNode = curNode.next();
        return curNode;
    }
    */

    @Override
    public Iterator<V> iterator() {
        return new ValIterator();
    }
    

    // KEY ITERATOR
    private class ValIterator<V> implements Iterator<V> {

        private Node nextNode;


        private ValIterator() {
            nextNode = firstNode;
        }

        private ValIterator(Node startPoint) {
            nextNode = startPoint.next();
        }
        
        public void restart() {
            nextNode = firstNode;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public V next() {
            Node result = null;
            if (hasNext()) {
                result = nextNode;
                nextNode = nextNode.next();
            } else {
                throw new UnsupportedOperationException("No further to go!");
            }

            return (V) result.getValue();
        }

    }    
    // Node Class
    //private final class Node<S extends Comparable, V extends Comparable> implements Iterator {
    private final class Node<S extends Comparable, V extends Comparable> implements Comparable<Node>, Iterator {

        private S data1;
        private V data2;
        
        protected Node nextNode;
        
        public Node(S key, V value){
            data1 = key;
            data2 = value;
        }
        
        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public Node next() {
            return nextNode;
        }
        
        public void setNext(Node nextNode) {
            this.nextNode = nextNode;
        }
        
        public V getValue(){
            return data2;
        }
        
        public S getKey() {
            return data1;
        }       
        
        public boolean equals(Node test){
            boolean result = false;
            
            if (data1.compareTo(test.getKey())== 0){
                if (data2.compareTo(test.getValue())==0) {
                    result = true;
                }
            }
            return result;
        }

        @Override
        public int compareTo(Node o) {
            int result = 0;
            result += data1.compareTo(o.getKey()) * 100;
            result += data2.compareTo(o.getValue());
  
            return result;
        }
    }
    
    // CONSTRUCTORS
    public LinkedList(S key, V val){
        firstNode = new Node(key, val);
        curNode = firstNode;
    }
    public LinkedList(){
        firstNode = null;
        curNode = null;
    }
    
    private void add(Node newNode){
        if (firstNode == null){
            firstNode = newNode;
            curNode = firstNode;
        } else {
            if (newNode.compareTo(firstNode) < 0){
                newNode.setNext(firstNode);
                firstNode = newNode;
            } else {
                Node beforeNode = firstNode;
                Node afterNode = firstNode.nextNode;
                while(beforeNode.hasNext() && !newNode.equals(beforeNode)/*newNode.compareTo(beforeNode) > 0*/){
                    
                    beforeNode = beforeNode.nextNode;
                    afterNode = afterNode.nextNode;
                }
                if(!newNode.equals(beforeNode)){//newNode.compareTo(beforeNode) != 0){
                    beforeNode.setNext(newNode);
                    newNode.setNext(afterNode);
                }
                    /*else if (newNode.compareTo(afterNode) != 0 ){
                    afterNode.setNext(newNode);
                }*/
            }
        }        
    }
    
    public void add(S key, V val){
        Node newNode = new Node(key, val);
        
        add(newNode);
    }
    
    public void printall(){
        //Node node = firstNode;
        if (firstNode == null){
            System.out.print("EMPTY");
        } else {
            Node node = firstNode;
        while(node != null){
            System.out.print(node.getKey().toString() + "(" + node.getValue().toString() + "); ");
            node = node.nextNode;
        }}
    }
    
    public LinkedList union(LinkedList other){
        LinkedList result = new LinkedList();
        Node myNode = firstNode;
        
        while(myNode != null){
            Node otherN = other.firstNode;
            while(otherN != null){
                if (myNode.equals(otherN)){
                    result.add(otherN, otherN);
                }
                otherN = otherN.nextNode;
            }
            
            myNode = myNode.nextNode;
        }
        
        return result;
    }
    
    public LinkedList listOfKey(S key){
        //UNTESTED
        LinkedList result = new LinkedList();
        
        Node testNode = firstNode;
        while (testNode != null) {
            if (testNode.getKey().compareTo(key) == 0){
                result.add(testNode);
            }
            testNode = testNode.next();
        }
        return result;
    }
    
}
