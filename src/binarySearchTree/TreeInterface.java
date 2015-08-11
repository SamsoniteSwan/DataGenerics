/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarySearchTree;

/**
 *
 * @author swans_000
 */
public interface TreeInterface<V> {
    
    public V getRootValue();
    public int getHeight();
    public int getNodeCount();
    public boolean isEmpty();
    public void clear();
    
}
