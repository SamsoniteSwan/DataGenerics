/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueAndStack;

/**
 *
 * @author swans_000
 * @param <Q>
 */
public interface Queueable<Q> {
    
        /**
     * Adds a new item to the end of the queue
     * @param newEntry new item
     */
    public void queue(Q newEntry);
    
    /**
     * Removes an item from the front of the queue
     * @return Object of type
     */
    public Q dequeue();
    
    /**
     * Find out if the queue has any entries
     * @return true if nothing
     */
    public boolean isEmpty();
    
    public boolean isFull();
        
    public Q peek(int location);
    
}
