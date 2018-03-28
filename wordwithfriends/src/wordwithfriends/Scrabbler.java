/*Amanda J. Kendal-Brown
 *Words With Friends
 *Scrabbler.java
 */
package wordwithfriends;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

public class Scrabbler{
   static Scanner input = new Scanner(System.in);
   
   public static void main(String [] args){
      
      
      String words = null;
      String wordsfile = "src/txt/words.txt";
      
      DictionaryQueue dictionary = new DictionaryQueue();
      
      try{
         Scanner file = new Scanner(new File(wordsfile));
            while(file.hasNext()){   
               words = file.next();
               words.trim();
               dictionary.enqueue(new Repository(words));
            }
      }catch(FileNotFoundException fnfe){
         System.out.print("Can't Find words.txt File \n");
         System.exit(0);
      }
      
      System.out.println("Welcome to Scrabbler");
      System.out.println("Your Dictionary Contains " + dictionary.size() + " Words");
      System.out.println();
      
      int option = 0;
      do{
         System.out.println("1. Find all the words you can spell with 7 letters." + "\n" +
                            "2. Find all the words with a specific prefix." + "\n" +
                            "3. Find all the words with a specific suffix." + "\n" +
                            "4. Print Entire Dictionary" + "\n" +
                            "5. Exit Scrabbler.");
         System.out.println();
         System.out.print("Enter Option: ");
         
         try{
            option = input.nextInt();
            if(option < 1 || option > 5){
               System.out.println("Invalid Option, Please Try Again");
               input.nextLine();
            }
         }catch(InputMismatchException e){
            System.out.println("Invalid Option, Please Try Again");
            input.nextLine();
         }
         
         if(option == 1){
            input.nextLine();
            sevenLetters(dictionary);
         }
         else if(option == 2){
            input.nextLine();
            prefix(dictionary);
         }
         else if(option == 3){
            input.nextLine();
            suffix(dictionary);
         }
         else if(option == 4){
            input.nextLine();
            System.out.println(dictionary);
         }
         System.out.println();
      }while(option != 5);  
   }
   
   private static void sevenLetters(DictionaryQueue dictionary){
      String text = "";      
      do{
         System.out.print("Please Enter Seven or Less Characters: ");
         text = input.nextLine().toLowerCase().trim();
      }while(text.length() > 7 );
      
      dictionary.containChar(text);  
   }
   
   private static void prefix(DictionaryQueue dictionary){
      String text = "";
      
      System.out.print("Please Enter Desired Prefix: ");
      text = input.nextLine().toLowerCase(); 
      
      dictionary.containsPrefix(text);
   } 
   
   private static void suffix(DictionaryQueue dictionary){
      String text = "";
      
      System.out.print("Please Enter Desired Suffix: ");
      text = input.nextLine().toLowerCase(); 
      
      dictionary.containsSuffix(text);
   } 
} 

