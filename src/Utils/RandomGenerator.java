/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Random;

/**
 *
 * @author swans_000
 */
public class RandomGenerator {
    
    private static final Random random = new Random();
    
    public static String randStringVarSize(int min, int max){
        int size = randInt(min, max);
        return randStringFixedSize(size);
    }
    /**
     * 
     * @param size length of result
     * @return String of random letters
     */
    public static String randStringFixedSize(int size) {
        String result = "";
        
        for(int i = 0; i < size; i++) {
            int iascii = randInt(97, 122);
            result += (char)iascii;
        }
        return result;
    }
    
    public static int randInt(int min, int max) {
        int result = random.nextInt(max + 1 - min);
        result += min;
        return result;
    }
    
    public static void main(String[] args) {
        int ct = 15;
        while (ct > 0) {
            //System.out.println(randInt(0, 200));
            System.out.println(randStringVarSize(2, 8));
            ct--;
        }
    }
    
}
