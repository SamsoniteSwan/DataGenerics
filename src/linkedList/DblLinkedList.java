/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedList;

import java.util.Iterator;

/**
 *
 * @author swans_000
 * @param <K> Object to act as a key (must be Comparable)
 * @param <S> Object to be the value
 */
public class DblLinkedList<K extends Comparable, S> implements DLinkedListInterface<K, S>, Iterable<K> {

    private EntryNode firstNode;
    private EntryNode lastNode;
    private int nodeCt;

    private EntryNode[] index;

    public DblLinkedList() {
        firstNode = null;
        lastNode = null;
        nodeCt = 0;
        index = new EntryNode[3];

    }
    


    private DblLinkedList(EntryNode start, EntryNode end) {
        firstNode = start;
        lastNode = end;
    }            
     
    /*
    * Fiind the index to start searching from
    */
    private EntryNode searchHead(K testKey) {
        // Default to firstNode for searching, in case no better index is found
        EntryNode result = firstNode; 
        for(EntryNode en : index) {
            if (en != null) {
                if (testKey.compareTo(en.getKey()) >= 0) {
                    result = en;
                }
                
            }
        }
        return result;
    }
    

    private EntryNode getNodeBetween(K find, EntryNode startNode, EntryNode endNode) {
    EntryNode result = null;
    if(startNode.getKey().compareTo(find) == 0) {
        //System.out.println(" nodes accessed --- " + ct);
        result = startNode;
    } else if (endNode.getKey().compareTo(find) == 0) {
        result = endNode;
    } else if (startNode.getKey().compareTo(find) < 0 && endNode.getKey().compareTo(find) > 0) {
        result = getNodeBetween(find, startNode.nextNode, endNode.prevNode);
    }
    return result;
    }
    
    
    private EntryNode getNodeBetween(K find, EntryNode startNode) {
        return getNodeBetween(find, startNode, lastNode);
    }

    @Override
    public void add(K key, S val) {
        System.out.print("Insert " + key.toString());
        EntryNode newNode = new EntryNode(key, val);

        // 1st value to be added. Insert as both first and last node.
        if (firstNode == null) {
            firstNode = newNode;
        }
        if (lastNode == null) {
            lastNode = newNode;
        } else {

            // smaller than 1st
            if (key.compareTo(firstNode.getKey()) < 0) {
                newNode.setNext(firstNode);
                firstNode.setPrevious(newNode);
                firstNode = newNode;

            } // larger than last
            else if (key.compareTo(lastNode.getKey()) > 0) {
                newNode.setPrevious(lastNode);
                lastNode.setNext(newNode);
                lastNode = newNode;
            } else {
                // Check if key already exists
                EntryNode found = getNodeBetween(key, searchHead(key));
                if (found != null) { // key already exists. replace value
                    found.setValue(val);
                } else{
                // no mid index
                if (index[1] == null) {
                    newNode.setPrevious(firstNode);
                    firstNode.setNext(newNode);
                    newNode.setNext(lastNode);
                    lastNode.setPrevious(newNode);
                    index[1] = newNode;
                } else if (key.compareTo(index[1].getKey()) < 0) {
                    // no index 1
                    if (index[0] == null) {
                        newNode.setPrevious(firstNode);
                        firstNode.setNext(newNode);
                        newNode.setNext(index[1]);
                        index[1].setPrevious(newNode);
                        index[0] = newNode;
                    } else {
                        System.out.print(" Index used - " + searchHead(key).getKey());
                        compareNodes(searchHead(key), newNode);
                    }

                } else if (key.compareTo(index[1].getKey()) > 0) {
                    // no index 3
                    if (index[2] == null) {
                        newNode.setPrevious(index[1]);
                        index[1].setNext(newNode);
                        newNode.setNext(lastNode);
                        lastNode.setPrevious(newNode);
                        index[2] = newNode;
                    } else {
                        System.out.print(" Index used - " + searchHead(key).getKey());
                        compareNodes(searchHead(key), newNode);
                    }
                }
            }

        }

        }
        nodeCt++;
        
        // Redefine indexes depending on the 
        if (nodeCt == 3) {
            index[1] = firstNode.getNext();
            index[1].setPrevious(firstNode);
            index[1].setNext(lastNode);
            firstNode.setNext(index[1]);
            lastNode.setPrevious(index[1]);
        } else if (nodeCt == 4) {
            index[0] = firstNode.getNext();
            index[1] = index[0].getNext();

        } else if (nodeCt == 5) {
            index[0] = firstNode.getNext();
            index[1] = index[0].getNext();
            index[2] = index[1].getNext();
        }
        
        
    }

