/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarySearchTree;

import java.util.Iterator;

public interface BiSearchTreeInterface<V extends Comparable<? super V>> 
        extends BiTreeInterface<V> {
    
    public boolean contains(V entry);
    
    public V getEntry(V entry);
    
    public V add(V newEntry);
    
    public V remove(V entry);
    
    public Iterator<V> getOrderIterator();
}
