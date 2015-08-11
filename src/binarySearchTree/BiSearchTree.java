/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarySearchTree;

import java.util.Iterator;

/**
 *
 * @author swans_000
 */
public class BiSearchTree<V extends Comparable<? super V>> 
        extends BiTree<V> 
        implements BiSearchTreeInterface<V> {
       
    public BiSearchTree() {
        super();
    }
    
    public BiSearchTree(V rootEntry){
        super();
        super.setRootNode(new BiNode<>(rootEntry));
    }

    @Override
    public boolean contains(V entry) {
        return getNode(entry) != null;
    }

    @Override
    public V getEntry(V entry) {
        return findNode(super.getRootNode(), entry).getValue();
    }
  
    /* WORKS, BUT NOW UNNECESSARY
    private V findEntry(BiNode<V> root, V find) {
        
        V result = null;
        
        if (root != null) {
            V value = root.getValue();
            int dif = value.compareTo(find);
            
            if (dif == 0) {
                result = value;
            } else if (dif > 0) {
                result = findEntry(root.getLeftNode(), find);
            } else if (dif < 0) {
                result = findEntry(root.getRightNode(), find);
            }
        }
        
        return result;
    }
    */

    private BiNode<V> getNode(V entry) {
        return findNode(super.getRootNode(), entry);
    }
    
    private BiNode<V> findNode(BiNode<V> root, V find){
        
        BiNode result = null;
        // only return node if it exists and has a count > 0
        if (root != null && root.getCount() > 0) {
            V value = root.getValue();
            int dif = value.compareTo(find);
            if (dif == 0) {
                result = root;
            } else if (dif > 0) {
                result = findNode(root.getLeftNode(), find);
            } else if (dif < 0) {
                result = findNode(root.getRightNode(), find);
            }
        }        
        return result;
    }   
    
    public boolean is1ParentTo2(V parent, V child){
        boolean result = false;
        BiNode<V> parentNode = getNode(parent);
        
        if (parentNode != null){
            result = parentNode.getKidHash().containsKey(child);
        }
        return result;
    }    

    @Override
    public V add(V newEntry) {
        
        V result = null;        
        if (isEmpty()) {
            setRootNode(new BiNode<>(newEntry));
        } else {
            result = addEntry(getRootNode(), newEntry);
        }        
        return result;
    }
    
    private V addEntry(BiNode<V> root, V newEntry){

        V result = null;        
        int dif = newEntry.compareTo(root.getValue());       
        root.addToKidHash(newEntry);
        
        // if found, increment count
        if (dif == 0) {
            root.increment();
            result = root.getValue();
        } else if (dif < 0) {
            if (root.hasLeftNode()) {
                result = addEntry(root.getLeftNode(), newEntry);
            } else {
                root.setLeftNode(new BiNode<>(newEntry));
            }
        } else {
            if (root.hasRightNode()){
                result = addEntry(root.getRightNode(), newEntry);
            } else {
                root.setRightNode(new BiNode<>(newEntry));
            }
        }
        return result;
    }

    @Override
    public V remove(V entry) {        
        return removeEntry(getRootNode(), entry);
    }
    
    private V removeEntry(BiNode<V> root, V toRemove) {
        
        V result = null;        
        root.removeFromKidHash(toRemove);       
        int dif = toRemove.compareTo(root.getValue());
        
        if (dif == 0) {
            if (root.decrement())
                result = root.getValue();
        } else if (dif < 0) {
            if (root.hasLeftNode()) {
                result = removeEntry(root.getLeftNode(), toRemove);
            }
        } else if (dif > 0) {
            if (root.hasRightNode()) {
                result = removeEntry(root.getRightNode(), toRemove);
            }
        }       
        return result;
    }

    @Override
    public Iterator getOrderIterator() {
        return super.getLevelOrderIterator();
    }    
}
