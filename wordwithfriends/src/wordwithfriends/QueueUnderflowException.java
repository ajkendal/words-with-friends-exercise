/*Amanda J. Kendal-Brown
 *Words With Friends Problem
 *QueueUnderflowException.java
 */
package wordwithfriends;

public class QueueUnderflowException extends Exception{

   public QueueUnderflowException(){
      super();
   }
   
   public QueueUnderflowException(String message){
      super(message);
   }
}