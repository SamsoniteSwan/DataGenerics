/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SkipList;

import java.util.Iterator;

/**
 *
 * @author swans_000
 */
public class SkipNode <S extends Comparable> implements Iterator<SkipNode> {
        
        private S value;
        private SkipNode nextNode;
        private SkipNode upNode;
        private boolean isEven = false;
        
        public SkipNode(S string) {
            this(string, false);
            
        } 
        public SkipNode(S newval, boolean even){
            value = newval;
            isEven = even;
        }
        
        public S getValue() {
            return value;
        }
        
        public boolean getEven() {
            return isEven;
        }
        public void reverseEven() {
            isEven = !isEven;
        }
        
        public void setNext(SkipNode next) {
            nextNode = next;
            next.isEven = !this.isEven;
            
        }
        
        public void setUp(SkipNode up) {
            upNode = up;
        }
        
        public SkipNode getUp() {
            return upNode;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public SkipNode next() {
            return nextNode;
        }
        
        public SkipNode nextToCheck(S test) {
            SkipNode result = null;
            int tst = test.compareTo(this.getValue());
            System.out.print("{accessed '" + this.getValue() + "'}");
            if(tst == 0){
                result = this;
            } else if (tst > 0){
                if (hasNext()) {
                    if (test.compareTo(next().getValue()) >= 0){
                        result = next().nextToCheck(test);
                    } else {
                        if (upNode != null && upNode.hasNext()){
                            result = upNode.nextToCheck(test);
                        }
                    }
                } else {
                        if (upNode != null && upNode.hasNext()) {
                            result = upNode.nextToCheck(test);
                        }
                }
            }
            return result;
        }
        /*
        public SkipNode hopto(String test) {
            SkipNode result = null;
            int tst = test.compareTo(this.getValue());
            
            System.out.print("{accessed '" + this.getValue() + "'}");
            if (tst == 0){
                result = this;
            } else if (tst > 0){
                if (hasNext()){
                    result = nextNode.hopto(test);      // RECURSIVE CALL
                } else {
                    if (upNode != null){
                        result = upNode.hopto(test);    // RECURSIVE CALL
                    }
                }
            }
           return result;
        }*/
}
