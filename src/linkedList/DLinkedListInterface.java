/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedList;

import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author swans_000
 */
public interface DLinkedListInterface<K, I>{
    
    public void add(K key, I item);
    
    public I getValue(K key);
    
    public I remove(K key);
    
    public Iterator<K> keyIterator();
        
}
