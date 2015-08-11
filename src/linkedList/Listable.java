/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedList;

/**
 *
 * @author swans_000
 */
public interface Listable<S> {
    
    /**
     * get the number of items in a list
     * @return size of list
     */
    public int size();
    
    /**
     * check if there are any values in the list
     * @return true if empty
     */
    public boolean isEmpty();
    
    /**
     * add an item to the list
     * @param element to be added
     */
    public void add(S element);
    
    /**
     * remove an element and return it
     * @return the element removed
     */
    public S remove();
    
    /**
     * remove a specific element
     * @param element to remove
     * @return true if successful
     */
    public boolean remove(S element);
    
}
