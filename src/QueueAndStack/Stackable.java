/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueAndStack;

/**
 *
 * @author Jeremy Swanson
 */
public interface Stackable<S> {
    
    /**
     * Adds a new item to the top of the stack
     * @param newEntry new item
     */
    public void push(S newEntry);
    
    /**
     * Removes the last item placed
     * @return Object of type
     */
    public S pop();
    
    /**
     * Find out if the stack has any entries
     * @return true if nothing
     */
    public boolean isEmpty();
    
    public boolean isFull();
        
    public S peek(int location);
      
}
