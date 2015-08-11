/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashList;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author swans_000
 */
public class Hash {
    
    //ArrayList temp = new ArrayList<String>();
    LinkedList[] hash = new LinkedList[23];
    
    public Hash(){
    }
    
    public static void main(String[] args) {
        
        String[] files = new String[]{"A.txt", "B.txt", "C.txt"};
 
        Hash newhash = new Hash();
        
        for (String filename : files) {
            newhash.loadIn(filename);
        }
        newhash.printem();
        
        System.out.println(newhash.inclusive("the", "The"));
        
    }
    
    public void printem() {
        //for (String word : hash) {
        //    System.out.println(word);
        //}
        int i = 0;
        for (LinkedList ll : hash){
            System.out.print(i + ":");
            if (ll!= null){
                ll.printall();
            }
            System.out.println();
            i++;
        }
    }
    
    public int makeHash(String word) {
        int result = 0;
            for (int i = 0; i < word.length(); i++){
                result += word.charAt(i) * (i+1);
            }
        return result;
    }
    
    public void add(String word, String file){
        int checkhash = word.hashCode();
        // make negative hash values positive
        if (checkhash < 0){
            checkhash *= -1;
        }
        System.out.println("WORD " + word + "(hash=" + checkhash + 
                "; %23=" + checkhash % 23 + "; myhash=" + makeHash(word));
        //hash[checkhash % 23] = file;
        if (hash[checkhash % 23] == null){
            hash[checkhash % 23] = new LinkedList(word, file);
        } else {
            hash[checkhash % 23].add(word, file);
        }
        
    }
    
    public void loadIn(String fileName) {
        
        try{
            Scanner source = new Scanner(new File(fileName));
            while (source.hasNext()){
                this.add(source.next(), fileName);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
                
    }
    
    /*
    private Scanner openInputFile (String fileName) throws FileNotFoundException, Exception {
    
        File oFile = new File(fileName);
        
        if (!oFile.exists())
            throw new FileNotFoundException();
        
        if (!oFile.canRead())
            throw new Exception();
        
        Scanner fl = new Scanner(oFile);
        return fl;
        
    }*/
    public static ArrayList<String> union(LinkedList... lists){
        ArrayList<String> results = new ArrayList<>();
        
        for(LinkedList curList : lists){
            //curList.
        }
        
        return results;
    }
    
    public ArrayList<String> inclusive(String... strings){
        ArrayList<String> results = new ArrayList<>();
        
        for (String cur : strings) {
            
            int checkhash = cur.hashCode();
        // make negative hash values positive
            if (checkhash < 0){
                checkhash *= -1;
            }
            LinkedList curList = hash[checkhash % 23].listOfKey(cur);
            for (Object source : curList){
                results.add((String)source);
            }
        }
        
        return results;
    }
    
    
}
