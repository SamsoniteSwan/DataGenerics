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
public class CircularArrayQueue<Q> implements Queueable<Q> {
    
        private Q[] mQueue;

    private static final int DEFAULT_SIZE = 5;
    private int mFirstIndex;
    private int mLastIndex;
    
    private boolean isInitialized = false;
    
    
    
    public CircularArrayQueue() {
        this(DEFAULT_SIZE);
    }
    
    public CircularArrayQueue(int startingSize) {
        
        Q[] temp = (Q[])new Object[startingSize + 1];
        mQueue = temp;
        mFirstIndex = 0;
        mLastIndex = 0;
        
        isInitialized = true;
    }

    @Override
    public void queue(Q newEntry) {
        
        checkInitialization();
        ensureCapacity();
        mLastIndex = (mLastIndex + 1) % mQueue.length;
        mQueue[mLastIndex] = newEntry;
        
    }

    @Override
    public boolean isEmpty() {
        return mFirstIndex == ((mLastIndex + 1) % mQueue.length);
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public Q dequeue() {
        checkInitialization();
        
        Q front = null;
        if (!isEmpty()) {
            front = mQueue[mFirstIndex];
            mQueue[mFirstIndex] = null;
            mFirstIndex = (mFirstIndex + 1) % mQueue.length;
            
        }
        return front;
    }

    @Override
    public Q peek(int location) {
        return mQueue[location];
    }
    
    private void ensureCapacity() {
        
        if (mFirstIndex == ((mLastIndex + 2) % mQueue.length)){
            Q[] oldQueue = mQueue;
            int oldSize = oldQueue.length;
            int newSize = 2 * oldSize;
            
            Q[] tempQueue = (Q[]) new Object[newSize];
            mQueue = tempQueue;
            
            for (int i = 0; i < oldSize - 1; i++) {
                mQueue[i] = oldQueue[mFirstIndex];
                mFirstIndex = (mFirstIndex + 1) % oldSize;
            }
            
            mFirstIndex = 0;
            mLastIndex = oldSize - 2;
        }
            
    }
    
    private void checkInitialization() {
        if (!isInitialized)
            throw new SecurityException("Not Initialized.");
    }
        
}
