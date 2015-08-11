/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueAndStack;

import java.util.Arrays;

/**
 *
 * @author swans_000
 */
public class ArrayStack<S> implements Stackable<S> {
    
    private S[] mStack;
    private int mCount;
    private int mCurrentMax;
    private static final int DEFAULT_SIZE = 5;

    
    public ArrayStack() {
        this(DEFAULT_SIZE);
    }
    
    public ArrayStack(int startingSize) {
        
        S[] temp = (S[])new Object[startingSize];
        mStack = temp;
        mCount = 0;
        mCurrentMax = startingSize;
    }

    @Override
    public void push(S newEntry) {
        
        if (isFull()) {
            doubleMaxSize();
        }       
        mStack[mCount + 1] = newEntry;
        mCount++;
            //throw new EmptyStackException();   
    }

    @Override
    public S pop() {
        
        S top;        
        if (!isEmpty()) {
            top = mStack[mCount];
            mStack[mCount] = null;
            mCount--;
            //return top;
        } else {
            top = null;
        }
        return top;
    }

    @Override
    public boolean isEmpty() {       
        return mCount < 1;
    }

    @Override
    public boolean isFull() {
        return mCount == mStack.length-1;
    }

    @Override
    public S peek(int location) {
        return mStack[location];
    }
    
    private void doubleMaxSize() {        
        mCurrentMax = mCurrentMax * 2;
        mStack = Arrays.copyOf(mStack, mCurrentMax);       
    }
    
    private ArrayQueue<S> toQueue() {
        
        ArrayQueue<S> tempQueue = new ArrayQueue<>();
        
        while (!isEmpty()) {
            tempQueue.queue(this.pop());
        }       
        return tempQueue;
    }   
}
