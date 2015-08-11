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
public interface TreeIterable<V> {
    
    /**
     * visits root node, then each child node.
     * @return 
     */
    public Iterator<V> getPreorderIterator();
    
    public Iterator<V> getLevelOrderIterator();
}
