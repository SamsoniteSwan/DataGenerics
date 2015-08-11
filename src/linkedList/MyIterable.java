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
public interface MyIterable<S> {
    
    /**
     * get the next element in the structure
     * @return next element
     */
    public S next();
    
    /**
     * check if there's a trailing element
     * @return true if there is a following element
     */
    public boolean hasNext();
    
    /**
     * remove the current element from the structure
     */
    public S remove();
    
}