    private void compareNodes(EntryNode IndexNode, EntryNode newNode) {
        int ct = 0;
        while (IndexNode.dataKey.compareTo(newNode.dataKey) < 0) {
            ct++;
            IndexNode = IndexNode.nextNode;
        }
        newNode.setNext(IndexNode);
        IndexNode.getPrevious().setNext(newNode);
        newNode.setPrevious(IndexNode.getPrevious());
        IndexNode.setPrevious(newNode);
        System.out.println(" nodes accessed - " + ct);

    }
    

    
    @Override
    public S getValue(K key) {
        S result = null;
        
        EntryNode foundNode = getNodeBetween(key, searchHead(key));
        if (foundNode != null) {
            result = (S)foundNode.getValue();
        }
        return result;
    } 
    
    /**
     * Removes a value from the list; 
     * returns null if value doesn't exist.
     * 
     * @param takeOut Key of entry to remove
     * @return value of object that was removed.
     */
        @Override
    public S remove(K takeOut) {
        S result = null;
        System.out.print("Removing " + takeOut.toString());
        EntryNode enResult = getNodeBetween(takeOut, searchHead(takeOut));
        if (enResult != null) {
            result = (S)removeNode(enResult).getValue();
            nodeCt--;
        }
        return result;
    }
    
    private EntryNode removeNode (EntryNode toRemove) {

        EntryNode next = toRemove.getNext();
        EntryNode prev = toRemove.getPrevious();
        if(next != null) {
            next.setPrevious(prev);
        }
        if(prev != null) {
            prev.setNext(next);
        }
        return toRemove;
    }
    
    public String printall() {
        String result = "List ";
        KeyIterator<K> it = new KeyIterator();
        while(it.hasNext()){
            K key = it.next();
            
            result += "(" + key.toString() + ", " + getValue(key).toString() + ") ";
        }
        return result;
        
    }    
    

    public void printindex() {
        int ct = 0;
        for (EntryNode en : index) {
            if (en != null){
                System.out.print("Index[" + ct + "]=" + en.getKey().toString() + "; ");
            }
            ct++;
        }
        System.out.println();
    }
    
    @Override
    public Iterator<K> keyIterator() {
        return new KeyIterator();
    }

    @Override
    public Iterator<K> iterator() {
        return new KeyIterator();
    }


    // PRIVATE NODE CLASS
    private final class EntryNode<K extends Comparable<? super K>, S> implements Iterator {

        private K dataKey;
        private S dataVal;

        protected EntryNode nextNode;
        protected EntryNode prevNode;

        public EntryNode(K key, S value) {
            dataKey = key;
            dataVal = value;
        }

        public void setNext(EntryNode nextNode) {
            this.nextNode = nextNode;
        }

        public void setPrevious(EntryNode previous) {
            prevNode = previous;
        }

        public EntryNode getNext() {
            return nextNode;
        }

        public EntryNode getPrevious() {
            return prevNode;
        }

        public K getKey() {
            return dataKey;
        }

        public S getValue() {
            return dataVal;
        }
        
        public void setValue(S value) {
            dataVal = value;
        }

        @Override
        public String toString() {
            return dataKey.toString() + ": " + dataVal.toString();
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public EntryNode next() {
            return nextNode;
        }

    }

    // KEY ITERATOR
    private class KeyIterator<K> implements Iterator<K> {

        private EntryNode nextNode;


        private KeyIterator() {
            nextNode = firstNode;;
        }

        private KeyIterator(EntryNode startPoint) {
            nextNode = startPoint.getNext();
        }
        
        public void restart() {
            nextNode = firstNode;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public K next() {
            EntryNode result = null;
            if (hasNext()) {
                result = nextNode;
                nextNode = nextNode.getNext();
            } else {
                throw new UnsupportedOperationException("No further to go!");
            }

            return (K) result.getKey();
        }

    }

}
