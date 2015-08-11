/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashList;

/**
 *
 * @author swans_000
 */
public class Test {
    
    public static void main(String[] args) {
        int[] val = new int[]{1214, 8132, 2345};
        String strs[] = new String[]{"Pizza", "pizza", "cap"};
        for (int test : val) {
            System.out.println("value " + test + ":" + Integer.hashCode(test) % 47);
        }
        for (String str : strs) {
            System.out.println("value " + str + ": " + str.hashCode() % 47);
        }
    }
    
}
