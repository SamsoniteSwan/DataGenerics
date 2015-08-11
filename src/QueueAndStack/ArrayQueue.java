/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueAndStack;

import java.util.Arrays;

/**
 *
 * @author Jeremy Swanson
 */
public final class ArrayQueue<Q> implements Queueable<Q> {
    
    private Q[] mQueue;

    private int mCount;
    private int mCurrentMax;
    private static final int DEFAULT_SIZE = 5;
    private int mFirstIndex;
    private int mLastIndex;   
    
    private ArrayStack<Q> dequeuedItems;
    
    public ArrayQueue() {
        this(DEFAULT_SIZE);
    }
    
    public ArrayQueue(int startingSize) {
        
        Q[] temp = (Q[])new Object[startingSize + 1];
        mQueue = temp;
        mFirstIndex = 0;
        mLastIndex = 0;
        mCount = 0;
        mCurrentMax = startingSize;
    }

    @Override 
    public void queue(Q newEntry) {
        
        if (isEnd()) {

            // using recursive method
            //moveDown(0);
            //mFirstIndex = 0;
        //}
        //if (isFull()) {
            doubleMaxSize();
                   
        }
        /*
        if (isEnd()) {
            stackReset();
        }*/
        
        // increment LastIndex; if full, index becomes 0:
        //mLastIndex = (mLastIndex + 1) % mQueue.length; 
        mQueue[mLastIndex++] = newEntry;
        mCount++;
            //throw new EmptyStackException();
    }

    @Override
    public Q dequeue() {
        
        Q first;

        if (!isEmpty()) {
            first = mQueue[mFirstIndex];
            mQueue[mFirstIndex] = null;
            //mFirstIndex = (mFirstIndex + 1) % mQueue.length;
            mFirstIndex++;
            mCount--;
        } else {
            first = null;
            
        }
        return first;
    }

    @Override
    public boolean isEmpty() {
        return mCount == 0;
    }

    @Override
    public boolean isFull() {
        return mCount == mQueue.length;
    }

    @Override
    public Q peek(int location) {
        return mQueue[location];
    }
    
    private void doubleMaxSize() {
        
        mCurrentMax = mCurrentMax * 2;
        mQueue = Arrays.copyOf(mQueue, mCurrentMax);
        
    }
    
    private boolean isEnd() {
        return mLastIndex > mQueue.length - 2;
    }
    
    // test recursively pushing back values.
    // could be useful if queue reaches end, but still space up front.
    private void moveDown(int location) {

        if (mQueue[location] == null && location < mQueue.length -1) {
            mQueue[location] = mQueue[location + 1];
            
            mQueue[location + 1] = null;
            location ++;
            
            
            
            if (location == mQueue.length -1) { // once reaching the end...
                mLastIndex--; // decrement last item position
                if (mQueue[0] == null){ // if there's still empty space at start...
                    location = 0; // reset location to start of array.
                }
                //moveDown(0);
            }
            // RECURSIVE CALL
            moveDown(location);
            
        }
    }
    
    private ArrayStack<Q> toStack() {
        
        ArrayStack<Q> tempStack = new ArrayStack<>();
        
        while (!isEmpty()) {
            tempStack.push(this.dequeue());
        }       
        return tempStack;
    }
    
    // DOESN'T WORK
    private void stackReset() {
        ArrayStack<Q> tempStack = new ArrayStack<>();
        
        while (!isEmpty()) {
            tempStack.push(this.dequeue());
        }
        
        /*if (mCount == mCurrentMax){
            doubleMaxSize();
            mFirstIndex = 0;
            mLastIndex = 0;
            mCount = 0;
        }*/
        //doubleMaxSize();
        while (!tempStack.isEmpty()){ 
            System.out.println("count=" + mCount + "; max=" + mCurrentMax);
            if (mCount == mCurrentMax) {
                doubleMaxSize();
            }
            this.queue(tempStack.pop());
        }
        System.out.println("count=" + mCount + "; max=" + mCurrentMax);
        
    }    
}
